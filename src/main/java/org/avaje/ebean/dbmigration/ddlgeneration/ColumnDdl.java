package org.avaje.ebean.dbmigration.ddlgeneration;

import org.avaje.ebean.dbmigration.migration.AddColumn;
import org.avaje.ebean.dbmigration.migration.DropColumn;

import java.io.IOException;

/**
 * Write AddColumn or DropColumn.
 */
public interface ColumnDdl {

  /**
   * Write a AddColumn change.
   */
  void generate(DdlWrite writer, AddColumn addColumn) throws IOException;

  /**
   * Write a DropColumn change.
   */
  void generate(DdlWrite writer, DropColumn dropColumn) throws IOException;

}
