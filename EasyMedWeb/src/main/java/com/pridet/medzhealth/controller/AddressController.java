package com.pridet.medzhealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pridet.bo.CityBO;
import com.pridet.bo.CountryBO;
import com.pridet.bo.StateBO;
import com.pridet.services.impl.AddressHelper;

@RestController
@RequestMapping("/location")
public class AddressController {
	
	@Autowired
	AddressHelper addresshelper;
	
	@RequestMapping(value="/getcity",method = RequestMethod.GET)
	public List<CityBO> getAllCities(){ 
		return addresshelper.getCity();
	}
	
	@RequestMapping(value="/getcity/{id}",method = RequestMethod.GET)
	public CityBO getCity(@PathVariable int id){
		return addresshelper.getCity(id);
	}
	
	@RequestMapping(value="/getstate",method = RequestMethod.GET)
	public List<StateBO> getAllStates(){ 
		return addresshelper.getState();
	}
	
	@RequestMapping(value="/getstate/{id}",method = RequestMethod.GET)
	public StateBO getState(@PathVariable int id){ 
		return addresshelper.getState(id);
	}
	
	@RequestMapping(value="/getcountry",method = RequestMethod.GET)
	public List<CountryBO> getAllCountries(){
		return addresshelper.getCountry();
	}
	
	@RequestMapping(value="/getcountry/{id}",method = RequestMethod.GET)
	public CountryBO getAllCountry(@PathVariable int id){
		return addresshelper.getCountry(id);
	}
	
	
	

}
