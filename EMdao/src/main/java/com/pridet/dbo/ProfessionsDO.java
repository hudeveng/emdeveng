package com.pridet.dbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="professions")
public class ProfessionsDO extends BaseDO{

	@Id
	@Column(name = "id")
	private int id;
	private String name;
	private ProfessionalDO professional;
	
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	public ProfessionalDO getProfessional() {
		return professional;
	}

	public void setProfessional(ProfessionalDO professional) {
		this.professional = professional;
	}

}
