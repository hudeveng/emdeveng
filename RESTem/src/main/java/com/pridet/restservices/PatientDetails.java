package com.pridet.restservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.pridet.bo.PatientBO;
import com.pridet.constant.ServiceTypesConstants;


@Path("/patient")
public class PatientDetails extends BaseRestService{


	public PatientDetails() {
		super(ServiceTypesConstants.PATIENT);
	}
	
	@GET
	@Path("/getpatient/{id}")
	@Produces("application/json")
	public PatientBO getPatientDetails(@PathParam("id") int id){
		PatientBO pbo=new PatientBO();
		try {
			pbo.setId(id);
			pbo=(PatientBO) deliveredService.getBeanDetails(pbo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pbo;
	}
	
	@POST
	@Path("/registration")
	@Produces("application/json")
	@Consumes("application/json")
	public PatientBO regPatientDetails(PatientBO pbo){
		try {
			pbo=(PatientBO) deliveredService.saveBeanDetails(pbo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pbo;
	}
		
}
