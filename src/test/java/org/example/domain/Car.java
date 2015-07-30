package org.example.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance
@DiscriminatorValue("C")
public class Car extends Vehicle {

  String driver;

  @ManyToOne
  TruckRef carRef;

  @OneToMany(mappedBy = "car")
  List<CarAccessory> accessories;

  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public TruckRef getCarRef() {
    return carRef;
  }

  public void setCarRef(TruckRef carRef) {
    this.carRef = carRef;
  }

  public List<CarAccessory> getAccessories() {
    return accessories;
  }

  public void setAccessories(List<CarAccessory> accessories) {
    this.accessories = accessories;
  }
}
