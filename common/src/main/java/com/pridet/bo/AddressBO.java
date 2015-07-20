package com.pridet.bo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="location")
public class AddressBO {

	private String city;
	private String State;
	private String street;
	private String area;
	private int pin;
	private int num;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	
	
}
