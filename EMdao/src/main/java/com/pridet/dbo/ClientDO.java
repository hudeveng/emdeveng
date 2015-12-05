package com.pridet.dbo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@Table(name="client")
@NamedQuery(name="ClientDO.findAll", query="SELECT c FROM ClientDO c")
public class ClientDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String address;

	private Timestamp dob;

	private String email;

	private String gender;

	private String name;

	private String phone;

	//bi-directional many-to-one association to ConsultationhistoryDO
	@OneToMany(mappedBy="client")
	private List<ConsultationhistoryDO> consultationhistories;

	public ClientDO() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
		consultationhistory.setClient(this);

		return consultationhistory;
	}

	public ConsultationhistoryDO removeConsultationhistory(ConsultationhistoryDO consultationhistory) {
		getConsultationhistories().remove(consultationhistory);
		consultationhistory.setClient(null);

		return consultationhistory;
	}

}