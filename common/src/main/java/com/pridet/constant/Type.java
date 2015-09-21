package com.pridet.constant;

public enum Type {
	PATIENT("patient"), CUSTOMER("customer"), MEDICALSTORES("medicineStore"), MEDICINE(
			"medicine"), DELIVERYBOY("deliveryboy"),STATE("state");

	private Type(String servicename) {
		this.setServicename(servicename);
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public static String[] names() {
		Type[] types = values();
	    String[] names = new String[types.length];

	    for (int i = 0; i < types.length; i++) {
	        names[i] = types[i].name();
	    }

	    return names;
	}
	
	private String servicename;

}
