package com.pridet.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.pridet.dbo.PatientDO;

@Repository("patientdao")
@Transactional
public class PatientDao extends BaseDao{

	
	public PatientDO getPatientbyID(int id){
		PatientDO pdo=(PatientDO) getSession().get(PatientDO.class, id);	
		return pdo;
	}
	
	public PatientDO savePatient(PatientDO pdo){
		getSession().save(pdo);
		System.out.println(pdo.getId());
		return pdo;
	}
	
	
}
