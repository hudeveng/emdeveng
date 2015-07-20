package com.pridet.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.pridet.dbo.StateDO;

@Repository("statedao")
@Transactional
public class StateDao extends BaseDao {
	
	public StateDO getStateDObyID(int id) {
		StateDO statedo = (StateDO) getSession().get(StateDO.class, id);
		return statedo;
	}
	
	public List<StateDO> findAllStates(){
		Criteria criteria = getSession().createCriteria(StateDO.class);
		return criteria.list();
	}
}
