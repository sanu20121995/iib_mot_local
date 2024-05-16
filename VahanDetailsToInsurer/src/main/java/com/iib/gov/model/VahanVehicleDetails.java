package com.iib.gov.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.cache.annotation.Cacheable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;



@Entity
@Table(name="NIC_VAHAN_DATA_latest")

//@JsonPropertyOrder (value = {"Owner_Serial_No","Hypothecation_Name","Registration_Number","Date_of_Registration","Chassis_Number"
//		,"Year_of_Manufacture","Engine_Number","Tax_From","Tax_Up_to","Manufacturer_of_the_Vehicle","Fitness_Up_to_Validity","Model_Variant_of_the_Vehicle"
//		,"PUC_Up_to_Validity","RTO_Office_Name","Cubic_Capacity","Permit_Type","Gross_Vehicle_Weight","Permit_validity","Registration_Permit_category"
//		,"Seating_Capacity","HP_KW_For_Electric_vehicles","Fuel_Type","Body_type_Open_Closed_SUV_Sedan_etc"})

public class VahanVehicleDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	private int id;
	public int getId() {
		return id;
	}
	@JsonIgnore
	public void setId(int id) {
		this.id = id;
	}
	@JsonProperty("Owner_Serial_No")
	@Column(name = "Owner_Serial_No")
	private String ownerserialno;
	@JsonProperty("Hypothecation_Name")
	@Column(name = "Hypothecation_Name")
	private String hypothecationname;
	
	@JsonProperty("Registration_Number")
	@Column(name = "Registration_Number")
	private String regno;
	@JsonProperty("Date_of_Registration")
	@Column(name = "Date_of_Registration")
	private String dateofreg;
	@JsonProperty("Chassis_Number")
	@Column(name = "Chassis_Number")
	private String chassisno;
	@JsonProperty("Year_of_Manufacture")
	@Column(name = "Year_of_Manufacture")
	private String yof;
	@JsonProperty("Engine_Number")
	@Column(name = "Engine_Number")
	private String	enginenum;
	@JsonProperty("Tax_From")
	@Column(name = "Tax_From")
	private String taxfrom;
	@JsonProperty("Tax_Up_to")
	@Column(name = "Tax_Up_to")
	private String taxupto;
	@JsonProperty("Manufacturer_of_the_Vehicle")
	@Column(name = "Manufacturer_of_the_Vehicle")
	private String mov;
	
	@JsonProperty("Model_Variant_of_the_Vehicle")
	@Column(name = "Model_Variant_of_the_Vehicle")
	private String modelvariant;
	
	@JsonProperty("Fitness_Up_to_Validity")
	@Column(name = "Fitness_Up_to_Validity")
	private String fitnessupto;
	
	@JsonProperty("PUC_Up_to_Validity")
	@Column(name = "PUC_Up_to_Validity")
	private String pucupto;
	@JsonProperty("Class_of_the_Vehicle")
	@Column(name = "Class_of_the_Vehicle")
	private String classvehicle;
	@JsonProperty("State_Name")
	@Column(name = "State_Name")
	private String state;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@JsonProperty("RTO_Office_Name")
	@Column(name = "RTO_Office_Name")
	private String rtoname;
	@JsonProperty("Cubic_Capacity")
	@Column(name = "Cubic_Capacity")
	private String cubiccapacity;
	@JsonProperty("Permit_Type")
	@Column(name = "Permit_Type")
	private String permittype;
	@JsonProperty("Gross_Vehicle_Weight")
	@Column(name = "Gross_Vehicle_Weight")
	private String grossvehicleweight;
	@JsonProperty("Permit_validity")
	@Column(name = "Permit_validity")
	private String permitvalidity;
	@JsonProperty("Registration_Permit_category")
	@Column(name = "Registration_Permit_category")
	private String permitcatg;
	@JsonProperty("Seating_Capacity")
	@Column(name = "Seating_Capacity")
	private String seatingcap;
	@JsonProperty("HP_KW_For_Electric_vehicles")
	@Column(name = "HP_KW_For_Electric_vehicles")
	private String hpforelectric;
	@JsonProperty("Fuel_Type")
	@Column(name = "Fuel_Type")
	private String fueltype;
	
	@JsonProperty("Body_type_Open_Closed_SUV_Sedan_etc")
	@Column(name = "Body_type_Open_Closed_SUV_Sedan_etc")
	private String bodytype;
	

	
	
	public String getIibmanufacturercode() {
		return iibmanufacturercode;
	}
	public void setIibmanufacturercode(String iibmanufacturercode) {
		this.iibmanufacturercode = iibmanufacturercode;
	}
	public String getIibmanufactureofvehicle() {
		return iibmanufactureofvehicle;
	}
	public void setIibmanufactureofvehicle(String iibmanufactureofvehicle) {
		this.iibmanufactureofvehicle = iibmanufactureofvehicle;
	}
	public String getIibmodelcode() {
		return iibmodelcode;
	}
	public void setIibmodelcode(String iibmodelcode) {
		this.iibmodelcode = iibmodelcode;
	}
	
	@JsonProperty("IIB_Manufacturer")
	@Column(name = "IIB_Manufacturer")
	private String iibmanufactureofvehicle;
	
	

	@JsonProperty("IIB_Model")
	@Column(name = "IIB_Model")
	private String iibmodelofvehicle;
	
	

	@JsonProperty("IIB_Variant")
	@Column(name = "IIB_Variant")
	private String iibmanufacturercode;
	
	
	@JsonProperty("GIC_IBB_Code")
	@Column(name = "GIC_IBB_Code")
	private String iibmodelcode;
	

	public String getIibmodelofvehicle() {
		return iibmodelofvehicle;
	}
	public void setIibmodelofvehicle(String iibmodelofvehicle) {
		this.iibmodelofvehicle = iibmodelofvehicle;
	}
	@Override
	public String toString() {
		return "VahanVehicleDetails [id=" + id + ", ownerserialno=" + ownerserialno + ", hypothecationname="
				+ hypothecationname + ", regno=" + regno + ", dateofreg=" + dateofreg + ", chassisno=" + chassisno
				+ ", yof=" + yof + ", enginenum=" + enginenum + ", taxfrom=" + taxfrom + ", taxupto=" + taxupto
				+ ", mov=" + mov + ", modelvariant=" + modelvariant + ", fitnessupto=" + fitnessupto + ", pucupto="
				+ pucupto + ", classvehicle=" + classvehicle + ", state=" + state + ", rtoname=" + rtoname
				+ ", cubiccapacity=" + cubiccapacity + ", permittype=" + permittype + ", grossvehicleweight="
				+ grossvehicleweight + ", permitvalidity=" + permitvalidity + ", permitcatg=" + permitcatg
				+ ", seatingcap=" + seatingcap + ", hpforelectric=" + hpforelectric + ", fueltype=" + fueltype
				+ ", bodytype=" + bodytype + ", iibmanufacturercode=" + iibmanufacturercode
				+ ", iibmanufactureofvehicle=" + iibmanufactureofvehicle + ", iibmodelcode=" + iibmodelcode
				+ ", iibmodelvariantofvehicle=" + iibmodelofvehicle + "]";
	}
	
	
	public VahanVehicleDetails() {
		
		System.out.println("vahan 0-param constructor");
	
	}
	public String getOwnerserialno() {
		return ownerserialno;
	}
	public void setOwnerserialno(String ownerserialno) {
		this.ownerserialno = ownerserialno;
	}
	public String getHypothecationname() {
		return hypothecationname;
	}
	public void setHypothecationname(String hypothecationname) {
		this.hypothecationname = hypothecationname;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getDateofreg() {
		return dateofreg;
	}
	public void setDateofreg(String dateofreg) {
		this.dateofreg = dateofreg;
	}
	public String getChassisno() {
		return chassisno;
	}
	public void setChassisno(String chassisno) {
		this.chassisno = chassisno;
	}
	public String getYof() {
		return yof;
	}
	public void setYof(String yof) {
		this.yof = yof;
	}
	public String getEnginenum() {
		return enginenum;
	}
	public void setEnginenum(String enginenum) {
		this.enginenum = enginenum;
	}
	public String getTaxfrom() {
		return taxfrom;
	}
	public void setTaxfrom(String taxfrom) {
		this.taxfrom = taxfrom;
	}
	public String getTaxupto() {
		return taxupto;
	}
	public void setTaxupto(String taxupto) {
		this.taxupto = taxupto;
	}
	public String getMov() {
		return mov;
	}
	public void setMov(String mov) {
		this.mov = mov;
	}
	public String getFitnessupto() {
		return fitnessupto;
	}
	public void setFitnessupto(String fitnessupto) {
		this.fitnessupto = fitnessupto;
	}
	public String getModelvariant() {
		return modelvariant;
	}
	public void setModelvariant(String modelvariant) {
		this.modelvariant = modelvariant;
	}
	public String getPucupto() {
		return pucupto;
	}
	public void setPucupto(String pucupto) {
		this.pucupto = pucupto;
	}
	public String getClassvehicle() {
		return classvehicle;
	}
	public void setClassvehicle(String classvehicle) {
		this.classvehicle = classvehicle;
	}
	public String getRtoname() {
		return rtoname;
	}
	public void setRtoname(String rtoname) {
		this.rtoname = rtoname;
	}
	public String getCubiccapacity() {
		return cubiccapacity;
	}
	public void setCubiccapacity(String cubiccapacity) {
		this.cubiccapacity = cubiccapacity;
	}
	public String getPermittype() {
		return permittype;
	}
	public void setPermittype(String permittype) {
		this.permittype = permittype;
	}
	public String getGrossvehicleweight() {
		return grossvehicleweight;
	}
	public void setGrossvehicleweight(String grossvehicleweight) {
		this.grossvehicleweight = grossvehicleweight;
	}
	public String getPermitvalidity() {
		return permitvalidity;
	}
	public void setPermitvalidity(String permitvalidity) {
		this.permitvalidity = permitvalidity;
	}
	public String getPermitcatg() {
		return permitcatg;
	}
	public void setPermitcatg(String permitcatg) {
		this.permitcatg = permitcatg;
	}
	public String getSeatingcap() {
		return seatingcap;
	}
	public void setSeatingcap(String seatingcap) {
		this.seatingcap = seatingcap;
	}
	public String getHpforelectric() {
		return hpforelectric;
	}
	public void setHpforelectric(String hpforelectric) {
		this.hpforelectric = hpforelectric;
	}
	public String getFueltype() {
		return fueltype;
	}
	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
	public String getBodytype() {
		return bodytype;
	}
	public void setBodytype(String bodytype) {
		this.bodytype = bodytype;
	}
	
	


}
