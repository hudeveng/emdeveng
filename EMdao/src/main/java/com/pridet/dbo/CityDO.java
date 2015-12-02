package com.pridet.dbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="city")
public class CityDO extends BaseDO{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	private String dummy;
	
	@Size(min=1, max=50)
	@Column(name = "cityname", nullable = false)
	private String cityname;
	
	@JoinColumn(name = "country")
    @ManyToOne(optional = false)
	private CountryDO country;
	
	@JoinColumn(name = "state")
    @ManyToOne(optional = false)
	private StateDO stateDO;
	
	private LocalityDO localityDO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public CountryDO getCountry() {
		return country;
	}

	public void setCountry(CountryDO country) {
		this.country = country;
	}

	public StateDO getStateDO() {
		return stateDO;
	}

	public void setStateDO(StateDO stateDO) {
		this.stateDO = stateDO;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	public LocalityDO getLocalityDO() {
		return localityDO;
	}

	public void setLocalityDO(LocalityDO localityDO) {
		this.localityDO = localityDO;
	}

	
	
}
