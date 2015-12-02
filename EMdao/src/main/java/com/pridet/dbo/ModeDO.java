package com.pridet.dbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mode")
public class ModeDO extends BaseDO{

	@Id
	@Column(name = "id")
	private int id;
	private String modeOfConsultation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModeOfConsultation() {
		return modeOfConsultation;
	}
	public void setModeOfConsultation(String modeOfConsultation) {
		this.modeOfConsultation = modeOfConsultation;
	}

}
