package com.iib.main.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
	

	
	  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
	      throws IOException, ServletException {
	    // 401
		  
		 
	    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed");
	    PrintWriter writer = response.getWriter();
	    writer.print("Incorrect Username and password");
	  }

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			org.springframework.security.core.AuthenticationException authException)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
//
//

}