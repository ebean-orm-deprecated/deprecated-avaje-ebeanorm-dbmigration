package org.avaje.ebean.dbmigration.model;

import org.avaje.ebean.dbmigration.migration.AddColumn;
import org.avaje.ebean.dbmigration.migration.ChangeSet;
import org.avaje.ebean.dbmigration.migration.CreateTable;
import org.avaje.ebean.dbmigration.migration.DropColumn;
import org.avaje.ebean.dbmigration.migration.Migration;
import org.avaje.ebean.dbmigration.migrationreader.MigrationXmlReader;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ModelContainerApplyTest {

  @Test
  public void testApply() throws Exception {

    Migration migration = MigrationXmlReader.read("/test/container/test-create-table.xml");

    List<ChangeSet> changeSets = migration.getChangeSet();
    ChangeSet changeSet = changeSets.get(0);

    List<Object> changeSetChildren = changeSet.getChangeSetChildren();
    assertThat(changeSetChildren).hasSize(3);
    assertThat(changeSetChildren.get(0)).isInstanceOf(CreateTable.class);
    assertThat(changeSetChildren.get(1)).isInstanceOf(AddColumn.class);
    assertThat(changeSetChildren.get(2)).isInstanceOf(DropColumn.class);

    ModelContainer model = new ModelContainer();
    model.apply(migration);

    MTable foo = model.getTable("foo");
    assertThat(foo.getRemarks()).isEqualTo("comment");
    assertThat(foo.getTablespace()).isEqualTo("fooSpace");
    assertThat(foo.getIndexTablespace()).isEqualTo("fooIndexSpace");
    assertThat(foo.getWithHistory()).isEqualTo(true);
    assertThat(foo.getColumns()).containsKeys("col1", "col3", "added_to_foo");
  }
}