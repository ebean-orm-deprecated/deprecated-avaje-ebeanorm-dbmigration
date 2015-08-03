package org.avaje.ebean.dbmigration.ddlgeneration;

import org.avaje.ebean.dbmigration.ddlgeneration.platform.BaseDdlBuffer;
import org.avaje.ebean.dbmigration.model.MConfiguration;

/**
 * Write context holding the buffers for both apply and rollback DDL.
 */
public class DdlWrite {

  private final DdlBuffer apply;

  private final DdlBuffer applyLast;

  private final DdlBuffer rollbackFirst;

  private final DdlBuffer rollbackLast;

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
    this.applyLast = new BaseDdlBuffer(configuration);
    this.rollbackFirst = new BaseDdlBuffer(configuration);
    this.rollbackLast = new BaseDdlBuffer(configuration);
  }

  /**
   * Return the buffer that APPLY DDL is written to.
   */
  public DdlBuffer apply() {
    return apply;
  }

  /**
   * Return the buffer that APPLY DDL is written to.
   * <p>
   * Statements added to this buffer are executed after all the normal
   * apply statements and typically 'add foreign key' is added to this buffer.
   */
  public DdlBuffer applyLast() {
    return applyLast;
  }

  /**
   * Return the buffer that ROLLBACK DDL is written to.
   */
  public DdlBuffer rollbackFirst() {
    return rollbackFirst;
  }

  /**
   * Return the buffer that ROLLBACK DDL is written to.
   * <p>
   * Statements added to this rollback buffer are executed before normal
   * rollback such as deleting foreign key constraints.
   */
  public DdlBuffer rollbackLast() {
    return rollbackLast;
  }


}
