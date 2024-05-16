package com.iib.gov.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	 
	@ExceptionHandler(value = {CustomException.class})
	public ResponseEntity<Object> getCustomMessage(CustomException ce){
		//create payload class object
		CustomExceptionMesssage customMessage=new CustomExceptionMesssage(ce.getMessage(), 
				HttpStatus.BAD_REQUEST);
		
		//return response entity object
		return new ResponseEntity<>(customMessage,HttpStatus.BAD_REQUEST);
		
	}

}
