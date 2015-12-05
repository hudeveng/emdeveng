package com.pridet.dbo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the locality database table.
 * 
 */
@Entity
@Table(name="locality")
public class LocalityDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	//bi-directional many-to-one association to CityDO
	@ManyToOne
	@JoinColumn(name="city")
	private CityDO cityBean;

	public LocalityDO() {
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

	public CityDO getCityBean() {
		return this.cityBean;
	}

	public void setCityBean(CityDO cityBean) {
		this.cityBean = cityBean;
	}

}