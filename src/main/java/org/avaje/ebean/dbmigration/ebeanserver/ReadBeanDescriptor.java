package org.avaje.ebean.dbmigration.ebeanserver;

import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
import com.avaje.ebeaninternal.server.deploy.BeanProperty;
import com.avaje.ebeaninternal.server.deploy.BeanPropertyAssoc;
import com.avaje.ebeaninternal.server.deploy.BeanPropertyAssocOne;
import org.avaje.ebean.dbmigration.model.MColumn;
import org.avaje.ebean.dbmigration.model.MTable;
import org.avaje.ebean.dbmigration.model.ModelContainer;

/**
 * Created by rob on 30/07/15.
 */
public class ReadBeanDescriptor {

//  final BeanDescriptor desc;
//
//  final MTable table;
//
//  public ReadBeanDescriptor(BeanDescriptor desc) {
//    this.desc = desc;
//    this.table = new MTable(desc.getBaseTable());
//  }
//
//  public void read(ModelContainer model) {
//
//    model.addTable(table);
//
//    readId();
//
//    BeanPropertyAssocOne<?> unidirectional = desc.getUnidirectional();
//    if (unidirectional != null) {
//      readColumn(unidirectional);
//    }
//
//    BeanProperty[] propertiesNonTransient = desc.propertiesNonTransient();
//    for (int i = 0; i < propertiesNonTransient.length; i++) {
//      BeanProperty p = propertiesNonTransient[i];
//      if (!p.isFormula() && !p.isSecondaryTable()) {
//        readColumn(p);
//      }
//    }
//
//  }
//
//  private void readId() {
//
//    BeanProperty idProp = desc.getIdProperty();
//    if (idProp != null) {
//      readColumn(idProp);
//      if (idProp.isEmbedded()) {
//        // create compound primary key
//      }
//    }
//  }
//
//  private void readColumn(BeanProperty property) {
//
//    if (property instanceof BeanPropertyAssoc<?>) {
//      BeanPropertyAssoc<?> assoc = (BeanPropertyAssoc<?>)property;
//      if (assoc.isEmbedded()) {
//        assoc.getTargetDescriptor()
//
//      } else {
//
//      }
//    } else {
//      readSingleColumn(property);
//    }
//  }
//
//  private void readSingleColumn(BeanProperty property) {
//    MColumn column = new MColumn(property.getDbColumn(), property.getDbColumnDefnDerived());
//    column.setCheckConstraint(property.getDbConstraintExpression());
//    column.setNotnull(property.isNullable());
//    table.addColumn(column);
//  }
}
