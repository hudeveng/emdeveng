package com.pridet.restservices;

import java.io.InputStream;
import java.util.Properties;

import com.pridet.constant.ServiceTypesConstants;
import com.pridet.factory.ServiceFactory;
import com.pridet.services.IServices;

public class BaseRestService {

	protected IServices deliveredService;
	protected Properties prop = new Properties();
	private InputStream input = null;
	
	public BaseRestService(ServiceTypesConstants type) {
		deliveredService=ServiceFactory.getService(type);
		try {
			input = BaseRestService.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public BaseRestService() {
		
	}
	
}
