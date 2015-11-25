package com.pridet.bo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="avd")
public class AdvProfileBO {
	
	private String name;
	private int age;
	private boolean isActive;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	

}
