package com.iib.gov.entity.vchvsEntityOld;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonPropertyOrder({ "TXT_INSURER", "POLICY_NUMBER", "TYPE_OF_POLICY", "CLASS_OF_VEHICLE", "POLICY_START_DATE",
		"POLICY_END_DATE", "TYPE_OF_TRANSACTION", "FINANACIAL_YEAR" })
@Entity
//@Immutable
@Table(name = "iiw_mot_policy_history_uat")
//@JsonRootName
//@JsonTypeName("PolicyDetails")
//@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class VchvsEntity implements Serializable {
	@Id
	@Column(name = "ID")
	private String id;
	@JsonProperty("POLICY_NUMBER")
	@Column(name = "TXT_POLICY_NUMBER")
	private String policyno;
	@JsonProperty("CLASS_OF_VEHICLE")
	@Column(name = "CLASS_CODE")
	private String classcode;
	@JsonProperty("POLICY_START_DATE")
	@Column(name = "POLICY_START_DATE")
	// @JsonFormat(pattern="yyyy-MM-dd")
	private String policystartdate;
	@JsonProperty("POLICY_END_DATE")
	@Column(name = "POLICY_END_DATE")
	// @JsonFormat(pattern="yyyy-MM-dd")
	private String policyenddate;
	@JsonProperty("TYPE_OF_POLICY")
	@Column(name = "TYPE_OF_POLICY")
	private String typeofpolicy;
	@JsonProperty("TXT_INSURER")
	@Column(name = "TXT_INSURER")
	private String txt_insurer;
	@JsonProperty("TYPE_OF_TRANSACTION")
	@Column(name = "TYPE_OF_TRANSACTION")
	private String typeoftransaction;

	@JsonProperty("FINANACIAL_YEAR")
	@Column(name = "INSERTED_DATE")
	private String insertdate;

	@JsonProperty("NCB%")
	@Column(name = "NCB_PER")
	private String ncbper;
	@JsonProperty("NIL_DEP_FLAG")
	@Column(name = "NIL_DEP_FLAG")
	private String nildepflag;
	@JsonProperty("IDV")
	@Column(name = "IDV")
	private String idv;

	public String getNcbper() {
		return ncbper;
	}

	public void setNcbper(String ncbper) {
		this.ncbper = ncbper;
	}

	public String getNildepflag() {
		return nildepflag;
	}

	public void setNildepflag(String nildepflag) {
		this.nildepflag = nildepflag;
	}

	public String getIdv() {
		return idv;
	}

	public void setIdv(String idv) {
		this.idv = idv;
	}

	public String getTypeoftransaction() {
		return typeoftransaction;
	}

	public void setTypeoftransaction(String typeoftransaction) {
		this.typeoftransaction = typeoftransaction;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

	@Override
	public String toString() {

		

		return "VchvsEntity [id=" + id + ", policyno=" + policyno + ", classcode=" + classcode + ", policystartdate="
				+ policystartdate + ", policyenddate=" + policyenddate + ", typeofpolicy=" + typeofpolicy
				+ ", txt_insurer=" + txt_insurer + ", typeoftransaction=" + typeoftransaction + ", insertdate="
				+ insertdate + "]";
	}

	public String getTxt_insurer() {
		return txt_insurer;
	}

	public void setTxt_insurer(String txt_insurer) {
		this.txt_insurer = txt_insurer;
	}

	public String getId() {
		return id;
	}

	@JsonIgnore
	public void setId(String id) {
		this.id = id;
	}

	public String getPolicyno() {
		return policyno;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}

	public String getClasscode() {
		return classcode;
	}

	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}

	public String getPolicystartdate() {
		return policystartdate;
	}

	public void setPolicystartdate(String policystartdate) {
		this.policystartdate = policystartdate;
	}

	public String getPolicyenddate() {
		return policyenddate;
	}

	public void setPolicyenddate(String policyenddate) {
		this.policyenddate = policyenddate;
	}

	public String getTypeofpolicy() {
		return typeofpolicy;
	}

	public void setTypeofpolicy(String typeofpolicy) {
		this.typeofpolicy = typeofpolicy;
	}

	public VchvsEntity() {
		
	}

}
