package org.avaje.ebean.dbmigration.visitor.junk;

import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
import com.avaje.ebeaninternal.server.deploy.BeanProperty;
import org.avaje.ebean.dbmigration.model.build.ModelBuildContext;
import org.avaje.ebean.dbmigration.visitor.BeanVisitor;
import org.avaje.ebean.dbmigration.visitor.PropertyVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Used to generate the drop table DDL script.
 */
public class CreateSequenceVisitor implements BeanVisitor {

	private static final Logger logger = LoggerFactory.getLogger(CreateSequenceVisitor.class);

	private final ModelBuildContext ctx;
	
//	private final boolean supportsSequence;

	public CreateSequenceVisitor(ModelBuildContext ctx) {
		this.ctx = ctx;
//		this.supportsSequence = ctx.getDbPlatform().getDbIdentity().isSupportsSequence();
	}
	
	public boolean visitBean(BeanDescriptor<?> descriptor) {
		
//		if (!descriptor.isInheritanceRoot()){
//			return false;
//		}
//		if (descriptor.getSequenceName() == null) {
//			return false;
//		}
//
//		if (!supportsSequence){
//			// Hopefully a generic test case
//			String msg = "Not creating sequence "+descriptor.getSequenceName()+" on Bean "+descriptor.getName()
//				+" as DatabasePlatform does not support sequences";
//			logger.warn(msg);
//			return false;
//		}
//
//		String sequenceName = descriptor.getSequenceName();
//		if (sequenceName != null) {
//			int initialValue = descriptor.getSequenceInitialValue();
//			int allocationSize = descriptor.getSequenceAllocationSize();
//			String createSeq = ctx.getDbPlatform().ddlCreateSequence(sequenceName, initialValue, allocationSize);
//			ctx.write(createSeq).writeNewLine().writeNewLine();
//		}
		return true;
	}

	
	public void visitBeanEnd(BeanDescriptor<?> descriptor) {
	}

	public void visitBegin() {	
	}

	public void visitEnd() {	
	}

	public PropertyVisitor visitProperty(BeanProperty p) {
		// Return null as we are not interested in properties
		return null;
	}
	
}
