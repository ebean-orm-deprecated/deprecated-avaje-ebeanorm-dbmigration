package org.avaje.ebean.dbmigration.ddlgeneration;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.config.dbplatform.DbTypeMap;
import com.avaje.ebean.config.dbplatform.PostgresPlatform;
import com.avaje.ebeaninternal.api.SpiEbeanServer;
import org.avaje.ebean.dbmigration.ddlgeneration.platform.DdlNamingConvention;
import org.avaje.ebean.dbmigration.ddlgeneration.platform.PlatformDdl;
import org.avaje.ebean.dbmigration.ddlgeneration.platform.PostgresDdl;
import org.avaje.ebean.dbmigration.migration.ChangeSet;
import org.avaje.ebean.dbmigration.model.build.ModelServerReader;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseDdlHandlerTest {


  private BaseDdlHandler standardHandler() {
    return new BaseDdlHandler(new DdlNamingConvention(), new PlatformDdl(new DbTypeMap()));
  }

  private BaseDdlHandler postgresHandler() {
    DbTypeMap pgTypes = new PostgresPlatform().getDbTypeMap();
    PostgresDdl pgDdl = new PostgresDdl(pgTypes);
    return new BaseDdlHandler(new DdlNamingConvention(), pgDdl);
  }

  @Test
  public void addColumn_nullable_noConstraint() throws Exception {

    DdlWrite write = new DdlWrite();

    BaseDdlHandler handler = standardHandler();
    handler.generate(write, Helper.getAddColumn());

    assertThat(write.apply().getBuffer()).isEqualTo("alter table foo add column added_to_foo varchar(20);\n\n");
    assertThat(write.rollbackLast().getBuffer()).isEqualTo("alter table foo drop column added_to_foo;\n\n");
  }

  @Test
  public void dropColumn() throws Exception {

    DdlWrite write = new DdlWrite();
    BaseDdlHandler handler = standardHandler();

    handler.generate(write, Helper.getDropColumn());

    assertThat(write.apply().getBuffer()).isEqualTo("alter table foo drop column col2;\n\n");
    assertThat(write.rollbackLast().getBuffer()).isEqualTo("");
  }


  @Test
  public void createTable() throws Exception {

    DdlWrite write = new DdlWrite();
    BaseDdlHandler handler = standardHandler();

    handler.generate(write, Helper.getCreateTable());

    String createTableDDL = Helper.asText(this, "/assert/create-table.txt");

    assertThat(write.apply().getBuffer()).isEqualTo(createTableDDL);
    assertThat(write.rollbackLast().getBuffer()).isEqualTo("drop table foo;\n\n");
  }

  @Test
  public void generateChangeSet() throws Exception {

    DdlWrite write = new DdlWrite();
    BaseDdlHandler handler = standardHandler();

    handler.generate(write, Helper.getChangeSet());

    String apply = Helper.asText(this, "/assert/BaseDdlHandlerTest/apply.sql");
    String rollbackLast = Helper.asText(this, "/assert/BaseDdlHandlerTest/rollback.sql");

    assertThat(write.apply().getBuffer()).isEqualTo(apply);
    assertThat(write.rollbackLast().getBuffer()).isEqualTo(rollbackLast);
  }


  @Test
  public void generateChangeSetFromModel() throws Exception {

    SpiEbeanServer defaultServer = (SpiEbeanServer) Ebean.getDefaultServer();

    ModelServerReader reader = new ModelServerReader(defaultServer);
    ChangeSet createChangeSet = reader.buildAsCreateChangeSet();

    DdlWrite write = new DdlWrite();

    BaseDdlHandler handler = standardHandler();
    handler.generate(write, createChangeSet);

    String apply = Helper.asText(this, "/assert/changeset-apply.txt");
    String rollbackLast = Helper.asText(this, "/assert/changeset-rollback.txt");

    assertThat(write.apply().getBuffer()).isEqualTo(apply);
    assertThat(write.rollbackLast().getBuffer()).isEqualTo(rollbackLast);
  }

  @Test
  public void generateChangeSetFromModel_given_postgresTypes() throws Exception {

    SpiEbeanServer defaultServer = (SpiEbeanServer) Ebean.getDefaultServer();

    ModelServerReader reader = new ModelServerReader(defaultServer);
    ChangeSet createChangeSet = reader.buildAsCreateChangeSet();

    DdlWrite write = new DdlWrite();

    BaseDdlHandler handler = postgresHandler();
    handler.generate(write, createChangeSet);

    String apply = Helper.asText(this, "/assert/changeset-pg-apply.sql");
    String applyLast = Helper.asText(this, "/assert/changeset-pg-applyLast.sql");
    String rollbackFirst = Helper.asText(this, "/assert/changeset-pg-rollbackFirst.sql");
    String rollbackLast = Helper.asText(this, "/assert/changeset-pg-rollbackLast.sql");

    assertThat(write.apply().getBuffer()).isEqualTo(apply);
    assertThat(write.applyLast().getBuffer()).isEqualTo(applyLast);
    assertThat(write.rollbackFirst().getBuffer()).isEqualTo(rollbackFirst);
    assertThat(write.rollbackLast().getBuffer()).isEqualTo(rollbackLast);
  }

}