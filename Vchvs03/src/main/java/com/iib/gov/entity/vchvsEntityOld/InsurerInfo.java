package com.iib.gov.entity.vchvsEntityOld;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
 

@Entity
public class InsurerInfo{ 




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id; 
	

	private String insurercode; 

	private String username; 
	private String password; 
	private String roles;
	
	@Override
	public String toString() {
		return "InsurerInfo [insurercode=" + insurercode + ", username=" + username + ", password=" + password
				+ ", roles=" + roles + "]";
	}
	public String getInsurercode() {
		return insurercode;
	}
	public void setInsurercode(String insurercode) {
		this.insurercode = insurercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	

} 

