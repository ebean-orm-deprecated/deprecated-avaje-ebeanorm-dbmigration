package org.example.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;

@Entity
@Inheritance
@DiscriminatorValue("T")
public class Truck extends Vehicle {

	@ManyToOne
	TruckRef truckRef;
	
	Double capacity;

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public TruckRef getTruckRef() {
		return truckRef;
	}

	public void setTruckRef(TruckRef truckRef) {
		this.truckRef = truckRef;
	}

}
