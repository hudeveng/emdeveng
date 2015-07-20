package com.pridet.mapper;

import org.apache.commons.beanutils.BeanUtils;

import com.pridet.bo.CityBO;
import com.pridet.bo.CountryBO;
import com.pridet.bo.PatientBO;
import com.pridet.bo.StateBO;
import com.pridet.bo.UserTypeBO;
import com.pridet.dbo.PatientDO;

public class PatientMapper {

	public static PatientBO getPatientBO(PatientDO pdo) {
		PatientBO pbo = new PatientBO();
		try {
			BeanUtils.copyProperties(pbo, pdo);
			if (pdo.getCityDO() != null) {
				CityBO citybo = new CityBO();
				citybo.setCityname(pdo.getCityDO().getCityname());
				citybo.setId(pdo.getCityDO().getId());
				pbo.setCity(citybo);
			}
			if (pdo.getStateDO() != null) {
				StateBO statebo = new StateBO();
				statebo.setId(pdo.getStateDO().getId());
				statebo.setStatename(pdo.getStateDO().getStatename());
				pbo.setState(statebo);
			}
			if(pdo.getCountryDO()!=null){
				CountryBO countrybo=new CountryBO();
				countrybo.setCountryname(pdo.getCountryDO().getCountryname());
				countrybo.setCurrency(pdo.getCountryDO().getCurrency());
				countrybo.setId(pdo.getCountryDO().getId());
				pbo.setCountry(countrybo);
			}
			if(pdo.getUsertypeDO()!=null){
				UserTypeBO ubo=new UserTypeBO();
				ubo.setId(pdo.getUsertypeDO().getId());
				ubo.setUserType(pdo.getUsertypeDO().getUserType());
				pbo.setUsertype(ubo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return pbo;
	}
	
	public static PatientDO getPatientDO(PatientBO pbo){
		PatientDO pdo=new PatientDO();
		try {
			BeanUtils.copyProperties(pdo, pbo);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return pdo;
	}
	
	
}
