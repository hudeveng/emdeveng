package com.pridet.dbo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name="MASTERUSER")
public class UserDO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min=1, max=50)
	@Column(name = "firstname", nullable = false)
	private String firstName;
	
	@Size(min=0, max=50)
	@Column(name = "middlename", nullable = true)
	private String middleName;
	
	@Size(min=1, max=50)
	@Column(name = "lastname", nullable = false)
	private String lastName;
	
	@Size(min=4, max=50)
	@Column(name = "gender", nullable = false)
	private String gender;
	
	@Column(name = "dob", nullable = false)
	private Date dob;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "city")
	private int city;
	
	@Column(name = "state")
	private int state;
	
	@Column(name = "country")
	private int country;
	
	@Column(name = "pin")
	private int pin;
	
	@JoinColumn(name = "usertype")
    @ManyToOne(optional = false)
	private UserTypeDO usertype;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdate", columnDefinition = "NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false)
	java.util.Date today = new java.util.Date();
	private Date createDate = new java.sql.Timestamp(today.getTime());
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedate", columnDefinition = "NOT NULL DEFAULT CURRENT_TIMESTAMP", nullable = false)
	private Date updateDate;
	

	@Column(name = "createdby", nullable = false)
	private int createdby;
	
	@Column(name = "updatedby", nullable = false)
	private int updatedby;
	
	@Column(name = "password", nullable = true)
	private String password;
	
	@Column(name = "primarycontactno", nullable = false)
	private String primarycontactno;
	
	@Column(name = "secondarycontactno", nullable = true)
	private String secondarycontactno;
	
	@Column(name = "emailid", nullable = false)
	private String emailid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public UserTypeDO getUsertype() {
		return usertype;
	}

	public void setUsertype(UserTypeDO usertype) {
		this.usertype = usertype;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public int getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(int updatedby) {
		this.updatedby = updatedby;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrimarycontactno() {
		return primarycontactno;
	}

	public void setPrimarycontactno(String primarycontactno) {
		this.primarycontactno = primarycontactno;
	}

	public String getSecondarycontactno() {
		return secondarycontactno;
	}

	public void setSecondarycontactno(String secondarycontactno) {
		this.secondarycontactno = secondarycontactno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
	
	
}
