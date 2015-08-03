package org.avaje.ebean.dbmigration.ddlgeneration.platform;

import com.avaje.ebean.config.dbplatform.DbTypeMap;

/**
 *
 */
public class PlatformDdl {

  protected final PlatformTypeConverter typeConverter;

  protected String foreignKeyRestrict = "";

  public PlatformDdl(DbTypeMap platformTypes) {
    this.typeConverter = new PlatformTypeConverter(platformTypes);
  }

  public String asIdentityColumn(String columnDefn) {
    return columnDefn;
  }

  public String getForeignKeyRestrict() {
    return foreignKeyRestrict;
  }

  public String convert(String type, boolean identity) {
    String platformType = typeConverter.convert(type);
    return identity ? asIdentityColumn(platformType) : platformType;
  }
}
