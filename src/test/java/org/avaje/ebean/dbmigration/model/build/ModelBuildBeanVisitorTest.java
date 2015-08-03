package org.avaje.ebean.dbmigration.model.build;


import com.avaje.ebean.Ebean;
import com.avaje.ebeaninternal.api.SpiEbeanServer;
import org.avaje.ebean.dbmigration.model.MTable;
import org.avaje.ebean.dbmigration.model.ModelContainer;
import org.avaje.ebean.dbmigration.model.visitor.VisitAllUsing;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ModelBuildBeanVisitorTest {

  @Test
  public void test() {

    SpiEbeanServer defaultServer = (SpiEbeanServer)Ebean.getDefaultServer();

    ModelContainer model = new ModelContainer();

    ModelBuildContext ctx = new ModelBuildContext(model);
    ModelBuildBeanVisitor addTable = new ModelBuildBeanVisitor(ctx);

    new VisitAllUsing(addTable, defaultServer).visitAllBeans();

    MTable customer = model.getTable("be_customer");

    assertThat(customer).isNotNull();

  }
}