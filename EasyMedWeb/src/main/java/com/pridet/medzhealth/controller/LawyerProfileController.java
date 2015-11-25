package com.pridet.medzhealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pridet.bo.AdvProfileBO;
import com.pridet.services.impl.LawyerProfileServices;

@RestController
public class LawyerProfileController {

	@Autowired
	LawyerProfileServices lawyerProfileServices;

	@RequestMapping(value = "/advprof/", method = RequestMethod.GET)
	public List<AdvProfileBO> getLawyerList() {
		
		return lawyerProfileServices.getAllLawyerProfile();

	}
}
