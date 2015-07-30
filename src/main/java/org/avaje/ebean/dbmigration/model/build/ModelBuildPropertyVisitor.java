package org.avaje.ebean.dbmigration.model.build;

import com.avaje.ebeaninternal.server.deploy.BeanProperty;
import com.avaje.ebeaninternal.server.deploy.BeanPropertyAssocMany;
import com.avaje.ebeaninternal.server.deploy.BeanPropertyAssocOne;
import com.avaje.ebeaninternal.server.deploy.BeanPropertyCompound;
import com.avaje.ebeaninternal.server.deploy.TableJoinColumn;
import com.avaje.ebeaninternal.server.deploy.id.ImportedId;
import org.avaje.ebean.dbmigration.model.MColumn;
import org.avaje.ebean.dbmigration.model.MTable;
import org.avaje.ebean.dbmigration.model.visitor.BaseTablePropertyVisitor;

/**
 * Used as part of ModelBuildBeanVisitor and generally adds the MColumn to the associated
 * MTable model objects.
 */
public class ModelBuildPropertyVisitor extends BaseTablePropertyVisitor {

  private final ModelBuildContext ctx;

  private MTable table;

  public ModelBuildPropertyVisitor(ModelBuildContext ctx, MTable table) {
    this.ctx = ctx;
    this.table = table;
  }

  @Override
  public void visitMany(BeanPropertyAssocMany<?> p) {
    if (p.isManyToMany()) {
      if (p.getMappedBy() == null) {
        // only create on other 'owning' side

        //TableJoin intersectionTableJoin = p.getIntersectionTableJoin();
        // check if the intersection table has already been created

        // build the create table and fkey constraints
        // putting the DDL into ctx for later output as we are
        // in the middle of rendering the create table DDL
        new ModelBuildIntersectionTable(ctx, p).build();
      }
    }
  }

  @Override
  public void visitCompoundScalar(BeanPropertyCompound compound, BeanProperty p) {
    visitScalar(p);
  }

  @Override
  public void visitCompound(BeanPropertyCompound p) {
    // do nothing
  }

  @Override
  public void visitEmbeddedScalar(BeanProperty p, BeanPropertyAssocOne<?> embedded) {

    //this.embedded = embedded;
    visitScalar(p);
  }

  @Override
  public void visitOneImported(BeanPropertyAssocOne<?> p) {

    TableJoinColumn[] columns = p.getTableJoin().columns();
    if (columns.length == 0) {
      String msg = "No join columns for " + p.getFullBeanName();
      throw new RuntimeException(msg);
    }

    ImportedId importedId = p.getImportedId();

//    StringBuilder constraintExpr = createUniqueConstraintBuffer(p.getBeanDescriptor().getBaseTable(), columns[0].getLocalDbColumn());

    for (int i = 0; i < columns.length; i++) {

      String dbCol = columns[i].getLocalDbColumn();

//      if (i > 0) {
//        constraintExpr.append(", ");
//      }
//      constraintExpr.append(dbCol);

      BeanProperty importedProperty = importedId.findMatchImport(dbCol);
      if (importedProperty == null) {
        throw new RuntimeException("Imported BeanProperty not found?");
      }
      String columnDefn = ctx.getColumnDefn(importedProperty);

      MColumn col = new MColumn(dbCol, columnDefn, !p.isNullable());

      // Adding the unique constraint restricts the cardinality from OneToMany down to OneToOne
      col.setUnique(true);

      table.addColumn(col);
    }
//    constraintExpr.append(")");
//
//    if (p.isOneToOne()) {
//      if (ddl.isAddOneToOneUniqueContraint()) {
//        parent.addUniqueConstraint(constraintExpr.toString());
//      }
//    }
  }

	@Override
	public void visitScalar(BeanProperty p) {

    if (p.isSecondaryTable()) {
      return;
    }

    MColumn col = new MColumn(p.getDbColumn(), ctx.getColumnDefn(p));

		if (p.isId()){
      col.setPrimaryKey(true);
		} else if (!p.isNullable() || p.isDDLNotNull()) {
      col.setNotnull(true);
		}

    if (p.isUnique() && !p.isId()) {
      col.setUnique(true);
    }
    col.setCheckConstraint(p.getDbConstraintExpression());

    table.addColumn(col);
	}

}