package com.pridet.restservices;

import com.pridet.constant.ServiceTypesConstants;
import com.pridet.factory.ServiceFactory;
import com.pridet.services.IServices;

public class BaseRestService {

	protected IServices deliveredService;
	
	public BaseRestService(ServiceTypesConstants type) {
		deliveredService=ServiceFactory.getService(type);
	}
	
	public BaseRestService() {
	}
	
}
