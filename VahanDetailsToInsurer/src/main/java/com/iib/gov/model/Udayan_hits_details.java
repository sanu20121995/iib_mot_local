package com.iib.gov.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="Sudarshana_Hits")
@Table(name="udayan_hits")
public class Udayan_hits_details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	
	public int id;
	
	public String usernamne;
	
	public String getUsernamne() {
		return usernamne;
	}


	public void setUsernamne(String usernamne) {
		this.usernamne = usernamne;
	}


	public String regno;
	
	public String hit_time;
	
	public String ip_address;
	
	public String chassisno;
	
	public String response_msg;
	
	
	public String getResponse_msg() {
		return response_msg;
	}


	public void setResponse_msg(String response_msg) {
		this.response_msg = response_msg;
	}


	


	@Override
	public String toString() {
		return "Vchvs_hits_details [id=" + id + ", regno=" + regno + ", hit_time=" + hit_time + ", ip_address="
				+ ip_address + ", chassisno=" + chassisno + ", response_msg=" + response_msg + "]";
	}


	public String getRegno() {
		return regno;
	}


	public void setRegno(String regno) {
		this.regno = regno;
	}


	public String getHit_time() {
		return hit_time;
	}


	public void setHit_time(String hit_time) {
		this.hit_time = hit_time;
	}


	public String getIp_address() {
		return ip_address;
	}


	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}


	public String getChassisno() {
		return chassisno;
	}


	public void setChassisno(String chassisno) {
		this.chassisno = chassisno;
	}


	public Udayan_hits_details() {
		
	}

}
