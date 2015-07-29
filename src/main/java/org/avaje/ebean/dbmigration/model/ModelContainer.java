package org.avaje.ebean.dbmigration.model;

import org.avaje.ebean.dbmigration.migration.AddColumn;
import org.avaje.ebean.dbmigration.migration.ChangeSet;
import org.avaje.ebean.dbmigration.migration.CreateTable;
import org.avaje.ebean.dbmigration.migration.DropColumn;
import org.avaje.ebean.dbmigration.migration.Migration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Holds all the tables, views, indexes etc that represent the model.
 * <p>
 *   Migration changeSets can be applied to the model.
 * </p>
 */
public class ModelContainer {

  private Map<String,MTable> tables = new LinkedHashMap<>();

  public MTable getTable(String tableName) {
    return tables.get(tableName);
  }


  public void apply(Migration migration) {

    List<ChangeSet> changeSets = migration.getChangeSet();
    for (ChangeSet changeSet : changeSets) {
      applyChangeSet(changeSet);
    }
  }

  private void applyChangeSet(ChangeSet changeSet) {

    List<Object> changeSetChildren = changeSet.getChangeSetChildren();
    for (Object change : changeSetChildren) {
      if (change instanceof  CreateTable) {
        applyChange((CreateTable) change);
      } else if (change instanceof AddColumn) {
        applyChange((AddColumn) change);
      } else if (change instanceof DropColumn) {
          applyChange((DropColumn) change);
      }
    }
  }

  private void applyChange(CreateTable createTable) {
    String tableName = createTable.getName();
    if (tables.containsKey(tableName)) {
      throw new IllegalStateException("Table ["+tableName+"] already exists?");
    }
    MTable table = new MTable(createTable);
    tables.put(tableName, table);
  }

  private void applyChange(AddColumn addColumn) {
    MTable table = tables.get(addColumn.getTableName());
    if (table == null) {
      throw new IllegalStateException("Table ["+addColumn.getTableName()+"] does not exist?");
    }
    table.apply(addColumn);
  }

  private void applyChange(DropColumn dropColumn) {
    MTable table = tables.get(dropColumn.getTableName());
    if (table == null) {
      throw new IllegalStateException("Table ["+dropColumn.getTableName()+"] does not exist?");
    }
    table.apply(dropColumn);
  }

}
