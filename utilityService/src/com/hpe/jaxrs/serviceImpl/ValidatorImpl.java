package com.hpe.jaxrs.serviceImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hpe.jaxrs.model.Credentials;
import com.hpe.jaxrs.serviceInterface.Validator;

@Path("/rest")
public class ValidatorImpl implements Validator{

	@POST
	@Path("/emailFormatValidate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String emailFormatValidate(String emailId){
		String Email_Regex = "^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(Email_Regex);
		Matcher matcher = pattern.matcher(emailId);
		//int size = emailId.length();
		/*if (emailId.equalsIgnoreCase(null))
			return "email can not be null";
		
		if (emailId.indexOf(size-1) == '@' || emailId.indexOf(size-1) == '.')
			return "Invalid email Id";*/
		
		if ((!emailId.isEmpty()) && (emailId!=null))
			return "valid mail";
					
		return "hi";
	}
	
	@POST
	@Path("/authenticateUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String authenticateUser(Credentials credentials){
		
		if(credentials.getUserId().equalsIgnoreCase("admin") && credentials.getPwd().equals("admin"))
			return "user authenticated - you can proceed further !!!";
		
		return "Invalid uerId or Password";
	}
	
}
