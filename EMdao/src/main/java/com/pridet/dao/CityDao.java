package com.pridet.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.pridet.dbo.CityDO;

@Repository("citydao")
@Transactional
public class CityDao extends BaseDao{

	public CityDO getCityDObyID(int id){
		CityDO citydo=(CityDO) getSession().get(CityDO.class, id);
		return citydo;
	}
	
	public List<CityDO> findAllCities(){
		Criteria criteria = getSession().createCriteria(CityDO.class);
		return criteria.list();
	}
}
