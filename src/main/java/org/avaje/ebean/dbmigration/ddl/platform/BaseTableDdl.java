package org.avaje.ebean.dbmigration.ddl.platform;

import org.avaje.ebean.dbmigration.ddl.DdlBuffer;
import org.avaje.ebean.dbmigration.ddl.DdlWrite;
import org.avaje.ebean.dbmigration.migration.Column;
import org.avaje.ebean.dbmigration.migration.CreateTable;
import org.avaje.ebean.dbmigration.model.MConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 */
public class BaseTableDdl implements TableDdl {


  @Override
  public void generate(DdlWrite writer, CreateTable createTable, MConfiguration configuration) throws IOException {

    String tableName = createTable.getName();
    List<Column> columns = createTable.getColumn();
    List<Column> pk = determinePrimaryKeyColumns(columns);

    DdlBuffer apply = writer.apply();
    apply.append("create table ").append(tableName).append(" (").newLine();
    for (int i = 0; i < columns.size(); i++) {
      writeColumnDefinition(apply, columns.get(i));
      if (i < columns.size()-1) {
        apply.append(",");
      }
      apply.newLine();
    }
    apply.append(")").endOfStatement();

    if (!pk.isEmpty()) {
      alterTableAddPrimaryKey(apply, tableName, pk, configuration);
    }
    apply.end();

    // TODO: Add unique constraints

    writer.rollback().append("drop table ").append(tableName).endOfStatement().end();
  }

  protected void alterTableAddPrimaryKey(DdlBuffer buffer, String tableName, List<Column> pk, MConfiguration configuration) throws IOException {

    String pkName = determinePrimaryKeyName(tableName, pk);

    buffer.append("alter table ").append(tableName).append(" add primary key ").append(pkName).append(" ");
    buffer.append("(");
    for (int i = 0; i < pk.size(); i++) {
      if (i > 0) {
        buffer.append(",");
      }
      buffer.append(pk.get(i).getName());
    }
    buffer.append(")").endOfStatement();
  }

  protected String determinePrimaryKeyName(String tableName, List<Column> pk) {
    return "pk_"+tableName;
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

  protected void writeColumnDefinition(DdlBuffer buffer, Column column) throws IOException {

    buffer.append("  ");
    buffer.append(column.getName(), 30);
    buffer.append(column.getType());
    if (Boolean.TRUE.equals(column.isNotnull())) {
      buffer.append(" non null");
    }
    if (column.getCheckConstraint() != null) {
      buffer.append(" ").append(column.getCheckConstraint());
    }
  }

}
