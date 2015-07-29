package org.avaje.ebean.dbmigration.ddl;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseDdlHandlerTest {


  @Test
  public void addColumn_nullable_noConstraint() throws Exception {

    DdlWrite write = new DdlWrite();
    BaseDdlHandler handler = new BaseDdlHandler();

    handler.generate(write, Helper.getAddColumn());

    assertThat(write.apply().getBuffer()).isEqualTo("alter table foo add column added_to_foo varchar(20);\n\n");
    assertThat(write.rollback().getBuffer()).isEqualTo("alter table foo drop column added_to_foo;\n\n");
  }

  @Test
  public void dropColumn() throws Exception {

    DdlWrite write = new DdlWrite();
    BaseDdlHandler handler = new BaseDdlHandler();

    handler.generate(write, Helper.getDropColumn());

    assertThat(write.apply().getBuffer()).isEqualTo("alter table foo drop column col2;\n\n");
    assertThat(write.rollback().getBuffer()).isEqualTo("");
  }


  @Test
  public void createTable() throws Exception {

    DdlWrite write = new DdlWrite();
    BaseDdlHandler handler = new BaseDdlHandler();

    handler.generate(write, Helper.getCreateTable());

    String createTableDDL = Helper.asText(this, "/assert/create-table.txt");

    assertThat(write.apply().getBuffer()).isEqualTo(createTableDDL);
    assertThat(write.rollback().getBuffer()).isEqualTo("drop table foo;\n\n");
  }

  @Test
  public void generateChangeSet() throws Exception {

    DdlWrite write = new DdlWrite();
    BaseDdlHandler handler = new BaseDdlHandler();

    handler.generate(write, Helper.getChangeSet());

    String applyDdl = Helper.asText(this, "/assert/changeset-apply.txt");
    String rollbackDdl = Helper.asText(this, "/assert/changeset-rollback.txt");

    assertThat(write.apply().getBuffer()).isEqualTo(applyDdl);
    assertThat(write.rollback().getBuffer()).isEqualTo(rollbackDdl);
  }
}