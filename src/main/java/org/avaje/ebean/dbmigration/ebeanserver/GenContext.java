package org.avaje.ebean.dbmigration.ebeanserver;

import com.avaje.ebean.config.NamingConvention;
import com.avaje.ebean.config.dbplatform.DatabasePlatform;
import com.avaje.ebean.config.dbplatform.DbDdlSyntax;
import com.avaje.ebean.config.dbplatform.DbType;
import com.avaje.ebean.config.dbplatform.DbTypeMap;
import com.avaje.ebeaninternal.server.ddl.DdlGenContext;
import com.avaje.ebeaninternal.server.deploy.BeanProperty;
import com.avaje.ebeaninternal.server.lib.util.StringHelper;
import com.avaje.ebeaninternal.server.type.ScalarType;

import java.io.StringWriter;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The context used during DDL generation.
 */
public class GenContext {

	/**
	 * Used to map bean types to DB specific types.
	 */
	private final DbTypeMap dbTypeMap;

	private final DatabasePlatform dbPlatform;

	/**
   * The Naming convention used to define FK an IX names
   */
	private final NamingConvention namingConvention;

	public GenContext(DatabasePlatform dbPlatform, NamingConvention namingConvention){
		this.dbPlatform = dbPlatform;
		this.dbTypeMap = dbPlatform.getDbTypeMap();
		this.namingConvention = namingConvention;
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

	/**
	 * Strips off the Database Platform specific quoted identifier characters.
	 */
  public String removeQuotes(String dbColumn) {
    
    dbColumn = StringHelper.replaceString(dbColumn, dbPlatform.getOpenQuote(), "");
    dbColumn = StringHelper.replaceString(dbColumn, dbPlatform.getCloseQuote(), "");
    
    return dbColumn;
  }
}
