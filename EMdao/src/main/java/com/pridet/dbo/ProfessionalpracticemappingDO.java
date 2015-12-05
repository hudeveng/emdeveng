package com.pridet.dbo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the professionalpracticemapping database table.
 * 
 */
@Entity
@Table(name="professionalpracticemapping")
@NamedQuery(name="ProfessionalpracticemappingDO.findAll", query="SELECT p FROM ProfessionalpracticemappingDO p")
public class ProfessionalpracticemappingDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to ProfessionaldetailDO
	@OneToMany(mappedBy="professionalpracticemappingBean")
	private List<ProfessionaldetailDO> professionaldetails;

	//bi-directional many-to-one association to PracticeareaDO
	@ManyToOne
	@JoinColumn(name="practiceareas")
	private PracticeareaDO practicearea;

	//bi-directional many-to-one association to ProfessionDO
	@ManyToOne
	@JoinColumn(name="professionsid")
	private ProfessionDO profession;

	public ProfessionalpracticemappingDO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ProfessionaldetailDO> getProfessionaldetails() {
		return this.professionaldetails;
	}

	public void setProfessionaldetails(List<ProfessionaldetailDO> professionaldetails) {
		this.professionaldetails = professionaldetails;
	}

	public ProfessionaldetailDO addProfessionaldetail(ProfessionaldetailDO professionaldetail) {
		getProfessionaldetails().add(professionaldetail);
		professionaldetail.setProfessionalpracticemappingBean(this);

		return professionaldetail;
	}

	public ProfessionaldetailDO removeProfessionaldetail(ProfessionaldetailDO professionaldetail) {
		getProfessionaldetails().remove(professionaldetail);
		professionaldetail.setProfessionalpracticemappingBean(null);

		return professionaldetail;
	}

	public PracticeareaDO getPracticearea() {
		return this.practicearea;
	}

	public void setPracticearea(PracticeareaDO practicearea) {
		this.practicearea = practicearea;
	}

	public ProfessionDO getProfession() {
		return this.profession;
	}

	public void setProfession(ProfessionDO profession) {
		this.profession = profession;
	}

}