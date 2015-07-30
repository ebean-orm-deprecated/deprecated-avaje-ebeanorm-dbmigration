package org.avaje.ebean.dbmigration.ebeanserver;

import com.avaje.ebeaninternal.api.SpiEbeanServer;
import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
import org.avaje.ebean.dbmigration.model.ModelContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Read the model from the EbeanServer.
 */
public class ReadEbeanServerModel {

//  private static final Logger logger = LoggerFactory.getLogger(ReadEbeanServerModel.class);
//
//  private final SpiEbeanServer server;
//
//  private final ModelContainer container = new ModelContainer();
//
//  public ReadEbeanServerModel(SpiEbeanServer server) {
//    this.server = server;
//  }
//
//  public void read(ModelContainer model) {
//
//    List<BeanDescriptor<?>> beanDescriptors = server.getBeanDescriptors();
//
//    for (BeanDescriptor<?> beanDescriptor : beanDescriptors) {
//      readDescriptor(model, beanDescriptor);
//    }
//
//  }
//
//  private void readDescriptor(ModelContainer model, BeanDescriptor<?> desc) {
//
//    if (desc.getBaseTable() == null) {
//      logger.debug("skip {} - no base table", desc.getFullName());
//      return;
//    }
//    if (!desc.isInheritanceRoot()) {
//      logger.debug("skip {} - not inheritance root", desc.getFullName());
//      return;
//    }
//
//    ReadBeanDescriptor reader = new ReadBeanDescriptor(desc);
//    reader.read(model);
//  }

}
