package com.pridet.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pridet.ElasticSearch.ElasticSearchUtil;
import com.pridet.bo.BaseBO;
import com.pridet.bo.MedicineStoreBO;
import com.pridet.dao.CityDao;
import com.pridet.dao.CountryDao;
import com.pridet.dao.MedicineStoreDao;
import com.pridet.dao.StateDao;
import com.pridet.dbo.MedicineStoreDO;
import com.pridet.mapper.MedicineStoreMapper;
import com.pridet.services.IServices;

@Service("medicineStoreServices")
public class MedicineStoreServices implements IServices {
	@Autowired
	MedicineStoreDao msdao;
	@Autowired
	CityDao citydao;
	@Autowired
	StateDao statedao;
	@Autowired
	CountryDao countryDao;
	
	private MedicineStoreBO saveMedicineStoreDetails(MedicineStoreBO msbo) {
		MedicineStoreDO msdo = null;
		try {
			msdo = MedicineStoreMapper.getMedicineStoreDO(msbo);
			/*CityDO cityDO = citydao.getCityDObyID(msbo.getCity());
			System.out.println("city name:"+cityDO.getCityname());
			CountryDO countryDO = countryDao.getCountryDObyID(msbo.getCountry());
			System.out.println("country name:"+countryDO.getCountryname());
			StateDO stateDO = statedao.getStateDObyID(msbo.getState());
			System.out.println("state name:"+stateDO.getStatename());
			//redundant code
			msdo.setCity(cityDO.getId());
			msdo.setCountry(countryDO.getId());
			msdo.setState(stateDO.getId());*/
			msdo = (MedicineStoreDO) msdao.saveStore(msdo);
			System.out.println("id:"+msdo.getId());
			msbo = MedicineStoreMapper.getMedicineStoreBO(msdo);
			ElasticSearchUtil esu = new ElasticSearchUtil();
			esu.saveDetails(msbo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msbo;
	}
	

	public List<MedicineStoreBO> getMedicalStoresInLocation(MedicineStoreBO msbo) {

		MedicineStoreDO msdo = null;
		List<MedicineStoreBO> medicalStoreBOs = new ArrayList<MedicineStoreBO>();

		try {
			msdo = MedicineStoreMapper.getMedicineStoreDO(msbo);
			List<MedicineStoreDO> medicalStores = msdao.findStoresByLatitudeAndLongitude(msdo);
			for (MedicineStoreDO medicineStoreDO : medicalStores) {
				MedicineStoreBO amsbo = MedicineStoreMapper.getMedicineStoreBO(medicineStoreDO);
				System.out.println("storename" + amsbo.getStorename());
				medicalStoreBOs.add(amsbo);
			}
			msbo = MedicineStoreMapper.getMedicineStoreBO(msdo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medicalStoreBOs;

	}
	
	
	
	@Override
	public BaseBO saveBeanDetails(BaseBO basebo) {
		MedicineStoreBO msbo = null;
		try {
			msbo = (MedicineStoreBO) basebo;
			msbo = saveMedicineStoreDetails(msbo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msbo;
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<BaseBO> getBeanDetails(List<BaseBO> basebo) {
		// TODO Auto-generated method stub
		return null;
	}
}
