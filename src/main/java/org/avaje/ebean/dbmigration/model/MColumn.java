package org.avaje.ebean.dbmigration.model;

import org.avaje.ebean.dbmigration.migration.Column;

/**
 * Created by rob on 28/07/15.
 */
public class MColumn {

  private final String name;
  private final String checkConstraint;
  private final String defaultValue;
  private final String references;
  private final String type;

  public MColumn(Column column) {
    this.name = column.getName();
    this.type = column.getType();
    this.checkConstraint = column.getCheckConstraint();
    this.defaultValue = column.getDefaultValue();
    this.references = column.getReferences();
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getCheckConstraint() {
    return checkConstraint;
  }

  public String getDefaultValue() {
    return defaultValue;
  }

  public String getReferences() {
    return references;
  }

}
