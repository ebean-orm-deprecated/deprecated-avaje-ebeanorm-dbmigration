package org.avaje.ebean.dbmigration.ddl.platform;

import org.avaje.ebean.dbmigration.ddl.DdlBuffer;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Base implementation of DdlBuffer using an underlying writer.
 */
public class BaseDdlBuffer implements DdlBuffer {

  final Writer writer;

  public BaseDdlBuffer() {
    this.writer = new StringWriter();
  }

  @Override
  public DdlBuffer append(String content) throws IOException {
    writer.append(content);
    return this;
  }

  @Override
  public DdlBuffer append(String content, int space) throws IOException {
    writer.append(content);
    appendSpace(space, content);
    return this;
  }

  protected void appendSpace(int max, String content) throws IOException {
    int space = max - content.length();
    if (space > 0) {
      for (int i = 0; i < space; i++) {
        append(" ");
      }
    }
  }

  @Override
  public DdlBuffer endOfStatement() throws IOException {
    writer.append(";\n");
    return this;
  }

  @Override
  public DdlBuffer end() throws IOException {
    writer.append("\n");
    return this;
  }

  @Override
  public DdlBuffer newLine() throws IOException {
    writer.append("\n");
    return this;
  }

  public String getBuffer() {
    return writer.toString();
  }
}
