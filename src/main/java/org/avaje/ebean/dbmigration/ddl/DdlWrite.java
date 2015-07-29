package org.avaje.ebean.dbmigration.ddl;

import org.avaje.ebean.dbmigration.ddl.platform.BaseDdlBuffer;

/**
 * Write context holding the buffers for both apply and rollback DDL.
 */
public class DdlWrite {

  private final DdlBuffer apply;

  private final DdlBuffer rollback;

  public DdlWrite() {
    apply = new BaseDdlBuffer();
    rollback = new BaseDdlBuffer();
  }

  /**
   * Return the buffer that APPLY DDL is written to.
   */
  public DdlBuffer apply() {
    return apply;
  }

  /**
   * Return the buffer that ROLLBACK DDL is written to.
   */
  public DdlBuffer rollback() {
    return rollback;
  }

}
