package org.avaje.ebean.dbmigration.ddlgeneration.platform;

import org.avaje.ebean.dbmigration.ddlgeneration.DdlBuffer;
import org.avaje.ebean.dbmigration.ddlgeneration.DdlWrite;
import org.avaje.ebean.dbmigration.ddlgeneration.TableDdl;
import org.avaje.ebean.dbmigration.migration.Column;
import org.avaje.ebean.dbmigration.migration.CreateTable;
import org.avaje.ebean.dbmigration.model.MConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class BaseTableDdl implements TableDdl {

  protected boolean inlinePrimaryKeyConstraint = true;

  protected boolean inlineUniqueConstraint = true;

  protected boolean inlineCheckConstraints = true;

  public BaseTableDdl() {

  }

  @Override
  public void generate(DdlWrite writer, CreateTable createTable) throws IOException {

    String tableName = createTable.getName();
    List<Column> columns = createTable.getColumn();
    List<Column> pk = determinePrimaryKeyColumns(columns);

    DdlBuffer apply = writer.apply();
    apply.append("create table ").append(tableName).append(" (");
    for (int i = 0; i < columns.size(); i++) {
      apply.newLine();
      writeColumnDefinition(apply, columns.get(i));
      if (i < columns.size()-1) {
        apply.append(",");
      }
    }

    if (inlineCheckConstraints) {
      inlineCheckConstraints(apply,  createTable);
    }

    if (inlineUniqueConstraint) {
      inlineUniqueConstraints(apply, createTable);
    }
    if (inlinePrimaryKeyConstraint && !pk.isEmpty()) {
      inlinePrimaryKeyConstraint(apply, tableName, pk);
    }

    apply.newLine().append(")").endOfStatement();

    if (!inlinePrimaryKeyConstraint && !pk.isEmpty()) {
      alterTableAddPrimaryKey(apply, tableName, pk);
    }
    if (!inlineUniqueConstraint) {
      // TODO: Add unique constraints
    }
    apply.end();


    writer.rollback().append("drop table ").append(tableName).endOfStatement().end();
  }

  protected void inlineCheckConstraints(DdlBuffer apply, CreateTable createTable) throws IOException {

    List<Column> columns = createTable.getColumn();
    for (Column column : columns) {
      String checkConstraint = column.getCheckConstraint();
      if (!isEmpty(checkConstraint)) {
        inlineCheckConstraint(apply, createTable.getName(), column, checkConstraint);
      }
    }
  }

  private void inlineCheckConstraint(DdlBuffer buffer, String tableName, Column column, String checkConstraint) throws IOException {

    String ckName = determineCheckConstraintName(tableName, column);

    buffer.append(",").newLine();
    buffer.append("  constraint ").append(ckName);
    buffer.append(" ").append(checkConstraint);
  }

  /**
   * Write the unique constraints inline with the create table statement.
   */
  protected void inlineUniqueConstraints(DdlBuffer apply, CreateTable createTable) throws IOException {

    List<Column> columns = createTable.getColumn();
    for (Column column : columns) {
      if (isTrue(column.isUnique())) {
        inlineUniqueConstraintSingle(apply, createTable.getName(), column);
      }
    }

    //TODO: Write compound unique constraints

  }

  /**
   * Write the unique constraint inline with the create table statement.
   */
  protected void inlineUniqueConstraintSingle(DdlBuffer buffer, String tableName, Column column) throws IOException {

    String uqName = determineUniqueConstraintName(tableName, column);

    buffer.append(",").newLine();
    buffer.append("  constraint ").append(uqName).append(" unique ");
    buffer.append("(");
    buffer.append(column.getName());
    buffer.append(")");
  }

  /**
   * Write the primary key constraint inline with the create table statement.
   */
  protected void inlinePrimaryKeyConstraint(DdlBuffer buffer, String tableName, List<Column> pk) throws IOException {

    String pkName = determinePrimaryKeyName(tableName, pk);

    buffer.append(",").newLine();
    buffer.append("  constraint ").append(pkName).append(" primary key ");
    buffer.append("(");
    for (int i = 0; i < pk.size(); i++) {
      if (i > 0) {
        buffer.append(",");
      }
      buffer.append(pk.get(i).getName());
    }
    buffer.append(")");
  }

  protected void alterTableAddPrimaryKey(DdlBuffer buffer, String tableName, List<Column> pk) throws IOException {

    String pkName = determinePrimaryKeyName(tableName, pk);

    buffer.append("alter table ").append(tableName);
    buffer.append(" add primary key ").append(pkName).append(" (");
    for (int i = 0; i < pk.size(); i++) {
      if (i > 0) {
        buffer.append(",");
      }
      buffer.append(pk.get(i).getName());
    }
    buffer.append(")").endOfStatement();
  }

  protected void writeColumnDefinition(DdlBuffer buffer, Column column) throws IOException {

    buffer.append("  ");
    buffer.append(column.getName(), 30);
    buffer.append(column.getType());
    if (isTrue(column.isNotnull()) || isTrue(column.isPrimaryKey())) {
      buffer.append(" not null");
    }

    // add check constraints later as we really want to give them a nice name
    // so that the database can potentially provide a nice SQL error
  }


  protected String determinePrimaryKeyName(String tableName, List<Column> pkColumns) {
    return "pk_" + tableName;
  }

  protected String determineUniqueConstraintName(String tableName, Column column) {
    return "uq_" + tableName + "_" + column.getName();
  }

  protected String determineCheckConstraintName(String tableName, Column column) {
    return "ck_" + tableName + "_" + column.getName();
  }


  protected List<Column> determinePrimaryKeyColumns(List<Column> columns) {
    List<Column> pk = new ArrayList<>(3);
    for (Column column : columns) {
      if (Boolean.TRUE.equals(column.isPrimaryKey())) {
        pk.add(column);
      }
    }
    return pk;
  }


  protected boolean isEmpty(String value) {
    return value == null || value.trim().isEmpty();
  }

  protected boolean isTrue(Boolean value) {
    return Boolean.TRUE.equals(value);
  }


}
