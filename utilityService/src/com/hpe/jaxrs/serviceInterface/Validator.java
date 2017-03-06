package com.hpe.jaxrs.serviceInterface;

import com.hpe.jaxrs.model.Credentials;

public interface Validator {

	public String emailFormatValidate(String emailId);
	
	public String authenticateUser(Credentials credentials);
}
