package com.pridet.mapper;

import org.apache.commons.beanutils.BeanUtils;

import com.pridet.bo.CityBO;
import com.pridet.bo.CountryBO;
import com.pridet.bo.StateBO;
import com.pridet.dbo.CityDO;
import com.pridet.dbo.CountryDO;
import com.pridet.dbo.StateDO;

public class LocationMapper {
	
	public static CityBO getCityBO(CityDO citydo){
		CityBO citybo=null;
		try {
			if(citydo!=null){
				citybo=new CityBO();
				BeanUtils.copyProperties(citybo, citydo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return citybo;
	}
	
	public static StateBO getStateBO(StateDO statedo){
		StateBO statebo=null;
		try {
			if(statedo!=null){
				statebo=new StateBO();
				BeanUtils.copyProperties(statebo, statedo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return statebo;
	}
	
	public static CountryBO getCountryBO(CountryDO countrydo){
		CountryBO countrybo=null;
		try {
			if(countrydo!=null){
				countrybo=new CountryBO();
				BeanUtils.copyProperties(countrybo, countrydo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return countrybo;
	}

}
