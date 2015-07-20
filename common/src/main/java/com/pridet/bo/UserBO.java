package com.pridet.bo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class UserBO {

	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String address;
	private Date dob;
	private int city;
	private int state;
	private int country;
	private int pin;
	private int usertypeID;
	private Date createDate;
	private Date updateDate;
	private int createdby;
	private int updatedby;
	private String password;
	private String primarycontactno;
	private String secondarycontactno;
	private String emailid;
	private UserTypeBO typeBO;
	

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

	public int getUsertypeID() {
		return usertypeID;
	}

	public void setUsertypeID(int usertypeID) {
		this.usertypeID = usertypeID;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public UserTypeBO getTypeBO() {
		return typeBO;
	}

	public void setTypeBO(UserTypeBO typeBO) {
		this.typeBO = typeBO;
	}

}
