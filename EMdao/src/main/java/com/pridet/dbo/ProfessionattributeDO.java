package com.pridet.dbo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the professionattributes database table.
 * 
 */
@Entity
@Table(name="professionattributes")
@NamedQuery(name="ProfessionattributeDO.findAll", query="SELECT p FROM ProfessionattributeDO p")
public class ProfessionattributeDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Lob
	private byte[] attributes;

	//bi-directional many-to-one association to ProfessionDO
	@ManyToOne
	@JoinColumn(name="professionid")
	private ProfessionDO profession;

	public ProfessionattributeDO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getAttributes() {
		return this.attributes;
	}

	public void setAttributes(byte[] attributes) {
		this.attributes = attributes;
	}

	public ProfessionDO getProfession() {
		return this.profession;
	}

	public void setProfession(ProfessionDO profession) {
		this.profession = profession;
	}

}