package com.pridet.restservices;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.pridet.bo.UserBO;
import com.pridet.bo.UserTypeBO;
import com.pridet.constant.ServiceTypesConstants;

@Path("/register")
public class UserRegistration extends BaseRestService{

	public UserRegistration() {
		super(ServiceTypesConstants.CUSTOMER);
	}
	
	//CustomerServices cusServices;
	
	@POST
	@Path("/newuser")
	@Produces("application/json")
	@Consumes("application/json")
	public UserBO registerNewUser(UserBO userco) {

		//userco = cusServices.saveUser(userco);
		return userco;
	}

	@GET
	@Path("/getdetails/{id}")
	@Produces("application/json")
	public UserBO getUserDetails(@PathParam("id") int id) {
		//UserBO bo=cusServices.getUserDetails(id);
		return null;
	}

	@GET
	@Path("/getallusertype")
	@Produces("application/json")
	public List<UserTypeBO> getAllUserType() {
		return null;
		//return cusServices.listAllUserType();
	}

}
