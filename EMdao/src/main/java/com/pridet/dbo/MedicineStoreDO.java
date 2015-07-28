package com.pridet.dbo;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the mastermedicinestore database table.
 * 
 */
@Entity
@Table(name="Mastermedicinestore")
public class MedicineStoreDO {

	@Id
	private int id;

	private String address;

	private int city;

	private int country;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdon;

	private byte documentssubmited;

	private byte isactive;

	private String licennceno;

	private String ownername;

	private int pin;

	private int primarycontactno;

	private int state;

	private String storename;

	private int updatedbyid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedon;

	private byte verifiedby;

	@Temporal(TemporalType.TIMESTAMP)
	private Date verifiedon;

	private double latitude;

	private double longitude;
	
	public MedicineStoreDO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCity() {
		return this.city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getCountry() {
		return this.country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public Date getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public byte getDocumentssubmited() {
		return this.documentssubmited;
	}

	public void setDocumentssubmited(byte documentssubmited) {
		this.documentssubmited = documentssubmited;
	}

	public byte getIsactive() {
		return this.isactive;
	}

	public void setIsactive(byte isactive) {
		this.isactive = isactive;
	}

	public String getLicennceno() {
		return this.licennceno;
	}

	public void setLicennceno(String licennceno) {
		this.licennceno = licennceno;
	}

	public String getOwnername() {
		return this.ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public int getPin() {
		return this.pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getPrimarycontactno() {
		return this.primarycontactno;
	}

	public void setPrimarycontactno(int primarycontactno) {
		this.primarycontactno = primarycontactno;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStorename() {
		return this.storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public int getUpdatedbyid() {
		return this.updatedbyid;
	}

	public void setUpdatedbyid(int updatedbyid) {
		this.updatedbyid = updatedbyid;
	}

	public Date getUpdatedon() {
		return this.updatedon;
	}

	public void setUpdatedon(Date updatedon) {
		this.updatedon = updatedon;
	}

	public byte getVerifiedby() {
		return this.verifiedby;
	}

	public void setVerifiedby(byte verifiedby) {
		this.verifiedby = verifiedby;
	}

	public Date getVerifiedon() {
		return this.verifiedon;
	}

	public void setVerifiedon(Date verifiedon) {
		this.verifiedon = verifiedon;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
