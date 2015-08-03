package org.avaje.ebean.dbmigration.ddlgeneration;

import org.avaje.ebean.dbmigration.ddlgeneration.platform.BaseColumnDdl;
import org.avaje.ebean.dbmigration.ddlgeneration.platform.BaseTableDdl;
import org.avaje.ebean.dbmigration.ddlgeneration.platform.DdlNamingConvention;
import org.avaje.ebean.dbmigration.ddlgeneration.platform.PlatformDdl;
import org.avaje.ebean.dbmigration.migration.AddColumn;
import org.avaje.ebean.dbmigration.migration.ChangeSet;
import org.avaje.ebean.dbmigration.migration.CreateTable;
import org.avaje.ebean.dbmigration.migration.DropColumn;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public class BaseDdlHandler implements DdlHandler {

  protected final ColumnDdl columnDdl;

  protected final TableDdl tableDdl;

  public BaseDdlHandler(DdlNamingConvention namingConvention, PlatformDdl platformDdl) {
    this.tableDdl = new BaseTableDdl(namingConvention, platformDdl);
    this.columnDdl = new BaseColumnDdl();
  }

  @Override
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

  @Override
  public void generate(DdlWrite writer, CreateTable createTable) throws IOException {
    tableDdl.generate(writer, createTable);
  }

  @Override
  public void generate(DdlWrite writer, AddColumn addColumn) throws IOException {
    columnDdl.generate(writer, addColumn);
  }

  @Override
  public void generate(DdlWrite writer, DropColumn dropColumn) throws IOException {
    columnDdl.generate(writer, dropColumn);
  }

}
