package org.avaje.ebean.dbmigration.ddlgeneration;

import org.avaje.ebean.dbmigration.model.MConfiguration;

import java.io.IOException;

/**
 * Buffer to append generated DDL to.
 */
public interface DdlBuffer {

  /**
   * Return the configuration (default tablespaces etc).
   */
  MConfiguration getConfiguration();

  /**
   * Append DDL content to the buffer.
   */
  DdlBuffer append(String content) throws IOException;

  /**
   * Append DDL content to the buffer with space padding.
   */
  DdlBuffer append(String type, int space) throws IOException;

  /**
   * Append new line character to the buffer.
   */
  DdlBuffer newLine() throws IOException;

  /**
   * Append the end of statement content.
   */
  DdlBuffer endOfStatement() throws IOException;

  /**
   * End of a change - add some whitespace.
   */
  DdlBuffer end() throws IOException;

  /**
   * Return the buffer content.
   */
  String getBuffer();

}
