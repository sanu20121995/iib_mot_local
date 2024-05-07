package com.iib.gov.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import io.jsonwebtoken.ExpiredJwtException;

//@ControllerAdvice
//public class HandlerController {
//	 @ExceptionHandler(Exception.class)
//	    public ResponseEntity<Object> handle(Exception ex, 
//	                HttpServletRequest request, HttpServletResponse response) {
//	        if (ex instanceof ExpiredJwtException) {
//	            return new ResponseEntity<>("Unauthorized by vahan api",HttpStatus.BAD_REQUEST);
//	        }
//	       // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//	    }
//}

