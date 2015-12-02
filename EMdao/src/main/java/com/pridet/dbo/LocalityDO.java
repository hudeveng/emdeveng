package com.pridet.dbo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "locality")
public class LocalityDO extends BaseDO {

	@Id
	@Column(name = "id")
	private int id;
	private String name;
	private Set<CityDO> cities = new HashSet<CityDO>();
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
	public Set<CityDO> getCities() {
		return cities;
	}
	public void setCities(Set<CityDO> cities) {
		this.cities = cities;
	}
	

}
