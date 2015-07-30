package org.avaje.ebean.dbmigration.model;

/**
 * A unique constraint for multiple columns.
 * <p>
 *   Note that unique constraint on a single column is instead
 *   a boolean flag on the associated MColumn.
 * </p>
 */
public class MCompoundUniqueConstraint {

  /**
   * The optional name of the constraint.
   */
  protected final String name;

  /**
   * The columns combined to be unique.
   */
  protected final String[] columns;

  public MCompoundUniqueConstraint(String[] columns) {
    this.name = null;
    this.columns = columns;
  }

  public MCompoundUniqueConstraint(String name, String[] columns) {
    this.name = name;
    this.columns = columns;
  }

  public String getName() {
    return name;
  }

  public String[] getColumns() {
    return columns;
  }
}
