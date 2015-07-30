package org.avaje.ebean.dbmigration.model.build;


import com.avaje.ebean.Ebean;
import com.avaje.ebean.config.dbplatform.DbTypeMap;
import com.avaje.ebeaninternal.api.SpiEbeanServer;
import org.avaje.ebean.dbmigration.model.MTable;
import org.avaje.ebean.dbmigration.model.ModelContainer;
import org.avaje.ebean.dbmigration.model.visitor.BeanPropertyVisitor;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ModelBuildBeanVisitorTest {

  @Test
  public void test() {

    SpiEbeanServer defaultServer = (SpiEbeanServer)Ebean.getDefaultServer();

    ModelContainer model = new ModelContainer();

    DbTypeMap dbTypeMap = defaultServer.getDatabasePlatform().getDbTypeMap();

    ModelBuildContext ctx = new ModelBuildContext(dbTypeMap, model);
    ModelBuildBeanVisitor addTable = new ModelBuildBeanVisitor(ctx);

    new BeanPropertyVisitor(addTable, defaultServer).visitAllBeans();

    MTable customer = model.getTable("be_customer");

    assertThat(customer).isNotNull();

  }
}