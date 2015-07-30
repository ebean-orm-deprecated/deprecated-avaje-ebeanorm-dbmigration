package org.avaje.ebean.dbmigration.ddlgeneration;

import org.avaje.ebean.dbmigration.ddlgeneration.platform.BaseDdlBuffer;
import org.avaje.ebean.dbmigration.model.MConfiguration;

/**
 * Write context holding the buffers for both apply and rollback DDL.
 */
public class DdlWrite {

  private final DdlBuffer apply;

  private final DdlBuffer rollback;

  /**
   * Create without any configuration.
   */
  public DdlWrite() {
    this(new MConfiguration());
  }

  /**
   * Create with a configuration.
   */
  public DdlWrite(MConfiguration configuration) {
    this.apply = new BaseDdlBuffer(configuration);
    this.rollback = new BaseDdlBuffer(configuration);
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
