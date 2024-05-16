package com.iib.gov.service;

import java.util.List;

import com.iib.gov.model.VahanVehicleDetails;

public interface VahanVehicleDetailsServiceI {

public  VahanVehicleDetails	getDetailsByregno(String regNo);

public VahanVehicleDetails getDetailsBySpecificregno(String regno1, String regno2);

public VahanVehicleDetails getDetailsBychassisno(String chassisno);


public Integer getCount(String username);

}
