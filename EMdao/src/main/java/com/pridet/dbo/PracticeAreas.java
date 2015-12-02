package com.pridet.dbo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "practiceareas")
public class PracticeAreas extends BaseDO{

	
	@Id
	@Column(name = "id")
	private int id;
	private String practiceareas;
	private Set<ProfessionalDO> professionals = new HashSet<ProfessionalDO>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPracticeareas() {
		return practiceareas;
	}
	public void setPracticeareas(String practiceareas) {
		this.practiceareas = practiceareas;
	}
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "practiceAreas")
	public Set<ProfessionalDO> getProfessionals() {
		return professionals;
	}
	public void setProfessionals(Set<ProfessionalDO> professionals) {
		this.professionals = professionals;
	}
}
