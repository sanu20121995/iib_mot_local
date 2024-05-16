package com.iib.gov.entity.vchvsEntityOld;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="Sudarshana_Hits")
@Table(name="sudarshana_testing")
public class Vchvs_hits_details {
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
	
	public String response_given;
	
	
	public String getResponse_given() {
		return response_given;
	}


	public void setResponse_given(String response_given) {
		this.response_given = response_given;
	}


	public String getResponse_msg() {
		return response_msg;
	}


	public void setResponse_msg(String response_msg) {
		this.response_msg = response_msg;
	}


	


	

	@Override
	public String toString() {
		return "Vchvs_hits_details [id=" + id + ", usernamne=" + usernamne + ", regno=" + regno + ", hit_time="
				+ hit_time + ", ip_address=" + ip_address + ", chassisno=" + chassisno + ", response_msg="
				+ response_msg + ", response_given=" + response_given + "]";
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


	public Vchvs_hits_details() {
		
	}

}
