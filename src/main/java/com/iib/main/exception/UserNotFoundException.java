package com.iib.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	 
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public UserNotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public UserNotFoundException() {
		// TODO Auto-generated constructor stub
		super();
	}
}
