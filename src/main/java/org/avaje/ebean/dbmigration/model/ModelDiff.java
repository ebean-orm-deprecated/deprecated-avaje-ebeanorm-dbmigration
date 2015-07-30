package org.avaje.ebean.dbmigration.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Used to prepare a diff in terms of changes required to migrate from
 * the base model to the newer model.
 */
public class ModelDiff {

  private final ModelContainer baseModel;

  /**
   * List of 'create' type changes.
   */
  private final List<Object> createChanges = new ArrayList<>();

  /**
   * List of 'drop' type changes. Potential for putting into a separate changeSet.
   */
  private final List<Object> dropChanges = new ArrayList<>();

  /**
   * Construct with a base model.
   */
  public ModelDiff(ModelContainer baseModel) {
    this.baseModel = baseModel;
  }

  /**
   * Construct with a base model.
   */
  public ModelDiff() {
    this.baseModel = new ModelContainer();
  }

  /**
   * Return the list of 'create' changes.
   */
  public List<Object> getCreateChanges() {
    return createChanges;
  }

  /**
   * Return the list of 'drop' changes.
   */
  public List<Object> getDropChanges() {
    return dropChanges;
  }

  /**
   * Compare to a 'newer' model and collect the differences.
   */
  public void compareTo(ModelContainer newModel) {

    Map<String, MTable> tables = newModel.getTables();
    Collection<MTable> values = tables.values();
    for (MTable newTable : values) {

      MTable currentTable = baseModel.getTable(newTable.getName());
      if (currentTable == null) {
        addNewTable(newTable);
      } else {
        compareTables(currentTable, newTable);
      }
    }

    //TODO: other parts of the model? views, indexes etc


  }

  private void addNewTable(MTable newTable) {

    createChanges.add(newTable.createTable());
  }

  private void compareTables(MTable currentTable, MTable newTable) {

    // changed columns
    // find additional columns
    // find removed columns
    // changes to indexes?
    // changes to primary key
    // changes to foreign key
    // changes to unique constraints?

  }
}
