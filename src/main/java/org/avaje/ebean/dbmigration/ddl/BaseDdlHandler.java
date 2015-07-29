package org.avaje.ebean.dbmigration.ddl;

import org.avaje.ebean.dbmigration.ddl.platform.BaseColumnDdl;
import org.avaje.ebean.dbmigration.ddl.platform.BaseTableDdl;
import org.avaje.ebean.dbmigration.ddl.platform.ColumnDdl;
import org.avaje.ebean.dbmigration.ddl.platform.TableDdl;
import org.avaje.ebean.dbmigration.migration.AddColumn;
import org.avaje.ebean.dbmigration.migration.ChangeSet;
import org.avaje.ebean.dbmigration.migration.CreateTable;
import org.avaje.ebean.dbmigration.migration.DropColumn;
import org.avaje.ebean.dbmigration.model.MConfiguration;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public class BaseDdlHandler implements DdlHandler {

  protected MConfiguration configuration;

  protected ColumnDdl columnDdl;

  protected TableDdl tableDdl;

  public BaseDdlHandler() {
    columnDdl = new BaseColumnDdl();
    tableDdl = new BaseTableDdl();
  }

  /**
   * Set the configuration such as default tablespaces to use for tables, indexes etc.
   */
  public void apply(MConfiguration configuration) {
    this.configuration = configuration;
  }

  @Override
  public void generate(DdlWrite writer, CreateTable createTable) throws IOException {
    tableDdl.generate(writer, createTable, configuration);
  }

  @Override
  public void generate(DdlWrite writer, AddColumn addColumn) throws IOException {
    columnDdl.generate(writer, addColumn);
  }

  @Override
  public void generate(DdlWrite writer, DropColumn dropColumn) throws IOException {
    columnDdl.generate(writer, dropColumn);
  }

  public void generate(DdlWrite writer, ChangeSet changeSet) throws IOException {

    List<Object> changeSetChildren = changeSet.getChangeSetChildren();
    for (Object change : changeSetChildren) {
      if (change instanceof  CreateTable) {
        generate(writer, (CreateTable) change);
      } else if (change instanceof AddColumn) {
        generate(writer, (AddColumn) change);
      } else if (change instanceof DropColumn) {
        generate(writer, (DropColumn) change);
      }
    }
  }

}
