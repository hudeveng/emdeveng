package com.pridet.dao;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.pridet.dbo.MedicineStoreDO;

@Repository("medicineStoreDao")
@Transactional
public class MedicineStoreDao extends BaseDao{
	
	public MedicineStoreDO saveStore(MedicineStoreDO msdo){
		getSession().save(msdo);
		System.out.println(msdo.getId());
		return msdo;
	}
	
	
}
