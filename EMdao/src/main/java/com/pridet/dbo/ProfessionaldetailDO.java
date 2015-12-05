package com.pridet.dbo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the professionaldetails database table.
 * 
 */
@Entity
@Table(name="professionaldetails")
@NamedQuery(name="ProfessionaldetailDO.findAll", query="SELECT p FROM ProfessionaldetailDO p")
public class ProfessionaldetailDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String address;

	private Timestamp dob;

	private String email;

	private String gender;

	private byte isactive;

	private String languagesopken;

	private String name;

	@Lob
	private byte[] others;

	private String pan;

	private String phone;

	//bi-directional many-to-one association to ConsultationhistoryDO
	@OneToMany(mappedBy="professionaldetail")
	private List<ConsultationhistoryDO> consultationhistories;

	//bi-directional many-to-one association to LogincredentialDO
	@OneToMany(mappedBy="professionaldetail")
	private List<LogincredentialDO> logincredentials;

	//bi-directional many-to-one association to LocalityDO
	@ManyToOne
	@JoinColumn(name="locality")
	private LocalityDO localityBean;

	//bi-directional many-to-one association to ProfessionalpracticemappingDO
	@ManyToOne
	@JoinColumn(name="professionalpracticemapping")
	private ProfessionalpracticemappingDO professionalpracticemappingBean;

	//bi-directional many-to-one association to ProfessionDO
	@ManyToOne
	@JoinColumn(name="professions")
	private ProfessionDO profession;

	public ProfessionaldetailDO() {
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

	public Timestamp getDob() {
		return this.dob;
	}

	public void setDob(Timestamp dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public byte getIsactive() {
		return this.isactive;
	}

	public void setIsactive(byte isactive) {
		this.isactive = isactive;
	}

	public String getLanguagesopken() {
		return this.languagesopken;
	}

	public void setLanguagesopken(String languagesopken) {
		this.languagesopken = languagesopken;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getOthers() {
		return this.others;
	}

	public void setOthers(byte[] others) {
		this.others = others;
	}

	public String getPan() {
		return this.pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<ConsultationhistoryDO> getConsultationhistories() {
		return this.consultationhistories;
	}

	public void setConsultationhistories(List<ConsultationhistoryDO> consultationhistories) {
		this.consultationhistories = consultationhistories;
	}

	public ConsultationhistoryDO addConsultationhistory(ConsultationhistoryDO consultationhistory) {
		getConsultationhistories().add(consultationhistory);
		consultationhistory.setProfessionaldetail(this);

		return consultationhistory;
	}

	public ConsultationhistoryDO removeConsultationhistory(ConsultationhistoryDO consultationhistory) {
		getConsultationhistories().remove(consultationhistory);
		consultationhistory.setProfessionaldetail(null);

		return consultationhistory;
	}

	public List<LogincredentialDO> getLogincredentials() {
		return this.logincredentials;
	}

	public void setLogincredentials(List<LogincredentialDO> logincredentials) {
		this.logincredentials = logincredentials;
	}

	public LogincredentialDO addLogincredential(LogincredentialDO logincredential) {
		getLogincredentials().add(logincredential);
		logincredential.setProfessionaldetail(this);

		return logincredential;
	}

	public LogincredentialDO removeLogincredential(LogincredentialDO logincredential) {
		getLogincredentials().remove(logincredential);
		logincredential.setProfessionaldetail(null);

		return logincredential;
	}

	public LocalityDO getLocalityBean() {
		return this.localityBean;
	}

	public void setLocalityBean(LocalityDO localityBean) {
		this.localityBean = localityBean;
	}

	public ProfessionalpracticemappingDO getProfessionalpracticemappingBean() {
		return this.professionalpracticemappingBean;
	}

	public void setProfessionalpracticemappingBean(ProfessionalpracticemappingDO professionalpracticemappingBean) {
		this.professionalpracticemappingBean = professionalpracticemappingBean;
	}

	public ProfessionDO getProfession() {
		return this.profession;
	}

	public void setProfession(ProfessionDO profession) {
		this.profession = profession;
	}

}