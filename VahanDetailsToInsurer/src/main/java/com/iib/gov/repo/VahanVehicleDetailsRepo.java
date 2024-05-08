package com.iib.gov.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iib.gov.model.VahanVehicleDetails;

public interface VahanVehicleDetailsRepo  extends JpaRepository<VahanVehicleDetails, Integer>{

	
	@Query(value="select ID,Owner_Serial_No,Hypothecation_Name,Registration_Number,Date_of_Registration,Chassis_Number,Year_of_Manufacture"
			+ ",Engine_Number,Tax_From,Tax_Up_to,Manufacturer_of_the_Vehicle,"
			+ "Fitness_Up_to_Validity,Model_Variant_of_the_Vehicle,PUC_Up_to_Validity,Class_of_the_Vehicle,State_Name,"
		    + "RTO_Office_Name,Cubic_Capacity,Permit_Type,Gross_Vehicle_Weight,Permit_validity,Registration_Permit_category,Seating_Capacity"
			+ ",HP_KW_For_Electric_vehicles,Fuel_Type,Body_type_Open_Closed_SUV_Sedan_etc,IIB_Variant,IIB_Manufacturer"
			+ "	,GIC_IBB_Code,IIB_Model"
			+ " from NIC_VAHAN_DATA_latest with(nolock) where Registration_Number=:regNo",nativeQuery=true)
	
//	@Query(value = "select * from TEST_NIC_VAHAN_DATA_20230209 where Registration_Number=:regNo",nativeQuery = true)
//	@Query("FROM VahanVehicleDetails WHERE Registration_Number = :regNo")
	public VahanVehicleDetails getDetailsByregno(String regNo);
	
	
	@Query(value="select ID,Owner_Serial_No,Hypothecation_Name,Registration_Number,Date_of_Registration,Chassis_Number,Year_of_Manufacture"
			+ ",Engine_Number,Tax_From,Tax_Up_to,Manufacturer_of_the_Vehicle,"
			+ "Fitness_Up_to_Validity,Model_Variant_of_the_Vehicle,PUC_Up_to_Validity,Class_of_the_Vehicle,State_Name,"
			+ "RTO_Office_Name,Cubic_Capacity,Permit_Type,Gross_Vehicle_Weight,Permit_validity,Registration_Permit_category,Seating_Capacity"
			+ ",HP_KW_For_Electric_vehicles,Fuel_Type,Body_type_Open_Closed_SUV_Sedan_etc,IIB_Variant,IIB_Manufacturer"
			+ ",GIC_IBB_Code,IIB_Model"
			+ " from NIC_VAHAN_DATA_latest with(nolock) where Chassis_Number=:chassisno",nativeQuery=true)
	
	
	public  VahanVehicleDetails getDetailsBychassisno(String chassisno);
	
	

}
