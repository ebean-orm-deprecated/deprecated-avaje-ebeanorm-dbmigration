package org.avaje.ebean.dbmigration.ddlgeneration;

import org.avaje.ebean.dbmigration.migration.CreateTable;
import org.avaje.ebean.dbmigration.model.MConfiguration;

import java.io.IOException;

/**
 * Write table DDL.
 */
public interface TableDdl {

  /**
   * Generate the create table DDL.
   */
  void generate(DdlWrite writer, CreateTable createTable) throws IOException;
}
