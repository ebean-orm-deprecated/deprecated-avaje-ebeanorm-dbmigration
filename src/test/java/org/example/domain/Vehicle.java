package org.example.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import java.util.Date;

@Entity
@Inheritance
@DiscriminatorColumn(length = 3)
public abstract class Vehicle extends BaseModel {

  String licenseNumber;

  Date registrationDate;

  public String getLicenseNumber() {
    return licenseNumber;
  }

  public void setLicenseNumber(String licenseNumber) {
    this.licenseNumber = licenseNumber;
  }

  public Date getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(Date registrationDate) {
    this.registrationDate = registrationDate;
  }

}
