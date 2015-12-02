package com.pridet.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pridet.bo.CityBO;
import com.pridet.bo.CountryBO;
import com.pridet.bo.StateBO;
import com.pridet.dao.CityDao;
import com.pridet.dao.CountryDao;
import com.pridet.dao.StateDao;
import com.pridet.dbo.CityDO;
import com.pridet.dbo.CountryDO;
import com.pridet.dbo.StateDO;
import com.pridet.mapper.LocationMapper;

@Service("addresshelper")
public class AddressHelper {

	@Autowired
	CityDao citydao;
	@Autowired
	StateDao statedao; 
	@Autowired
	CountryDao countrydao;

	public List<CityBO> getCity() {
		List<CityDO> cityList = null;
		List<CityBO> citybolt = null;
		try {
			cityList = citydao.findAllCities();
			if (cityList != null && !cityList.isEmpty()) {
				citybolt = new ArrayList();
				for (CityDO cityDO : cityList) {
					CityBO citybo = LocationMapper.getCityBO(cityDO);
					citybolt.add(citybo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return citybolt;
	}

	public CityBO getCity(int id) {
		CityDO cityDO = citydao.getCityDObyID(id);
		return LocationMapper.getCityBO(cityDO);
	}

	public List<StateBO> getState() {
		List<StateDO> stateList = null;
		List<StateBO> statebolt = null;
		try {
			stateList = statedao.findAllStates();
			if (stateList != null && !stateList.isEmpty()) {
				statebolt = new ArrayList();
				for (StateDO stateDO : stateList) {
					StateBO statebo = LocationMapper.getStateBO(stateDO);
					statebolt.add(statebo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return statebolt;
	}

	public StateBO getState(int id) {
		StateDO stateDO = statedao.getStateDObyID(id);
		return LocationMapper.getStateBO(stateDO);
	}

	public List<CountryBO> getAllCountry() {
		List<CountryDO> countryList = null;
		List<CountryBO> countrybolt = null;
		try {
			countryList = countrydao.findAllCountries();
			if (countryList != null && !countryList.isEmpty()) {
				countrybolt = new ArrayList();
				for (CountryDO countryDO : countryList) {
					CountryBO countrybo = LocationMapper
							.getCountryBO(countryDO);
					countrybolt.add(countrybo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return countrybolt;
	}

	public CountryBO getCountry(int id) {
		CountryBO countryBO = null;
		CountryDO countryDO = null;
		try {
			countryDO = countrydao.getCountryDObyID(id);
			countryBO = LocationMapper.getCountryBO(countryDO);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return countryBO;
	}

}
