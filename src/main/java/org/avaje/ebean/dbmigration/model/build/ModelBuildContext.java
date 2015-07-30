package org.avaje.ebean.dbmigration.model.build;

import com.avaje.ebean.config.dbplatform.DbType;
import com.avaje.ebean.config.dbplatform.DbTypeMap;
import com.avaje.ebeaninternal.server.deploy.BeanProperty;
import com.avaje.ebeaninternal.server.type.ScalarType;
import org.avaje.ebean.dbmigration.model.MTable;
import org.avaje.ebean.dbmigration.model.ModelContainer;

import java.sql.Types;

/**
 * The context used during DDL generation.
 */
public class ModelBuildContext {

	/**
	 * Used to map bean types to DB specific types.
	 */
	private final DbTypeMap dbTypeMap;

  private final ModelContainer model;

	public ModelBuildContext(DbTypeMap dbTypeMap, ModelContainer model){
		this.dbTypeMap = dbTypeMap;
    this.model = model;
	}

  public void addTable(MTable table) {
    model.addTable(table);
  }

	/**
	 * Return the map used to determine the DB specific type
	 * for a given bean property.
	 */
	public DbTypeMap getDbTypeMap() {
		return dbTypeMap;
	}


	public String getColumnDefn(BeanProperty p) {
		DbType dbType = getDbType(p);
		return p.renderDbType(dbType);
	}

	private DbType getDbType(BeanProperty p) {

		ScalarType<?> scalarType = p.getScalarType();
		if (scalarType == null) {
			throw new RuntimeException("No scalarType for " + p.getFullBeanName());
		}

		if (p.isDbEncrypted()){
		    return dbTypeMap.get(p.getDbEncryptedType());
		}
		
		int jdbcType = scalarType.getJdbcType();
		if (p.isLob() && jdbcType == Types.VARCHAR){
			// workaround for Postgres TEXT type which is 
			// VARCHAR in jdbc API but TEXT in ddl
			jdbcType = Types.CLOB;
		}
		return dbTypeMap.get(jdbcType);
	}


}
