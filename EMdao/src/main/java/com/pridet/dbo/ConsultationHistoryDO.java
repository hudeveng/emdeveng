package com.pridet.dbo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consultationhistory")
public class ConsultationHistoryDO extends BaseDO{

	@Id
	@Column(name = "id")
	private int id;
	private ProfessionalDO professionaldetailsid;
	private ClientDO clientid;
	private Date date;
	// private ModeDO modeid;
	private String remarks;
	private boolean isrescheduled;
	private int timesrescheduled;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "consultationHistory", cascade = CascadeType.ALL)
	public ProfessionalDO getProfessionaldetailsid() {
		return professionaldetailsid;
	}
	public void setProfessionaldetailsid(ProfessionalDO professionaldetailsid) {
		this.professionaldetailsid = professionaldetailsid;
	}
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "consultationHistory", cascade = CascadeType.ALL)
	public ClientDO getClientid() {
		return clientid;
	}
	public void setClientid(ClientDO clientid) {
		this.clientid = clientid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public boolean isIsrescheduled() {
		return isrescheduled;
	}
	public void setIsrescheduled(boolean isrescheduled) {
		this.isrescheduled = isrescheduled;
	}
	public int getTimesrescheduled() {
		return timesrescheduled;
	}
	public void setTimesrescheduled(int timesrescheduled) {
		this.timesrescheduled = timesrescheduled;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	  
}
