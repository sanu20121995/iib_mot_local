package com.iib.gov.entity.vchvsEntityOld;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

@Entity
//@Immutable
@Table(name="IIW_MOT_CLAIM_HISTORY_UAT")
public class VchvsEntity4  {

	//@Id
	@Column(name = "REG_NUMBER_VEHICLE")
	private String  regno;
	@Column(name = "CHASSIS_NUMBER")
	private String chassisno;
	@Column(name = "ENGINE_NUMBER")
	private String enginenum;
	@Column(name = "INSURER_NAME")
	private String insurername;
	@Column(name = "CLAIM_TYPE")
	private String claimtype;
	@Id
	@Column(name = "CLAIM_NUMBER")
	private String claimnumber;
	@Column(name = "ACCIDENT_LOSS_DATE")
	private String lossdate;
	@Column(name = "CLAIM_INTIMATION_DATE")
	private String intimationdate;
	@Column(name = "CLASS_CODE")
	private String  classcode;
	public String getClasscode() {
		return classcode;
	}
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}
	@Column(name = "NUM_OD_LOSS_PAID")
	private Integer odlosspaid;
	@Column(name = "NUM_OD_EXPENSES_PAID")
	private Integer odexpensespaid;
	@Column(name = "BOO_OD_TOTAL_LOSS")
	private String booOdTotalLoss;
	@Column(name = "BOO_THEFT")
	private String booTheft;
	@Column(name = "TOTAL_TP_CLAIMS_PAID_AMOUNT")
	private Integer totalTpClaimsPaidAmount;
	@Column(name = "TP_OPEN_PROVISION")
	private Integer tpOpenProvision;
	@Column(name = "TP_CLOSE_PROVISION")
	private Integer tpCloseProvision;
	@Column(name = "CLAIM_STATUS")
	private String claimStatus;
	@Transient
	@Column(name = "SEARCH_BASED_ON")
	private String Search_Based_On;
	
	public VchvsEntity4() {
		System.out.println("claim 0-param constructor");
	}
	@Override
	public String toString() {
		return "VchvsEntity4 [regno=" + regno + ", chassisno=" + chassisno + ", enginenum=" + enginenum
				+ ", insurername=" + insurername + ", claimtype=" + claimtype + ", claimnumber=" + claimnumber
				+ ", lossdate=" + lossdate + ", intimationdate=" + intimationdate + ", classcode=" + classcode
				+ ", odlosspaid=" + odlosspaid + ", odexpensespaid=" + odexpensespaid + ", booOdTotalLoss="
				+ booOdTotalLoss + ", booTheft=" + booTheft + ", totalTpClaimsPaidAmount=" + totalTpClaimsPaidAmount
				+ ", tpOpenProvision=" + tpOpenProvision + ", tpCloseProvision=" + tpCloseProvision + ", claimStatus="
				+ claimStatus + ", Search_Based_On=" + Search_Based_On + "]";
	}
	public String getSearch_Based_On() {
		return Search_Based_On;
	}
	public void setSearch_Based_On(String search_Based_On) {
		Search_Based_On = search_Based_On;
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
	public String getEnginenum() {
		return enginenum;
	}
	public void setEnginenum(String enginenum) {
		this.enginenum = enginenum;
	}
	public String getInsurername() {
		return insurername;
	}
	public void setInsurername(String insurername) {
		this.insurername = insurername;
	}
	public String getClaimtype() {
		return claimtype;
	}
	public void setClaimtype(String claimtype) {
		this.claimtype = claimtype;
	}
	public String getClaimnumber() {
		return claimnumber;
	}
	public void setClaimnumber(String claimnumber) {
		this.claimnumber = claimnumber;
	}
	public String getLossdate() {
		return lossdate;
	}
	public void setLossdate(String lossdate) {
		this.lossdate = lossdate;
	}
	public String getIntimationdate() {
		return intimationdate;
	}
	public void setIntimationdate(String intimationdate) {
		this.intimationdate = intimationdate;
	}
	public Integer getOdlosspaid() {
		return odlosspaid;
	}
	public void setOdlosspaid(Integer odlosspaid) {
		this.odlosspaid = odlosspaid;
	}
	public Integer getOdexpensespaid() {
		return odexpensespaid;
	}
	public void setOdexpensespaid(Integer odexpensespaid) {
		this.odexpensespaid = odexpensespaid;
	}
	public String getBooOdTotalLoss() {
		return booOdTotalLoss;
	}
	public void setBooOdTotalLoss(String booOdTotalLoss) {
		this.booOdTotalLoss = booOdTotalLoss;
	}
	public String getBooTheft() {
		return booTheft;
	}
	public void setBooTheft(String booTheft) {
		this.booTheft = booTheft;
	}
	public Integer getTotalTpClaimsPaidAmount() {
		return totalTpClaimsPaidAmount;
	}
	public void setTotalTpClaimsPaidAmount(Integer totalTpClaimsPaidAmount) {
		this.totalTpClaimsPaidAmount = totalTpClaimsPaidAmount;
	}
	public Integer getTpOpenProvision() {
		return tpOpenProvision;
	}
	public void setTpOpenProvision(Integer tpOpenProvision) {
		this.tpOpenProvision = tpOpenProvision;
	}
	public Integer getTpCloseProvision() {
		return tpCloseProvision;
	}
	public void setTpCloseProvision(Integer tpCloseProvision) {
		this.tpCloseProvision = tpCloseProvision;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

		

}
