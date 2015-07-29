package org.avaje.ebean.dbmigration.ddl.platform;

import org.avaje.ebean.dbmigration.ddl.DdlWrite;
import org.avaje.ebean.dbmigration.migration.CreateTable;
import org.avaje.ebean.dbmigration.model.MConfiguration;

import java.io.IOException;

/**
 *
 */
public interface TableDdl {

  /**
   * Generate the create table DDL.
   */
  void generate(DdlWrite writer, CreateTable createTable, MConfiguration configuration) throws IOException;
}
