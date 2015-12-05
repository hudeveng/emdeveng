package com.pridet.dbo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the practiceareas database table.
 * 
 */
@Entity
@Table(name="practiceareas")
@NamedQuery(name="PracticeareaDO.findAll", query="SELECT p FROM PracticeareaDO p")
public class PracticeareaDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String practiceareas;

	//bi-directional many-to-one association to ProfessionDO
	@ManyToOne
	@JoinColumn(name="professionid")
	private ProfessionDO profession;

	//bi-directional many-to-one association to ProfessionalpracticemappingDO
	@OneToMany(mappedBy="practicearea")
	private List<ProfessionalpracticemappingDO> professionalpracticemappings;

	public PracticeareaDO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPracticeareas() {
		return this.practiceareas;
	}

	public void setPracticeareas(String practiceareas) {
		this.practiceareas = practiceareas;
	}

	public ProfessionDO getProfession() {
		return this.profession;
	}

	public void setProfession(ProfessionDO profession) {
		this.profession = profession;
	}

	public List<ProfessionalpracticemappingDO> getProfessionalpracticemappings() {
		return this.professionalpracticemappings;
	}

	public void setProfessionalpracticemappings(List<ProfessionalpracticemappingDO> professionalpracticemappings) {
		this.professionalpracticemappings = professionalpracticemappings;
	}

	public ProfessionalpracticemappingDO addProfessionalpracticemapping(ProfessionalpracticemappingDO professionalpracticemapping) {
		getProfessionalpracticemappings().add(professionalpracticemapping);
		professionalpracticemapping.setPracticearea(this);

		return professionalpracticemapping;
	}

	public ProfessionalpracticemappingDO removeProfessionalpracticemapping(ProfessionalpracticemappingDO professionalpracticemapping) {
		getProfessionalpracticemappings().remove(professionalpracticemapping);
		professionalpracticemapping.setPracticearea(null);

		return professionalpracticemapping;
	}

}