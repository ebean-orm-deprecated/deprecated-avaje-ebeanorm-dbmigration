package org.avaje.ebean.dbmigration.ddl;

import org.avaje.ebean.dbmigration.migration.AddColumn;
import org.avaje.ebean.dbmigration.migration.ChangeSet;
import org.avaje.ebean.dbmigration.migration.CreateTable;
import org.avaje.ebean.dbmigration.migration.DropColumn;
import org.avaje.ebean.dbmigration.model.MConfiguration;

import java.io.IOException;
import java.io.Writer;

/**
 */
public interface DdlHandler {

  void apply(MConfiguration configuration);

  void generate(DdlWrite writer, ChangeSet changeSet) throws IOException;

  void generate(DdlWrite writer, CreateTable createTable) throws IOException;

  void generate(DdlWrite writer, AddColumn addColumn) throws IOException;

  void generate(DdlWrite writer, DropColumn dropColumn) throws IOException;
}
