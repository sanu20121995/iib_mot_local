package com.iib.gov.filter;




import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.iib.gov.exception.CustomException;
import com.iib.gov.service.JwtService;
import com.iib.gov.service.UserInfoService;

import io.jsonwebtoken.ExpiredJwtException; 

// This class helps us to validate the generated jwt token 
@Component
public class JwtAuthFilter extends OncePerRequestFilter { 

	@Autowired
	private JwtService jwtService; 

	@Autowired
	private UserInfoService userDetailsService; 

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		System.out.println("******************************************");
		String authHeader = request.getHeader("Authorization"); 
		String token = null; 
		String username = null; 
		Boolean tokenExpired=false;
		if (authHeader != null && authHeader.startsWith("Bearer ")) { 
			System.out.println("if block(jwtfilter)");
			token = authHeader.substring(7);
			System.out.println("Token"+token);
		
		
		try {
				 tokenExpired = jwtService.isTokenExpired(token);
		}
		
		catch(ExpiredJwtException e) {
			e.printStackTrace();
			
		}
				System.out.println(tokenExpired);
				try {
				
			username = jwtService.extractUsername(token);
			
			System.out.println("username(filter):"+ username);
			}
			
			catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} 
			
			
			
			catch(Exception e) {
				e.printStackTrace();
			}
		
		} 

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) { 
			System.out.println("calling load by username");
			
			UserDetails userDetails = userDetailsService.loadUserByUsername(username); 
			
			if (jwtService.validateToken(token, userDetails)) {
				System.out.println("if block executing(validate token)");
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); 
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); 
				SecurityContextHolder.getContext().setAuthentication(authToken); 
			}
			System.out.println("token not validated");
		} 
		filterChain.doFilter(request, response); 
	} 
	
	
	public String msg() {
		return "token expired!Please Genearte token again.";
	}
} 

