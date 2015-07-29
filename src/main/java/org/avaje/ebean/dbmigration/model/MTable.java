package org.avaje.ebean.dbmigration.model;

import org.avaje.ebean.dbmigration.migration.AddColumn;
import org.avaje.ebean.dbmigration.migration.Column;
import org.avaje.ebean.dbmigration.migration.CreateTable;
import org.avaje.ebean.dbmigration.migration.DropColumn;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Holds the logical model for a given Table.
 * <p>
 *   Migrations can be applied to this such that it represents the state
 *   of a given table after various migrations have been applied.
 * </p>
 */
public class MTable {


  private final String name;
  private final String indexTablespace;

  private String remarks;

  private String tablespace;

  private Boolean withHistory;

  private Map<String,MColumn> columns = new LinkedHashMap<>();

  public MTable(CreateTable createTable) {
    this.name = createTable.getName();
    this.remarks = createTable.getRemarks();
    this.tablespace = createTable.getTablespace();
    this.indexTablespace = createTable.getIndexTablespace();
    this.withHistory = createTable.isWithHistory();
    List<Column> cols = createTable.getColumn();
    for (Column column : cols) {
      addColumn(column);
    }
  }

  /**
   * Apply AddColumn migration.
   */
  public void apply(AddColumn addColumn) {
    checkTableName(addColumn.getTableName());
    List<Column> cols = addColumn.getColumn();
    for (Column column : cols) {
      addColumn(column);
    }
  }

  /**
   * Apply DropColumn migration.
   */
  public void apply(DropColumn dropColumn) {
    checkTableName(dropColumn.getTableName());
    String columnName = dropColumn.getColumnName();
    columns.remove(columnName);
  }

  public String getName() {
    return name;
  }

  public String getRemarks() {
    return remarks;
  }

  public String getTablespace() {
    return tablespace;
  }

  public String getIndexTablespace() {
    return indexTablespace;
  }

  public Boolean getWithHistory() {
    return withHistory;
  }

  public Map<String, MColumn> getColumns() {
    return columns;
  }

  private void checkTableName(String tableName) {
    if (!name.equals(tableName)) {
      throw new IllegalArgumentException("addColumn tableName ["+tableName+"] does not match ["+name+"]");
    }
  }

  private void addColumn(Column column) {
    columns.put(column.getName(), new MColumn(column));
  }

}
