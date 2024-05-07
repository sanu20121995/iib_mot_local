package com.iib.gov.model;

public class JwtResponse {
	
	private String token;
	private Long expires_in;
	private Long contested_on;
	



	public Long getExpires_in() {
		return expires_in;
	}


	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}


	public Long getContested_on() {
		return contested_on;
	}


	public void setContested_on(Long contested_on) {
		this.contested_on = contested_on;
	}


	public JwtResponse(String token, Long expires_in, Long contested_on) {
		super();
		this.token = token;
		this.expires_in = expires_in;
		this.contested_on = contested_on;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public JwtResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
