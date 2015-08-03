package org.example.domain;

import com.avaje.ebean.annotation.DbJson;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Version;
import java.io.File;
import java.util.Map;

/**
 * Document
 */
@Entity
@Table(name="blob_holder")
public class BlobHolder {

  @Id
  Long id;

  @Version
  Long version;

  @Lob
  String textContent;

  @Lob
  byte[] binaryContent;

  File fileContent;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public String getTextContent() {
    return textContent;
  }

  public void setTextContent(String textContent) {
    this.textContent = textContent;
  }

  public byte[] getBinaryContent() {
    return binaryContent;
  }

  public void setBinaryContent(byte[] binaryContent) {
    this.binaryContent = binaryContent;
  }

  public File getFileContent() {
    return fileContent;
  }

  public void setFileContent(File fileContent) {
    this.fileContent = fileContent;
  }
}
