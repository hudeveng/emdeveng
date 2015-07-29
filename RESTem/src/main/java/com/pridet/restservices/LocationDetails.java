package com.pridet.restservices;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.context.support.AbstractApplicationContext;

import com.pridet.bo.CityBO;
import com.pridet.bo.CountryBO;
import com.pridet.bo.MedicineStoreBO;
import com.pridet.bo.StateBO;
import com.pridet.config.BaseContext;
import com.pridet.constant.ServiceTypesConstants;
import com.pridet.services.impl.AddressHelper;
import com.pridet.services.impl.MedicineStoreServices;

@Path("/location")
public class LocationDetails extends BaseRestService{

	private AbstractApplicationContext context = BaseContext.SINGLETON_INSTANCE
			.getContext();
	AddressHelper addressHelper=(AddressHelper)context.getBean(ServiceTypesConstants.ADDRESSHELPER.getServicename());
	MedicineStoreServices medicineStoreServices = (MedicineStoreServices) context.getBean(ServiceTypesConstants.MEDICALSTORES.getServicename());
	
	@GET
	@Path("/listcity")
	@Produces("application/json")
	public List<CityBO> getAllCities(){
		return addressHelper.getAllCities();
	}
	
	@GET
	@Path("/liststate")
	@Produces("application/json")
	public List<StateBO> getAllstates(){
		return addressHelper.getAllStates();
	}
	
	@GET
	@Path("/listcountry")
	@Produces("application/json")
	public List<CountryBO> getAllCountry(){
		return addressHelper.getAllCountries();
	}
	
	@GET
	@Path("/mobileDetails/{latitude}/{longitude}")
	@Produces("application/json")
	public List<MedicineStoreBO> getLocationByLatitudeAndLongitude(@PathParam("latitude") double latitude,@PathParam("longitude") double longitude){
		MedicineStoreBO msbo = new MedicineStoreBO();
		msbo.setLatitude(latitude);
		msbo.setLongitude(longitude);
		return medicineStoreServices.getMedicalStoresInLocation(msbo);
	}

}
