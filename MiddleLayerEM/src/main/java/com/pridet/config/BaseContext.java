package com.pridet.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public enum BaseContext {

	SINGLETON_INSTANCE;
	
	public AbstractApplicationContext getContext(){
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class,DaoConfig.class);
		System.out.println("Context Loaded......................");
		return context;
	}
	
}
