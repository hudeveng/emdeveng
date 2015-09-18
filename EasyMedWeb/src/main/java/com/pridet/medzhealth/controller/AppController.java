package com.pridet.medzhealth.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pridet.bo.BaseBO;
import com.pridet.bo.CityBO;
import com.pridet.bo.CountryBO;
import com.pridet.bo.MedicineStoreBO;
import com.pridet.bo.StateBO;
import com.pridet.services.impl.AddressHelper;
import com.pridet.services.impl.MedicineStoreServices;

@Controller
public class AppController {
	
	@Autowired
	AddressHelper addresshelper;
	
	@Autowired
	MedicineStoreServices medicineStoreServices;
	
	private static final String LOGIN_VIEW = "login";
	private static final String REGISTER_VIEW = "register";
	private static final String WALL_VIEW = "wall";
	private static final String SUCCESS_VIEW = "success";
	
	@RequestMapping("/loginPage")
	public String loadLoginPage() {
		return LOGIN_VIEW;
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authenticateLoginDetails(@RequestBody String request) throws UnsupportedEncodingException {
		System.out.println("EncodedRequest : "+request);
		String decodedRequest = URLDecoder.decode(request, "UTF-8");
		System.out.println("DecodedRequest : "+decodedRequest);
		String[] arr = decodedRequest.split("&");
		String email = ((String[]) arr[0].split("="))[1];
		String password = ((String[]) arr[1].split("="))[1];
		System.out.println("EMAIL : "+email+" PASSWORD : "+password);
		//validate from db
		return WALL_VIEW;
	}

	@RequestMapping("/registerPage")
	public String loadRegistrationPage(ModelMap model) {
		MedicineStoreBO store = new MedicineStoreBO();
		model.addAttribute("store", store);
		//get all cities, states and countries
		List<CityBO> cityList = addresshelper.getAllCities();
		List<StateBO> stateList = addresshelper.getAllStates();
		List<CountryBO> countryList = addresshelper.getAllCountries();
		model.addAttribute("cityList", cityList);
		model.addAttribute("stateList", stateList);
		model.addAttribute("countryList", countryList);
		return REGISTER_VIEW;
	}

	@RequestMapping(value = "/saveDetails", method = RequestMethod.POST)
	public String saveStoreDetails(@ModelAttribute("store") MedicineStoreBO store, BindingResult bindingResult, ModelMap model) {
		//FormValidator validator = new FormValidator();
		//validator.validate(store, bindingResult);

		if(bindingResult.hasErrors()) {
			return REGISTER_VIEW;
		}
		byte b = 0;
		//store.setAddress("Hadapsar");
		//store.setCountry(1);
		//YYYY-MM-DD HH:MM:SS
		store.setCreatedon(new Date());
		store.setDocumentssubmited(b);
		store.setIsactive(b);
		//store.setLicennceno("11111");
		//store.setPin(411028);
		//store.setPrimarycontactno(1111111111);
		//store.setState(1);
		store.setUpdatedbyid(1);
		//YYYY-MM-DD HH:MM:SS
		store.setUpdatedon(new Date());
		store.setLatitude(1);
		store.setLongitude(1);
		
		//update db
		BaseBO basebo = (BaseBO) store;
		basebo = medicineStoreServices.saveBeanDetails(basebo);
		store = (MedicineStoreBO) basebo;
		
		String message = "Thank you "+store.getOwnername();
		model.addAttribute("success", message);
		return SUCCESS_VIEW;
	}
}
