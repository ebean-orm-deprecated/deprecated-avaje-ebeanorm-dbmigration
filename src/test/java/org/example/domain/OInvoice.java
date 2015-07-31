package org.example.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="o_invoice")
public class OInvoice {

	@Id
	private Long id;

  Date invoiceDate;
	
	@OneToOne(mappedBy = "invoice")
	private OBooking booking;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

  public Date getInvoiceDate() {
    return invoiceDate;
  }

  public void setInvoiceDate(Date invoiceDate) {
    this.invoiceDate = invoiceDate;
  }

  public OBooking getBooking() {
		return booking;
	}

	public void setBooking(OBooking booking) {
		this.booking = booking;
	}
}
