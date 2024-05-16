package com.iib.gov.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iib.gov.model.VahanVehicleDetails;
import com.iib.gov.repo.Hit_Counts_Repo;
import com.iib.gov.repo.VahanVehicleDetailsRepo;

@Service
public class VahanVehicleDetailsImpl implements VahanVehicleDetailsServiceI {

	@Autowired
	private VahanVehicleDetailsRepo repo;
	@Autowired
	private Hit_Counts_Repo countrepo;

	// get logger
	static Logger log = Logger.getLogger(VahanVehicleDetailsImpl.class);

	@Override
	public VahanVehicleDetails getDetailsByregno(String regNo) {

		VahanVehicleDetails detailsByregno = repo.getDetailsByregno(regNo);

		return detailsByregno;
	}

	
	//For DL regno vehicles
	
	@Override
	public VahanVehicleDetails getDetailsBySpecificregno(String regno1, String regno2) {

		System.err.println("Fetch Vehicle details By specific regnos");

		VahanVehicleDetails detailsByregno = repo.getDetailsBySpecificregno(regno1, regno2);

		return detailsByregno;
	}

	@Override
	public VahanVehicleDetails getDetailsBychassisno(String chassisno) {

		VahanVehicleDetails detailsBychassisno = repo.getDetailsBychassisno(chassisno);

		return detailsBychassisno;
	}

	@Override
	public Integer getCount(String username) {
		// get counts based on username
		System.err.println("get counts based on username");

		Integer count = countrepo.getCount(username);

		log.info("Hit count is:" + count);
		System.out.print(count);

		return count;
	}

}
