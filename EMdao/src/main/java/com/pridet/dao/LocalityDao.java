package com.pridet.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pridet.dbo.LocalityDO;


@Repository("localitydao")
@Transactional
public class LocalityDao extends BaseDao{

	public LocalityDO getLocality(int id) {
		LocalityDO localityDO=(LocalityDO) getSession().get(LocalityDO.class, id);
		return localityDO;
	}
	
	public List<LocalityDO> getLocality() {
		Criteria criteria = getSession().createCriteria(LocalityDO.class);
		return criteria.list();
	}
}
