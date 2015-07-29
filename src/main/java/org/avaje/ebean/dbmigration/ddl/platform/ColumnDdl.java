package org.avaje.ebean.dbmigration.ddl.platform;

import org.avaje.ebean.dbmigration.ddl.DdlWrite;
import org.avaje.ebean.dbmigration.migration.AddColumn;
import org.avaje.ebean.dbmigration.migration.DropColumn;

import java.io.IOException;

/**
 * Created by rob on 29/07/15.
 */
public interface ColumnDdl {

  void generate(DdlWrite writer, AddColumn addColumn) throws IOException;

  void generate(DdlWrite writer, DropColumn dropColumn) throws IOException;

}
