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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Parent;


@Entity
@Table(name="patient")
public class PatientDO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Size(min=1, max=50)
	@Column(name = "firstname", nullable = false)
	private String firstname;
	
	@Size(min=1, max=50)
	@Column(name = "middlename")
	private String middlename;
	
	@Size(min=1, max=50)
	@Column(name = "lastname", nullable = false)
	private String lastname;
	
	@Column(name = "gender", columnDefinition = "ENUM('male','female') NOT NULL", nullable = false)
	private String gender;
	
	@Size(min=10, max=10)
	@Column(name = "mobileno",nullable=false)
	private String mobileno;
	
	@Size(min=5, max=50)
	@Pattern(regexp="^[a-z0-9_.+-]+@[a-z0-9-]+\\.[a-z0-9-.]+$")
	@Column(name = "email", nullable = false)
	private String email;
	
	@Size(min=8, max=30)
	@Column(name = "password", nullable = false)
	private String password;
	
	@Size(min=5, max=300)
	@Column(name = "address", nullable = false)
	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdate", columnDefinition = "NOT NULL DEFAULT CURRENT_TIMESTAMP")
	private Date createdate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifiedate", columnDefinition = "NOT NULL DEFAULT CURRENT_TIMESTAMP")
	private Date modifiedate;
	
	@JoinColumn(name = "city")
    @ManyToOne(optional = false)
	private CityDO cityDO;
	
	@JoinColumn(name = "state")
    @ManyToOne(optional = false)
	private StateDO stateDO;
	
	@JoinColumn(name = "country")
    @ManyToOne(optional = false)
	private CountryDO countryDO;
	
	@Max(999999)
	@Min(100000)
	@Column(name = "pin")
	private int pin;
	
	@JoinColumn(name = "usertype")
    @ManyToOne(optional = false)
	private UserTypeDO usertypeDO;
	
	@Size(min=0, max=100)
	@Column(name = "appinfo")
	private String appinfo;

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

	public CityDO getCityDO() {
		return cityDO;
	}

	public void setCityDO(CityDO cityDO) {
		this.cityDO = cityDO;
	}

	public StateDO getStateDO() {
		return stateDO;
	}

	public void setStateDO(StateDO stateDO) {
		this.stateDO = stateDO;
	}

	public CountryDO getCountryDO() {
		return countryDO;
	}

	public void setCountryDO(CountryDO countryDO) {
		this.countryDO = countryDO;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public UserTypeDO getUsertypeDO() {
		return usertypeDO;
	}

	public void setUsertypeDO(UserTypeDO usertypeDO) {
		this.usertypeDO = usertypeDO;
	}

	public String getAppinfo() {
		return appinfo;
	}

	public void setAppinfo(String appinfo) {
		this.appinfo = appinfo;
	}
	
	

}
