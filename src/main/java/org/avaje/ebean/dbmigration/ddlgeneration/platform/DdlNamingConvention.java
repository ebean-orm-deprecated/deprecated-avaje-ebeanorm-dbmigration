package org.avaje.ebean.dbmigration.ddlgeneration.platform;

import java.util.List;

/**
 * Naming convention used for constraint names.
 */
public class DdlNamingConvention {

  protected boolean lowerCase = true;

  protected String pkPrefix = "pk_";
  protected String pkSuffix = "";

  protected String fkPrefix = "fk_";
  protected String fkMiddle = "_";
  protected String fkSuffix = "";

  protected String fkIndexPrefix = "ix_";
  protected String fkIndexMiddle = "_";
  protected String fkIndexSuffix = "";

  protected String uqPrefix = "uq_";
  protected String uqSuffix = "";

  protected String ckPrefix = "ck_";
  protected String ckSuffix = "";

  protected String[] quotedIdentifiers = {"\"", "'", "[", "]", "`"};

  /**
   * Return the primary key constraint name.
   */
  public String primaryKeyName(String tableName, List<String> pkColumns) {

    return pkPrefix + normalise(tableName) + pkSuffix;
  }

  /**
   * Return the foreign key constraint name given a single column foreign key.
   */
  public String foreignKeyConstraintName(String tableName, String columnName) {
    return fkPrefix + normalise(tableName) + fkMiddle + normalise(columnName) + fkSuffix;
  }

  /**
   * Return the index name associated with a foreign key constraint given a single column foreign key.
   */
  public String foreignKeyIndexName(String tableName, String columnName) {
    return fkIndexPrefix + normalise(tableName) + fkIndexMiddle + normalise(columnName) + fkIndexSuffix;
  }

  /**
   * Return the unique constraint name.
   */
  public String uniqueConstraintName(String tableName, String columnName) {

    return uqPrefix + normalise(tableName) + "_" + normalise(columnName) + uqSuffix;
  }

  /**
   * Return the check constraint name.
   */
  public String checkConstraintName(String tableName, String columnName) {

    return ckPrefix + normalise(tableName) + "_" + normalise(columnName) + ckSuffix;
  }

  /**
   * Normalise the table name by trimming catalog and schema and removing any
   * quoted identifier characters (",',[,] etc).
   */
  protected String normalise(String tableName) {

    tableName = trimQuotes(tableName);
    int lastPeriod = tableName.lastIndexOf('.');
    if (lastPeriod > -1) {
      tableName = tableName.substring(lastPeriod + 1);
    }
    if (lowerCase) {
      tableName = tableName.toLowerCase();
    }
    return tableName;
  }

  /**
   * Trim off the platform quoted identifier quotes like [ ' and ".
   */
  protected String trimQuotes(String tableName) {

    // remove quoted identifier characters
    for (int i = 0; i < quotedIdentifiers.length; i++) {
      tableName = tableName.replace(quotedIdentifiers[i], "");
    }
    return tableName;
  }

}
