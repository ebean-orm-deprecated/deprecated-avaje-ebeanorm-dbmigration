package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CarAccessory extends BaseModel {

  String name;

  @ManyToOne
  Car car;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }
}
