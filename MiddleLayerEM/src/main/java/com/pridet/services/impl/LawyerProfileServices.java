package com.pridet.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pridet.bo.AdvProfileBO;

@Service("lawyerprofile")
public class LawyerProfileServices{
	
	public List<AdvProfileBO> getAllLawyerProfile(){
		List<AdvProfileBO> advlist = new ArrayList<AdvProfileBO>();
		AdvProfileBO adv1 = new AdvProfileBO();
		adv1.setName("Mr.Das");
		adv1.setAge(30);
		adv1.setActive(true);

		AdvProfileBO adv2 = new AdvProfileBO();
		adv2.setName("Mr.Saha");
		adv2.setAge(34);
		
		advlist.add(adv1);
		advlist.add(adv2);
		
		return advlist;

	}

}
