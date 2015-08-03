package org.avaje.ebean.dbmigration.ddlgeneration.platform;


import com.avaje.ebean.config.dbplatform.DbTypeMap;
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

    BaseTableDdl ddlGen = new BaseTableDdl(new DdlNamingConvention(), new PlatformDdl(new DbTypeMap()));

    DdlWrite write = new DdlWrite();


    ddlGen.generate(write, createTable());
    String apply = write.apply().getBuffer();
    String applyLast = write.applyLast().getBuffer();

    String rollbackFirst = write.rollbackFirst().getBuffer();
    String rollbackLast = write.rollbackLast().getBuffer();

    assertThat(apply).isEqualTo( Helper.asText(this, "/assert/BaseTableDdlTest/createTable-apply.txt"));
    assertThat(applyLast).isEqualTo( Helper.asText(this, "/assert/BaseTableDdlTest/createTable-applyLast.txt"));
    assertThat(rollbackFirst).isEqualTo( Helper.asText(this, "/assert/BaseTableDdlTest/createTable-rollbackFirst.txt"));
    assertThat(rollbackLast).isEqualTo( Helper.asText(this, "/assert/BaseTableDdlTest/createTable-rollback.txt"));


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
    col2.setCheckConstraint("check (status in ('A','B'))");

    columns.add(col2);

    Column col3 = new Column();
    col3.setName("order_id");
    col3.setType("integer");
    col3.setNotnull(true);
    col3.setReferences("orders.id");

    columns.add(col3);

    return createTable;
  }
}