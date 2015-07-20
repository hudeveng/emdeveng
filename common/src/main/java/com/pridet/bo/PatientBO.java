package com.pridet.bo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlType(name="patientbean")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "patientbean")
public class PatientBO extends BaseBO{

	private int id;
	private String firstname;
	private String middlename;
	private String lastname;
	private String gender;
	private String mobileno;
	private String email;
	private String password;
	private String address;
	private Date createdate;
	private Date modifiedate;
	private int pin;
	private CountryBO country;
	private StateBO state;
	private CityBO city;
	private UserTypeBO usertype;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UserTypeBO getUsertype() {
		return usertype;
	}
	public void setUsertype(UserTypeBO usertype) {
		this.usertype = usertype;
	}
	public CountryBO getCountry() {
		return country;
	}
	public void setCountry(CountryBO country) {
		this.country = country;
	}
	public StateBO getState() {
		return state;
	}
	public void setState(StateBO state) {
		this.state = state;
	}
	public CityBO getCity() {
		return city;
	}
	public void setCity(CityBO city) {
		this.city = city;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getModifiedate() {
		return modifiedate;
	}
	public void setModifiedate(Date modifiedate) {
		this.modifiedate = modifiedate;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	

}
