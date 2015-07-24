package com.pridet.mapper;

import org.apache.commons.beanutils.BeanUtils;

import com.pridet.bo.MedicineStoreBO;
import com.pridet.dbo.MedicineStoreDO;

public class MedicineStoreMapper {

	public static MedicineStoreDO getMedicineStoreDO(MedicineStoreBO msbo) {
		MedicineStoreDO msdo=new MedicineStoreDO();
		try {
			BeanUtils.copyProperties(msdo, msbo);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return msdo;
	}

	public static MedicineStoreBO getMedicineStoreBO(MedicineStoreDO msdo) {
		MedicineStoreBO msbo=new MedicineStoreBO();
		try {
			BeanUtils.copyProperties(msbo, msdo);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return msbo;
	}

}
