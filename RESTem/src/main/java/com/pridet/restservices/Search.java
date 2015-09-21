package com.pridet.restservices;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.context.support.AbstractApplicationContext;

import com.pridet.bo.SearchBO;
import com.pridet.config.BaseContext;
import com.pridet.constant.ServiceTypesConstants;
import com.pridet.services.impl.SearchServices;

public class Search extends BaseRestService {

	private AbstractApplicationContext context = BaseContext.SINGLETON_INSTANCE
			.getContext();

	SearchServices searchServices = (SearchServices) context
			.getBean(ServiceTypesConstants.SEARCHSERVICES.getServicename());

	@GET
	@Path("/search/{query}")
	@Produces("application/json")
	public List<SearchBO> search(@PathParam("query") String query) {

		return searchServices.search(query);

	}
}
