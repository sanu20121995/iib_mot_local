package com.iib.gov.config;

import java.io.IOException;

import javax.naming.NoPermissionException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.iib.gov.model.ApiError;
import com.iib.gov.service.CustomUserDetailService;

import io.jsonwebtoken.ExpiredJwtException;



@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	
	@Autowired
	private CustomUserDetailService userdetailService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	//@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		System.out.println("Requset 1st coming here");
		
		final String requestTokenHeader = request.getHeader("Authorization");

		String username = null;
		String jwtToken = null;
		// JWT Token is in the form "Bearer token". Remove Bearer word and get
		// only the Token
		System.err.println(requestTokenHeader);
		
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			
			
			
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
				System.err.println("username2:" +username);
				
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} 
			
			catch (ExpiredJwtException e) {
				e.printStackTrace();
				
				response.sendError(403, "Token expired");
				return;
			//	System.out.println("JWT Token has expired");
				
			//	throw new RuntimeException("Token expired");
			}
			
			
		} 
		
		
		
		else {
			
			
			logger.warn("JWT Token does not begin with Bearer String");
			
			//throw new RuntimeException();
			
		}

		// Once we get the token validate it.
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			System.err.println(username);
			
			System.err.println("Token validating.");
			
			UserDetails userDetails = this.userdetailService.loadUserByUsername(username);

			// if token is valid configure Spring Security to manually set
			// authentication
			if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the
				// Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		
		
		
		chain.doFilter(request, response);
	}
	
	   public void setErrorResponse(HttpStatus status, HttpServletResponse response, Throwable ex){
	        response.setStatus(status.value());
	        response.setContentType("application/json");
	        // A class used for errors
	        ApiError apiError = new ApiError(status, ex);
	        try {
	            String json = apiError.convertToJson();
	            System.out.println(json);
	            response.getWriter().write(json);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	

}
