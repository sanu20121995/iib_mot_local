package com.iib.main.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PolicyRequestpojo {
	
	@JsonProperty("Insurer_code")
	private String insurercode;

	@JsonProperty("Control_amount")
	private String controlamount;
	
//	@JsonProperty("Month")
//	private int month;
//	
//	@JsonProperty("Year")
//	private String year;
	
	@JsonProperty("Fromdate")
	private String fromdate;
	
	@JsonProperty("Todate")
	private String todate;
	
	@JsonProperty("Total_Count")
	private int controlnumber;
	
	@JsonProperty("Policy_Details")
	private List<Policydetails> details;
	
	

	public String getInsurercode() {
		return insurercode;
	}

	public void setInsurercode(String insurercode) {
		this.insurercode = insurercode;
	}

	public String getControlamount() {
		return controlamount;
	}

	public void setControlamount(String controlamount) {
		this.controlamount = controlamount;
	}

//	public int getMonth() {
//		return month;
//	}
//
//	public void setMonth(int month) {
//		this.month = month;
//	}
//
//	public String getYear() {
//		return year;
//	}
//
//	public void setYear(String year) {
//		this.year = year;
//	}
	
	

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public int getControlnumber() {
		return controlnumber;
	}

	public void setControlnumber(int controlnumber) {
		this.controlnumber = controlnumber;
	}

	public List<Policydetails> getDetails() {
		return details;
	}

	public void setDetails(List<Policydetails> details) {
		this.details = details;
	}
	

	

}
