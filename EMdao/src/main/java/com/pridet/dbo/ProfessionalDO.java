package com.pridet.dbo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "professionaldetails")
public class ProfessionalDO extends BaseDO{

	@Id
	@Column(name = "id")
	private int id;
	private String name;
	private String dob;
	private String phone;
	private String email;
	private String gender;
	private String address;
	private String locality;
	private String languageSpoken;
	private String pan;
	private boolean isActive;
	private String barCouncilNo;
	private String licence;
	private Set<ProfessionsDO> professions = new HashSet<ProfessionsDO>();
	private Set<PracticeAreas> practiceAreas = new HashSet<PracticeAreas>();
	private ConsultationHistoryDO consultationHistory;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getLanguageSpoken() {
		return languageSpoken;
	}

	public void setLanguageSpoken(String languageSpoken) {
		this.languageSpoken = languageSpoken;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getBarCouncilNo() {
		return barCouncilNo;
	}

	public void setBarCouncilNo(String barCouncilNo) {
		this.barCouncilNo = barCouncilNo;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
	public Set<ProfessionsDO> getProfessions() {
		return professions;
	}

	public void setProfessions(Set<ProfessionsDO> professions) {
		this.professions = professions;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "professionalpracticemapping", catalog = "grepreqdb", joinColumns = { 
			@JoinColumn(name = "id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "id", 
					nullable = false, updatable = false) })
	public Set<PracticeAreas> getPracticeAreas() {
		return practiceAreas;
	}

	public void setPracticeAreas(Set<PracticeAreas> practiceAreas) {
		this.practiceAreas = practiceAreas;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public ConsultationHistoryDO getConsultationHistory() {
		return consultationHistory;
	}
	public void setConsultationHistory(ConsultationHistoryDO consultationHistory) {
		this.consultationHistory = consultationHistory;
	}


}
