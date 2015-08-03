package org.avaje.ebean.dbmigration.ddlgeneration.platform;

import com.avaje.ebean.config.dbplatform.DbType;
import com.avaje.ebean.config.dbplatform.DbTypeMap;

/**
 * Converts a logical column definition into platform specific one.
 *
 * This translates standard sql types into platform specific ones.
 */
public class PlatformTypeConverter {

  protected final DbTypeMap platformTypes;

  public PlatformTypeConverter(DbTypeMap platformTypes) {
    this.platformTypes = platformTypes;
  }

  public String convert(String columnDefinition) {

    int open = columnDefinition.indexOf('(');
    if (open > -1) {
      // no scale or precision
      return convertWithScale(columnDefinition, open);
    } else {
      return convertNoScale(columnDefinition);
    }
  }

  protected String convertWithScale(String columnDefinition, int open) {

    int close = columnDefinition.lastIndexOf(')');
    if (close == -1) {
      // assume already platform specific, leave as is
      return columnDefinition;
    }

    String type = columnDefinition.substring(0,open);
    try {
      DbType dbType = platformTypes.lookup(type);
      int comma = columnDefinition.indexOf(',',open);
      if (comma > -1) {
        // scale and precision - decimal(10,4)
        int scale = Integer.parseInt(columnDefinition.substring(open+1, comma));
        int precision = Integer.parseInt(columnDefinition.substring(comma+1, close));
        return  dbType.renderType(scale,precision);

      } else {
        // scale - varchar(10)
        int scale = Integer.parseInt(columnDefinition.substring(open+1, close));
        return  dbType.renderType(scale,0);
      }

    } catch (IllegalArgumentException e) {
      // assume already platform specific, leave as is
      return columnDefinition;
    }
  }

  protected String convertNoScale(String columnDefinition) {

    try {
      DbType dbType = platformTypes.lookup(columnDefinition);
      return  dbType.renderType(0,0);

    } catch (IllegalArgumentException e) {
      // assume already platform specific, leave as is
      return columnDefinition;
    }
  }

}
