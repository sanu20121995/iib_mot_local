package com.iib.gov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iib.gov.config.JwtTokenUtil;
import com.iib.gov.model.JwtRequset;
import com.iib.gov.model.JwtResponse;
import com.iib.gov.service.CustomUserDetailService;

@RestController
public class JwtController {
	
	@Autowired
	private CustomUserDetailService userService;
	
    @Autowired
	private JwtTokenUtil util;
	
    @Autowired
	private AuthenticationManager manager;
	

	@PostMapping(value = "/token")
	public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequset request) throws Exception{
		
		System.err.println(request);
//		try {
		manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			throw new Exception("Bad Credentials...");
//		}
		
		//get userdetails
		
		UserDetails details = userService.loadUserByUsername(request.getUsername());
		
		System.err.println(details.getPassword());
		//generate token 
		String generatedToken = util.generateToken(details);
		System.err.println("Generated Token:"+ generatedToken);
		long expires_in=3600;
		long ContestedOn = System.currentTimeMillis();
		
		
		return ResponseEntity.ok(new JwtResponse(generatedToken, expires_in, ContestedOn));
		
	}
	
	
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@ExceptionHandler(value = BadCredentialsException.class)
//    public ResponseEntity handleBlogAlreadyExistsException(BadCredentialsException blogAlreadyExistsException) {
//        return new ResponseEntity("Bad credentials.Pls check again before sending request", HttpStatus.CONFLICT);
//    }
//	
	
	
	
}
