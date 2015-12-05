package com.pridet.dbo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the consultationhistory database table.
 * 
 */
@Entity
@Table(name="consultationhistory")
@NamedQuery(name="ConsultationhistoryDO.findAll", query="SELECT c FROM ConsultationhistoryDO c")
public class ConsultationhistoryDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Timestamp date;

	private String remarks;

	//bi-directional many-to-one association to ClientDO
	@ManyToOne
	@JoinColumn(name="clientid")
	private ClientDO client;

	//bi-directional many-to-one association to ModeDO
	@ManyToOne
	@JoinColumn(name="modeid")
	private ModeDO mode;

	//bi-directional many-to-one association to ProfessionaldetailDO
	@ManyToOne
	@JoinColumn(name="professionaldetailsid")
	private ProfessionaldetailDO professionaldetail;

	public ConsultationhistoryDO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public ClientDO getClient() {
		return this.client;
	}

	public void setClient(ClientDO client) {
		this.client = client;
	}

	public ModeDO getMode() {
		return this.mode;
	}

	public void setMode(ModeDO mode) {
		this.mode = mode;
	}

	public ProfessionaldetailDO getProfessionaldetail() {
		return this.professionaldetail;
	}

	public void setProfessionaldetail(ProfessionaldetailDO professionaldetail) {
		this.professionaldetail = professionaldetail;
	}

}