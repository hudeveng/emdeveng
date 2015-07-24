package com.pridet.medzhealth.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pridet.bo.BaseBO;
import com.pridet.bo.CityBO;
import com.pridet.bo.MedicineStoreBO;
import com.pridet.services.impl.AddressHelper;
import com.pridet.services.impl.MedicineStoreServices;

@Controller
public class AppController {
	
	@Autowired
	AddressHelper addresshelper;
	
	@Autowired
	MedicineStoreServices medicineStoreServices;
	
	@RequestMapping("/registerPage")
	public String loadRegistrationPage(@ModelAttribute("store") 
	MedicineStoreBO store, BindingResult result, ModelMap model, 
	HttpServletRequest request, HttpServletResponse response) {
		//get all cities, states and countries
		List<CityBO> cityList = addresshelper.getAllCities();
		model.addAttribute("cityList", cityList);
		model.addAttribute("name", "Guest");
		return "registration2";
	}

	@RequestMapping(value = "/saveDetails", method = RequestMethod.POST)
	@ResponseBody
	public String saveStoreDetails(@RequestBody String json, Model model) {
		
		MedicineStoreBO store = new MedicineStoreBO();
		//ObjectMapper mapper = new ObjectMapper();
		System.out.println("JSON : "+json);
		store.setOwnername("Shubhra Dutta");
		
		//MedicineStoreBO requestValue = mapper.readValue(json, MedicineStoreBO.class);
		/*if(null != requestValue){
			System.out.println(requestValue.getOwnername());
		}*/
		//store.setOwnername(requestValue.getOwnername());
		//store.setStorename(requestValue.getStorename());
		byte b = 0;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		store.setAddress("Hadapsar");
		store.setCity(1);
		store.setCountry(1);
		//YYYY-MM-DD HH:MM:SS
		//store.setCreatedon(dateFormat.format(date));
		store.setCreatedon(new Date());
		store.setDocumentssubmited(b);
		store.setIsactive(b);
		store.setLicennceno("11111");
		store.setOwnername("Shubhra");
		store.setPin(411028);
		store.setPrimarycontactno(1111111111);
		store.setState(1);
		store.setStorename("Dutta Drugs");
		store.setUpdatedbyid(1);
		//YYYY-MM-DD HH:MM:SS
		store.setUpdatedon(new Date());
		//update db
		BaseBO basebo = (BaseBO) store;
		basebo = medicineStoreServices.saveBeanDetails(basebo);
		store = (MedicineStoreBO) basebo;
		
		String message = "Thank you"+store.getId();
		model.addAttribute("success", message);
		return "success2";
	}
}
