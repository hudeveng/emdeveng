package com.pridet.factory;

import org.springframework.context.support.AbstractApplicationContext;

import com.pridet.config.BaseContext;
import com.pridet.constant.ServiceTypesConstants;
import com.pridet.services.IServices;
import com.pridet.services.impl.CustomerServices;
import com.pridet.services.impl.DefaultService;
import com.pridet.services.impl.MedicineStoreServices;
import com.pridet.services.impl.PatientServices;

public class ServiceFactory {

	private static AbstractApplicationContext context = BaseContext.SINGLETON_INSTANCE
			.getContext();

	public static IServices getService(ServiceTypesConstants type){
		if(ServiceTypesConstants.PATIENT.equals(type)){
			return (PatientServices)context.getBean(type.getServicename());
		} else if(ServiceTypesConstants.CUSTOMER.equals(type)){
			//return (CustomerServices)context.getBean(type.getServicename());
			return null;
		} else if(ServiceTypesConstants.MEDICALSTORES.equals(type)){
			return (MedicineStoreServices)context.getBean(type.getServicename());
		}else{
			//return (DefaultService)context.getBean(type.getServicename());
			return null;
		}
	}
}
