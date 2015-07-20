package com.pridet.security;

import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.cxf.jaxrs.interceptor.JAXRSInInterceptor;
import org.apache.cxf.message.Message;

import javax.ws.rs.core.Response;


public class AuthenticationHandler extends JAXRSInInterceptor{

	private static final String BASIC_AUTH = "Authorization";
	
	 public void handleMessage(Message message) {
		 Map<String, List<?>> headers = (Map<String, List<?>>) message.get(Message.PROTOCOL_HEADERS);
		 String basicToken = headers.get(BASIC_AUTH).toString();
			basicToken = formatData(basicToken);
			String decodedValue = base64UrlDecode(basicToken.split(" ")[1]).toString();
			String[] entries = decodedValue.split(":");
			String userName = entries[0];
			String password = entries[1];
			if(!userName.equalsIgnoreCase("datta")){  
				Response response = Response.status(Response.Status.UNAUTHORIZED).entity("The User name is incorrect").build();
				message.getExchange().put(Response.class, response);
			}
			if(!password.equalsIgnoreCase("reset")){
				Response response = Response.status(Response.Status.UNAUTHORIZED).entity("The password is incorrect").build();
				message.getExchange().put(Response.class, response);
			}
		 
	 }
	 
	 private String formatData (String input) {
			input = input.replace("[", "");
			input = input.replace("]", "");
			return input;
			
		}
	 
	 private static String base64UrlDecode(String input) {
		    String result = null;
		    Base64 decoder = new Base64(true);
		    byte[] decodedBytes = decoder.decode(input);
		    result = new String(decodedBytes);
		    return result;
		}
}
