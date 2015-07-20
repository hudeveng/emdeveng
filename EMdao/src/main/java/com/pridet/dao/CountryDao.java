package com.pridet.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.pridet.dbo.CountryDO;

@Repository("countrydo")
@Transactional
public class CountryDao extends BaseDao{

	public CountryDO getCountryDObyID(int id){
		return (CountryDO) getSession().get(CountryDO.class, id);
	}
	
	public List<CountryDO> findAllCountries(){
		Criteria criteria = getSession().createCriteria(CountryDO.class);
		return criteria.list();
	}
}
