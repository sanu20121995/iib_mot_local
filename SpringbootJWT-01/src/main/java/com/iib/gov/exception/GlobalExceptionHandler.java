package com.iib.gov.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	  @Value(value = "${data.exception.message1}")
	    private String message1;
//	    @Value(value = "${data.exception.message2}")
//	    private String message2;
//	    @Value(value = "${data.exception.message3}")
//	    private String message3;
	    
	    
	    
	    @SuppressWarnings({ "rawtypes", "unchecked" })
	    @ExceptionHandler(value = BadCredentialsException.class)
		public ResponseEntity Badcredentials(BadCredentialsException exception){
	    	
	    	return new ResponseEntity(message1, HttpStatus.CONFLICT);
	    	
	    }

}
