package com.pridet.dbo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the bookingdetails database table.
 * 
 */
@Entity
@Table(name="bookingdetails")
@NamedQuery(name="BookingdetailDO.findAll", query="SELECT b FROM BookingdetailDO b")
public class BookingdetailDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String clientname;

	private Timestamp datetime;

	private int duration;

	private String remarks;

	//bi-directional many-to-one association to ProfessionalbookingmappingDO
	@ManyToOne
	@JoinColumn(name="professionalbookingmappingid")
	private ProfessionalbookingmappingDO professionalbookingmapping1;

	//bi-directional one-to-one association to ProfessionalbookingmappingDO
	@OneToOne
	@JoinColumn(name="id")
	private ProfessionalbookingmappingDO professionalbookingmapping2;

	//bi-directional many-to-one association to ProfessionalbookingmappingDO
	@OneToMany(mappedBy="bookingdetail2")
	private List<ProfessionalbookingmappingDO> professionalbookingmappings;

	//bi-directional one-to-one association to ProfessionalbookingmappingDO
	@OneToOne(mappedBy="bookingdetail3")
	private ProfessionalbookingmappingDO professionalbookingmapping3;

	public BookingdetailDO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClientname() {
		return this.clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public Timestamp getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public ProfessionalbookingmappingDO getProfessionalbookingmapping1() {
		return this.professionalbookingmapping1;
	}

	public void setProfessionalbookingmapping1(ProfessionalbookingmappingDO professionalbookingmapping1) {
		this.professionalbookingmapping1 = professionalbookingmapping1;
	}

	public ProfessionalbookingmappingDO getProfessionalbookingmapping2() {
		return this.professionalbookingmapping2;
	}

	public void setProfessionalbookingmapping2(ProfessionalbookingmappingDO professionalbookingmapping2) {
		this.professionalbookingmapping2 = professionalbookingmapping2;
	}

	public List<ProfessionalbookingmappingDO> getProfessionalbookingmappings() {
		return this.professionalbookingmappings;
	}

	public void setProfessionalbookingmappings(List<ProfessionalbookingmappingDO> professionalbookingmappings) {
		this.professionalbookingmappings = professionalbookingmappings;
	}

	public ProfessionalbookingmappingDO addProfessionalbookingmapping(ProfessionalbookingmappingDO professionalbookingmapping) {
		getProfessionalbookingmappings().add(professionalbookingmapping);
		professionalbookingmapping.setBookingdetail2(this);

		return professionalbookingmapping;
	}

	public ProfessionalbookingmappingDO removeProfessionalbookingmapping(ProfessionalbookingmappingDO professionalbookingmapping) {
		getProfessionalbookingmappings().remove(professionalbookingmapping);
		professionalbookingmapping.setBookingdetail2(null);

		return professionalbookingmapping;
	}

	public ProfessionalbookingmappingDO getProfessionalbookingmapping3() {
		return this.professionalbookingmapping3;
	}

	public void setProfessionalbookingmapping3(ProfessionalbookingmappingDO professionalbookingmapping3) {
		this.professionalbookingmapping3 = professionalbookingmapping3;
	}

}