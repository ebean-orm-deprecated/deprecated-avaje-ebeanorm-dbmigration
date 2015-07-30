package org.avaje.ebean.dbmigration.visitor.junk;

import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
import com.avaje.ebeaninternal.server.deploy.BeanProperty;
import com.avaje.ebeaninternal.server.deploy.BeanPropertyAssocOne;
import com.avaje.ebeaninternal.server.deploy.BeanPropertyCompound;
import org.avaje.ebean.dbmigration.model.build.ModelBuildContext;
import org.avaje.ebean.dbmigration.visitor.AbstractBeanVisitor;
import org.avaje.ebean.dbmigration.visitor.BaseTablePropertyVisitor;
import org.avaje.ebean.dbmigration.visitor.PropertyVisitor;

/**
 * A visitor that creates indexes for columns annotated with ColumnIndex
 *
 * @author rvbiljouw
 * @see com.avaje.ebean.annotation.Index
 */
public class CreateIndexVisitor extends AbstractBeanVisitor {
    private final IndexPropertyVisitor iv;

    public CreateIndexVisitor(ModelBuildContext ctx) {
        this.iv = new IndexPropertyVisitor(ctx);
    }

    @Override
    public void visitBegin() {

    }

    @Override
    public boolean visitBean(BeanDescriptor<?> descriptor) {
        return descriptor.isInheritanceRoot();
    }

    @Override
    public PropertyVisitor visitProperty(BeanProperty p) {
        return iv;
    }

    @Override
    public void visitBeanEnd(BeanDescriptor<?> descriptor) {
        visitInheritanceProperties(descriptor, iv);
    }

    @Override
    public void visitEnd() {

    }

    private static final class IndexPropertyVisitor extends BaseTablePropertyVisitor {
        private final ModelBuildContext ctx;

        public IndexPropertyVisitor(ModelBuildContext ctx) {
            this.ctx = ctx;
        }

        @Override
        public void visitEmbeddedScalar(BeanProperty p, BeanPropertyAssocOne<?> embedded) {

        }

        @Override
        public void visitOneImported(BeanPropertyAssocOne<?> p) {

        }

        @Override
        public void visitScalar(BeanProperty p) {
//            String baseTable = p.getBeanDescriptor().getBaseTable();
//            if (p.isIndexed()) {
//                String indexName = p.getIndexName();
//                if (indexName.length() == 0) {
//                    indexName = ctx.getDdlSyntax().getIndexName(baseTable, p.getDbColumn(), ctx.incrementIxCount());
//                }
//                ctx.write("create index ")
//                        .write(indexName)
//                        .write(" on ")
//                        .write(baseTable)
//                        .write("(")
//                        .write(p.getDbColumn())
//                        .write(");")
//                        .writeNewLine();
//            }
        }

        @Override
        public void visitCompoundScalar(BeanPropertyCompound compound, BeanProperty p) {

        }
    }
}
