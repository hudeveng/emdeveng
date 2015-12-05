package com.pridet.dbo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the professions database table.
 * 
 */
@Entity
@Table(name="professions")
@NamedQuery(name="ProfessionDO.findAll", query="SELECT p FROM ProfessionDO p")
public class ProfessionDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	//bi-directional many-to-one association to PracticeareaDO
	@OneToMany(mappedBy="profession")
	private List<PracticeareaDO> practiceareas;

	//bi-directional many-to-one association to ProfessionaldetailDO
	@OneToMany(mappedBy="profession")
	private List<ProfessionaldetailDO> professionaldetails;

	//bi-directional many-to-one association to ProfessionalpracticemappingDO
	@OneToMany(mappedBy="profession")
	private List<ProfessionalpracticemappingDO> professionalpracticemappings;

	//bi-directional many-to-one association to ProfessionattributeDO
	@OneToMany(mappedBy="profession")
	private List<ProfessionattributeDO> professionattributes;

	public ProfessionDO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PracticeareaDO> getPracticeareas() {
		return this.practiceareas;
	}

	public void setPracticeareas(List<PracticeareaDO> practiceareas) {
		this.practiceareas = practiceareas;
	}

	public PracticeareaDO addPracticearea(PracticeareaDO practicearea) {
		getPracticeareas().add(practicearea);
		practicearea.setProfession(this);

		return practicearea;
	}

	public PracticeareaDO removePracticearea(PracticeareaDO practicearea) {
		getPracticeareas().remove(practicearea);
		practicearea.setProfession(null);

		return practicearea;
	}

	public List<ProfessionaldetailDO> getProfessionaldetails() {
		return this.professionaldetails;
	}

	public void setProfessionaldetails(List<ProfessionaldetailDO> professionaldetails) {
		this.professionaldetails = professionaldetails;
	}

	public ProfessionaldetailDO addProfessionaldetail(ProfessionaldetailDO professionaldetail) {
		getProfessionaldetails().add(professionaldetail);
		professionaldetail.setProfession(this);

		return professionaldetail;
	}

	public ProfessionaldetailDO removeProfessionaldetail(ProfessionaldetailDO professionaldetail) {
		getProfessionaldetails().remove(professionaldetail);
		professionaldetail.setProfession(null);

		return professionaldetail;
	}

	public List<ProfessionalpracticemappingDO> getProfessionalpracticemappings() {
		return this.professionalpracticemappings;
	}

	public void setProfessionalpracticemappings(List<ProfessionalpracticemappingDO> professionalpracticemappings) {
		this.professionalpracticemappings = professionalpracticemappings;
	}

	public ProfessionalpracticemappingDO addProfessionalpracticemapping(ProfessionalpracticemappingDO professionalpracticemapping) {
		getProfessionalpracticemappings().add(professionalpracticemapping);
		professionalpracticemapping.setProfession(this);

		return professionalpracticemapping;
	}

	public ProfessionalpracticemappingDO removeProfessionalpracticemapping(ProfessionalpracticemappingDO professionalpracticemapping) {
		getProfessionalpracticemappings().remove(professionalpracticemapping);
		professionalpracticemapping.setProfession(null);

		return professionalpracticemapping;
	}

	public List<ProfessionattributeDO> getProfessionattributes() {
		return this.professionattributes;
	}

	public void setProfessionattributes(List<ProfessionattributeDO> professionattributes) {
		this.professionattributes = professionattributes;
	}

	public ProfessionattributeDO addProfessionattribute(ProfessionattributeDO professionattribute) {
		getProfessionattributes().add(professionattribute);
		professionattribute.setProfession(this);

		return professionattribute;
	}

	public ProfessionattributeDO removeProfessionattribute(ProfessionattributeDO professionattribute) {
		getProfessionattributes().remove(professionattribute);
		professionattribute.setProfession(null);

		return professionattribute;
	}

}