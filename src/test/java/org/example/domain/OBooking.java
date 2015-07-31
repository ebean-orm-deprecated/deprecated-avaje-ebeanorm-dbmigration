package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "o_booking")
public class OBooking {

	@Id
	private Long id;

  private Date bookingDate;

	@OneToOne
	private OInvoice invoice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

  public Date getBookingDate() {
    return bookingDate;
  }

  public void setBookingDate(Date bookingDate) {
    this.bookingDate = bookingDate;
  }

  public OInvoice getInvoice() {
    return invoice;
  }

  public void setInvoice(OInvoice invoice) {
    this.invoice = invoice;
  }
}
