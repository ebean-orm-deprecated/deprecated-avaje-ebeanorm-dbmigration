package org.avaje.ebean.dbmigration.model.build;

import com.avaje.ebean.config.dbplatform.DbTypeMap;
import com.avaje.ebeaninternal.api.SpiEbeanServer;
import org.avaje.ebean.dbmigration.migration.ChangeSet;
import org.avaje.ebean.dbmigration.model.ModelContainer;
import org.avaje.ebean.dbmigration.model.ModelDiff;
import org.avaje.ebean.dbmigration.model.visitor.VisitAllUsing;

import java.util.List;

/**
 * Reads EbeanServer bean descriptors to build the current model.
 */
public class ModelServerReader {

  /**
   * The empty model we populate by reading the server bean descriptors.
   */
  protected ModelContainer model = new ModelContainer();

  protected SpiEbeanServer server;

  public ModelServerReader(SpiEbeanServer server) {
    this.server = server;
  }

  public ModelContainer build() {

    VisitAllUsing visit = new VisitAllUsing(beanVisitor(), server);
    visit.visitAllBeans();

    return model;
  }

  public ChangeSet buildAsCreateChangeSet() {

    // empty diff so changes will effectively be create all
    ModelDiff diff = new ModelDiff();
    diff.compareTo(build());

    List<Object> createChanges = diff.getCreateChanges();

    // put the changes into a ChangeSet
    ChangeSet createChangeSet = new ChangeSet();
    createChangeSet.getChangeSetChildren().addAll(createChanges);
    return createChangeSet;
  }

  protected ModelBuildBeanVisitor beanVisitor() {
     return new ModelBuildBeanVisitor(buildContext());
  }

  protected ModelBuildContext buildContext() {
     return new ModelBuildContext(model);
  }

}
