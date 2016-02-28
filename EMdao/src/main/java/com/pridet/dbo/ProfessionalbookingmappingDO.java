package com.pridet.dbo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the professionalbookingmapping database table.
 * 
 */
@Entity
@Table(name="professionalbookingmapping")
@NamedQuery(name="ProfessionalbookingmappingDO.findAll", query="SELECT p FROM ProfessionalbookingmappingDO p")
public class ProfessionalbookingmappingDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to BookingdetailDO
	@OneToMany(mappedBy="professionalbookingmapping1")
	private List<BookingdetailDO> bookingdetails;

	//bi-directional one-to-one association to BookingdetailDO
	@OneToOne(mappedBy="professionalbookingmapping2")
	private BookingdetailDO bookingdetail1;

	//bi-directional many-to-one association to BookingdetailDO
	@ManyToOne
	@JoinColumn(name="bookingdetailsid")
	private BookingdetailDO bookingdetail2;

	//bi-directional one-to-one association to BookingdetailDO
	@OneToOne
	@JoinColumn(name="id")
	private BookingdetailDO bookingdetail3;

	//bi-directional many-to-one association to ProfessionaldetailDO
	@ManyToOne
	@JoinColumn(name="professionaldetailsid")
	private ProfessionaldetailDO professionaldetail1;

	//bi-directional one-to-one association to ProfessionaldetailDO
	@OneToOne
	@JoinColumn(name="id")
	private ProfessionaldetailDO professionaldetail2;

	//bi-directional one-to-one association to ProfessionaldetailDO
	@OneToOne(mappedBy="professionalbookingmapping2")
	private ProfessionaldetailDO professionaldetail3;

	public ProfessionalbookingmappingDO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<BookingdetailDO> getBookingdetails() {
		return this.bookingdetails;
	}

	public void setBookingdetails(List<BookingdetailDO> bookingdetails) {
		this.bookingdetails = bookingdetails;
	}

	public BookingdetailDO addBookingdetail(BookingdetailDO bookingdetail) {
		getBookingdetails().add(bookingdetail);
		bookingdetail.setProfessionalbookingmapping1(this);

		return bookingdetail;
	}

	public BookingdetailDO removeBookingdetail(BookingdetailDO bookingdetail) {
		getBookingdetails().remove(bookingdetail);
		bookingdetail.setProfessionalbookingmapping1(null);

		return bookingdetail;
	}

	public BookingdetailDO getBookingdetail1() {
		return this.bookingdetail1;
	}

	public void setBookingdetail1(BookingdetailDO bookingdetail1) {
		this.bookingdetail1 = bookingdetail1;
	}

	public BookingdetailDO getBookingdetail2() {
		return this.bookingdetail2;
	}

	public void setBookingdetail2(BookingdetailDO bookingdetail2) {
		this.bookingdetail2 = bookingdetail2;
	}

	public BookingdetailDO getBookingdetail3() {
		return this.bookingdetail3;
	}

	public void setBookingdetail3(BookingdetailDO bookingdetail3) {
		this.bookingdetail3 = bookingdetail3;
	}

	public ProfessionaldetailDO getProfessionaldetail1() {
		return this.professionaldetail1;
	}

	public void setProfessionaldetail1(ProfessionaldetailDO professionaldetail1) {
		this.professionaldetail1 = professionaldetail1;
	}

	public ProfessionaldetailDO getProfessionaldetail2() {
		return this.professionaldetail2;
	}

	public void setProfessionaldetail2(ProfessionaldetailDO professionaldetail2) {
		this.professionaldetail2 = professionaldetail2;
	}

	public ProfessionaldetailDO getProfessionaldetail3() {
		return this.professionaldetail3;
	}

	public void setProfessionaldetail3(ProfessionaldetailDO professionaldetail3) {
		this.professionaldetail3 = professionaldetail3;
	}

}