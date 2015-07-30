package org.avaje.ebean.dbmigration.model.visitor;

import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
import com.avaje.ebeaninternal.server.deploy.BeanProperty;
import com.avaje.ebeaninternal.server.deploy.InheritInfo;
import com.avaje.ebeaninternal.server.deploy.InheritInfoVisitor;

/**
 * Base BeanVisitor that can help visiting inherited properties.
 */
public class BeanInheritanceVisitor {

//  /**
//   * Visit all the other inheritance properties that are not on the root.
//   */
//  public void visitInheritanceProperties(BeanDescriptor<?> descriptor, PropertyVisitor pv) {
//
//    InheritInfo inheritInfo = descriptor.getInheritInfo();
//    if (inheritInfo != null && inheritInfo.isRoot()) {
//      // add all properties on the children objects
//      InheritChildVisitor childVisitor = new InheritChildVisitor(pv);
//      inheritInfo.visitChildren(childVisitor);
//    }
//  }
//
//
//  /**
//   * Helper used to visit all the inheritInfo/BeanDescriptor in
//   * the inheritance hierarchy (to add their 'local' properties).
//   */
//  protected static class InheritChildVisitor implements InheritInfoVisitor {
//
//    final PropertyVisitor pv;
//
//    protected InheritChildVisitor(PropertyVisitor pv) {
//      this.pv = pv;
//    }
//
//    public void visit(InheritInfo inheritInfo) {
//      BeanProperty[] propertiesLocal = inheritInfo.getBeanDescriptor().propertiesLocal();
//      for (int i = 0; i <propertiesLocal.length ; i++) {
//        BeanPropertyVisitor.visit(pv, propertiesLocal[i]);
//      }
//    }
//  }
}
