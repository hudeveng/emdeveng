package com.pridet.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.pridet.dbo.UserDO;
import com.pridet.dbo.UserTypeDO;

@Repository("userdao")
@Transactional
public class Userdao extends BaseDao {

	public void saveUser(UserDO user){
		persist(user);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserDO> findAllUser(){
		Criteria criteria = getSession().createCriteria(UserDO.class);
		return (List<UserDO>) criteria.list();
	}
	
	public UserDO getUserbyID(int id){
		UserDO mu=(UserDO) getSession().get(UserDO.class, id);
		return mu;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserTypeDO> findAllUserType(){
		Criteria criteria = getSession().createCriteria(UserTypeDO.class);
		return (List<UserTypeDO>) criteria.list();
	}
	
	public UserTypeDO findUserTypeByID(int id){
		UserTypeDO type=(UserTypeDO) getSession().get(UserTypeDO.class, id);	
		return type;
	}
	
}
