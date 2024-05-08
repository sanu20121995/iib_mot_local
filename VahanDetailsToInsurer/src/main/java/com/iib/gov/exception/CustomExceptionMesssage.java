package com.iib.gov.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class CustomExceptionMesssage {
	
	private final String message;
	private final HttpStatus httpstatus;

	
	public String getMessage() {
		return message;
	}


	public HttpStatus getHttpstatus() {
		return httpstatus;
	}


	

	public CustomExceptionMesssage(String message, HttpStatus httpstatus) {
		super();
		this.message = message;
		this.httpstatus = httpstatus;
		
	}

}
