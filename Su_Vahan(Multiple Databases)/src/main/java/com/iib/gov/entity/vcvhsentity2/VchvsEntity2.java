package com.iib.gov.entity.vcvhsentity2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IIW_MOT_PUBLIC_SEARCH_2021")
public class VchvsEntity2 {
	@Id
	
	private Integer insurer_id; 
	
	
	private String policyno;
	
	
	private String regno;
	
	private String chassisno;
	
	private String enginno;
	
	public VchvsEntity2() {
		super();
		
	}
	
	
	@Override
	public String toString() {
		return "VchvsEntity [insurer_id=" + insurer_id + ", policyno=" + policyno + ", regno=" + regno + ", chassisno="
				+ chassisno + ", enginno=" + enginno + "]";
	}


	public Integer getInsurer_id() {
		return insurer_id;
	}
	public void setInsurer_id(Integer insurer_id) {
		this.insurer_id = insurer_id;
	}
	public String getPolicyno() {
		return policyno;
	}
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getChassisno() {
		return chassisno;
	}
	public void setChassisno(String chassisno) {
		this.chassisno = chassisno;
	}
	public String getEnginno() {
		return enginno;
	}
	public void setEnginno(String enginno) {
		this.enginno = enginno;
	}
	
	
	

}
