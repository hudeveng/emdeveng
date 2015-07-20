package com.pridet.dbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="state")
public class StateDO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Size(min=1, max=50)
	@Column(name = "statename", nullable = false)
	private String statename;
	
	@JoinColumn(name = "country")
    @ManyToOne(optional = false)
	private CountryDO country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public CountryDO getCountry() {
		return country;
	}

	public void setCountry(CountryDO country) {
		this.country = country;
	}

	
	

	
}
