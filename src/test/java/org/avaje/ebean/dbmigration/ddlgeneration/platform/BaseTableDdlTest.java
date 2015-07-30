package org.avaje.ebean.dbmigration.ddlgeneration.platform;


import org.avaje.ebean.dbmigration.ddlgeneration.DdlWrite;
import org.avaje.ebean.dbmigration.ddlgeneration.Helper;
import org.avaje.ebean.dbmigration.migration.Column;
import org.avaje.ebean.dbmigration.migration.CreateTable;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class BaseTableDdlTest {

  @Test
  public void testGenerate() throws Exception {


    BaseTableDdl ddlGen = new BaseTableDdl();

    DdlWrite write = new DdlWrite();


    ddlGen.generate(write, createTable());
    String apply = write.apply().getBuffer();

    String expected = Helper.asText(this, "/assert/BaseTableDdlTest/createTable.txt");
    assertThat(apply).isEqualTo(expected);

  }

  private CreateTable createTable() {
    CreateTable createTable = new CreateTable();
    createTable.setName("mytable");
    List<Column> columns = createTable.getColumn();
    Column col = new Column();
    col.setName("id");
    col.setType("integer");
    col.setPrimaryKey(true);

    columns.add(col);

    Column col2 = new Column();
    col2.setName("status");
    col2.setType("varchar(1)");
    col2.setNotnull(true);
    col2.setCheckConstraint("in ('A','B')");

    columns.add(col2);

    return createTable;
  }
}