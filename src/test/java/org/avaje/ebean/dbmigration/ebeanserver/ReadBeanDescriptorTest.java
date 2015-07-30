package org.avaje.ebean.dbmigration.ebeanserver;

import com.avaje.ebean.Ebean;
import com.avaje.ebeaninternal.api.SpiEbeanServer;
import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
import org.avaje.ebean.dbmigration.model.MColumn;
import org.avaje.ebean.dbmigration.model.MTable;
import org.avaje.ebean.dbmigration.model.ModelContainer;
import org.example.domain.Customer;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadBeanDescriptorTest {

  @Test
  public void testRead() throws Exception {

//    SpiEbeanServer server = (SpiEbeanServer)Ebean.getDefaultServer();
//
//    BeanDescriptor<Customer> desc = server.getBeanDescriptor(Customer.class);
//
//    ModelContainer model = new ModelContainer();
//
//    ReadBeanDescriptor reader = new ReadBeanDescriptor(desc);
//    reader.read(model);
//
//    MTable customer = model.getTable("be_customer");
//    assertThat(customer).isNotNull();
//
//    Map<String, MColumn> columns = customer.getColumns();
//    assertThat(columns).containsKeys("id","version","when_created","name", "registered", "comments","billing_address_id");
//
//    assertThat(columns.get("id").getType()).isEqualTo("integer");
  }
}