package com.pridet.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pridet.ElasticSearch.ElasticSearchUtil;
import com.pridet.bo.BaseBO;
import com.pridet.bo.PatientBO;
import com.pridet.dao.CityDao;
import com.pridet.dao.CountryDao;
import com.pridet.dao.PatientDao;
import com.pridet.dao.StateDao;
import com.pridet.dao.Userdao;
import com.pridet.dbo.CityDO;
import com.pridet.dbo.CountryDO;
import com.pridet.dbo.PatientDO;
import com.pridet.dbo.StateDO;
import com.pridet.dbo.UserTypeDO;
import com.pridet.mapper.PatientMapper;
import com.pridet.services.IServices;

@Service("patientservice")
public class PatientServices implements IServices {
	@Autowired
	PatientDao pdao;
	@Autowired
	CityDao citydao;
	@Autowired
	StateDao statedao;
	@Autowired
	CountryDao countryDao;
	@Autowired
	Userdao userdao;

	private PatientBO getPatientDetails(int id) {
		PatientBO pbo = null;
		try {
			PatientDO pdo = pdao.getPatientbyID(id);
			if (pdo != null) {
				pbo = PatientMapper.getPatientBO(pdo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pbo;
	}

	private PatientBO savePatientDetails(PatientBO pbo) {
		System.out.println("name:"+pbo.getFirstname());
		System.out.println("cname:"+pbo.getCity().getCityname());
		System.out.println("cid:"+pbo.getCity().getId());
		System.out.println("id:"+pbo.getId());
		PatientDO pdo = null;
		try {
			pdo = PatientMapper.getPatientDO(pbo);
			CityDO cityDO = citydao.getCityDObyID(pbo.getCity().getId());
			System.out.println("city name:"+cityDO.getCityname());
			CountryDO countryDO = countryDao.getCountryDObyID(pbo.getCountry()
					.getId());
			System.out.println("country name:"+countryDO.getCountryname());
			System.out.println("country currency:"+countryDO.getCurrency());
			StateDO stateDO = statedao.getStateDObyID(pbo.getState().getId());
			System.out.println("state name:"+stateDO.getStatename());
			UserTypeDO utype=userdao.findUserTypeByID(pbo.getUsertype().getId());
			System.out.println("Utype"+utype.getUserType());
			pdo.setCityDO(cityDO);
			pdo.setCountryDO(countryDO);
			pdo.setStateDO(stateDO);
			pdo.setUsertypeDO(utype);
			pdo = (PatientDO) pdao.savePatient(pdo);
			System.out.println("id:"+pdo.getId());
			pbo = PatientMapper.getPatientBO(pdo);
			ElasticSearchUtil esu = new ElasticSearchUtil();
			esu.saveDetails(pbo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pbo;
	}

	@Override
	public BaseBO saveBeanDetails(BaseBO basebo) {
		PatientBO pbo = null;
		try {
			pbo = (PatientBO) basebo;
			pbo = savePatientDetails(pbo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pbo;
	}

	@Override
	public List<BaseBO> saveBeanDetails(List<BaseBO> basebo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseBO updateBeanDetails(BaseBO basebo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseBO> updateBeanDetails(List<BaseBO> basebo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseBO deleteBeanDetails(BaseBO basebo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseBO> deleteBeanDetails(List<BaseBO> basebo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseBO getBeanDetails(BaseBO basebo) {
		PatientBO pbo = null;
		try {
			pbo = (PatientBO) basebo;
			pbo = getPatientDetails(pbo.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pbo;
	}

	@Override
	public List<BaseBO> getBeanDetails(List<BaseBO> basebo) {
		// TODO Auto-generated method stub
		return null;
	}

}
