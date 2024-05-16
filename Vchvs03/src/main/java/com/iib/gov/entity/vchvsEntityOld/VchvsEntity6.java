package com.iib.gov.entity.vchvsEntityOld;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@JsonPropertyOrder(value = {"RISK_SCORE","RISK_BAND"})
//@JsonIgnoreProperties({"REGISTRATION_NUMBER"})
@Table(name="RISK_SCORE_VCHVS_SUDARSHANA")
public class VchvsEntity6 {
	@Id
	//@JsonProperty("REGISTRATION_NUMBER")
	@Column(name = "Registration_Number")
	private String regno;
	
	@JsonProperty("RISK_SCORE")
	@Column(name = "Score")
	private String score;
	
	@JsonProperty("RISK_BAND")
	@Column(name="Slabs")
	private String slab;
	
	@Column(name="Chasis_number")
	private String chassisno;
	
	
	
	public String getChassisno() {
		return chassisno;
	}
	@JsonIgnore
	public void setChassisno(String chassisno) {
		this.chassisno = chassisno;
	}
	@Override
	public String toString() {
		return "VchvsEntity6 [regno=" + regno + ", score=" + score + ", slab=" + slab + "]";
	}
	public VchvsEntity6() {
		
		System.out.println("Risk score 0-param constructor");
		
	}
	public String getRegno() {
		return regno;
	}
	
	@JsonIgnore
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getScore() {
		return score;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	public String getSlab() {
		return slab;
	}
	public void setSlab(String slab) {
		this.slab = slab;
	}
	


}
