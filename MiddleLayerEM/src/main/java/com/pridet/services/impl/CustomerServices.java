package com.pridet.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pridet.bo.BaseBO;
import com.pridet.bo.UserBO;
import com.pridet.bo.UserTypeBO;
import com.pridet.dao.Userdao;
import com.pridet.dbo.UserDO;
import com.pridet.dbo.UserTypeDO;
import com.pridet.services.IServices;

@Service("customerservice")
public class CustomerServices implements IServices{

	@Autowired
	Userdao dao;

	public UserBO saveUser(UserBO ubo) {
		UserDO user = new UserDO();
		try {
			UserTypeDO utype = dao.findUserTypeByID(ubo.getUsertypeID());
			BeanUtils.copyProperties(user, ubo);
			user.setUsertype(utype);
			dao.saveUser(user);
			ubo.setId(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ubo;
	}

	public List<UserBO> listAllUser() {

		List<UserBO> userBOlt = null;
		try {
			List<UserDO> userDOlt = dao.findAllUser();
			if (userDOlt != null) {
				userBOlt = new ArrayList<UserBO>();
				for (UserDO userDO : userDOlt) {
					UserBO bo = new UserBO();
					BeanUtils.copyProperties(bo, userDO);
					userBOlt.add(bo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userBOlt;
	}

	public UserBO getUserDetails(int id) {
		UserBO bo = null;
		try {
			UserDO udo = dao.getUserbyID(id);
			if (udo != null) {
				bo = new UserBO();
				BeanUtils.copyProperties(bo, udo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	public List<UserTypeBO> listAllUserType() {

		List<UserTypeBO> utypebolt = null;
		try {
			List<UserTypeDO> utypedolt = dao.findAllUserType();
			if (utypedolt != null) {
				utypebolt = new ArrayList<UserTypeBO>();
				for (UserTypeDO userTypeDO : utypedolt) {
					UserTypeBO ubo = new UserTypeBO();
					BeanUtils.copyProperties(ubo, userTypeDO);
					utypebolt.add(ubo);
				}
			}
		} catch (Exception e) {
		}
		return utypebolt;
	}

	@Override
	public BaseBO saveBeanDetails(BaseBO basebo) {
		// TODO Auto-generated method stub
		return null;
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
