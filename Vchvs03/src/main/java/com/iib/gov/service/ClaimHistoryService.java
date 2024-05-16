package com.iib.gov.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder({"REGISTRATION_NUMBER","CHASSIS_NUMBER","ENGINE_NUMBER","INSURER_NAME","CLAIM_TYPE"
	,"ACCIDENT_LOSS_DATE","CLAIM_INTIMATION_DATE","OD_CLAIMS_PAID","BOO_OD_TOTAL_LOSS","BOO_THEFT"
	,"TOTAL_TP_CLAIMS_PAID_AMOUNT","TP_OPEN_PROVISION","TP_CLOSE_PROVISION","CLAIM_STATUS","CLASS_CODE"})
public interface ClaimHistoryService {
	
	

	//public Integer getInsurer_Code();
	@JsonProperty("REGISTRATION_NUMBER")
	public String getReg_number_vehicle();
	@JsonProperty("CHASSIS_NUMBER")
	public String getChassis_number();
	@JsonProperty("ENGINE_NUMBER")
	public String getEngine_number();
	@JsonProperty("INSURER_NAME")
	public String getInsurer_name();
	@JsonProperty("ACCIDENT_LOSS_DATE")
	public String getAccident_Loss_date();
	@JsonProperty("CLAIM_INTIMATION_DATE")
	public String getClaim_Intimation_date();
	@JsonProperty("CLAIM_NUMBER")
	public String getClaim_number();
	@JsonProperty("BOO_OD_TOTAL_LOSS")
	public String getBOO_OD_TOTAL_LOSS();
	@JsonProperty("BOO_THEFT")
	public String getBOO_THEFT();
	@JsonProperty("TOTAL_TP_CLAIMS_PAID_AMOUNT")
	public Integer getTOTAL_TP_CLAIMS_PAID_AMOUNT();
	@JsonProperty("TP_OPEN_PROVISION")
	public Integer getTP_OPEN_PROVISION();
	@JsonProperty("TP_CLOSE_PROVISION")
	public Integer getTP_CLOSE_PROVISION();
	@JsonProperty("CLAIM_STATUS")
	public String getCLAIM_STATUS();
	@JsonProperty("CLASS_CODE")
	public String getCLASS_CODE();

	//public Integer getOdexpensespaid();

	//public String getTxt_Child_Claim_Num();
	@JsonProperty("CLAIM_TYPE")
	public String getClaim_Type();
	
//	public String getSearch_Based_On();
 //   public String setSearch_Based_On(String res);
	@JsonProperty("OD_CLAIMS_PAID")
	public Integer getOD_CLAIMS_PAID();

}