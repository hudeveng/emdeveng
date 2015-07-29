package com.pridet.constant;

public enum ServiceTypesConstants {
	PATIENT("patientservice"), CUSTOMER("customerservice"), ADDRESSHELPER("addresshelper"),MEDICALSTORES("medicineStoreServices");

	private ServiceTypesConstants(String servicename) {
		this.setServicename(servicename);
	}
	
	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	private String servicename;

}
