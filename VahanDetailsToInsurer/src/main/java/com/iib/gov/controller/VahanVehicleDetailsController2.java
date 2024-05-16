package com.iib.gov.controller;

import java.time.LocalDateTime;
import java.util.Date;

import java.util.List;

import javax.persistence.NonUniqueResultException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.naming.java.javaURLContextFactory;
import org.hibernate.NonUniqueObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iib.gov.exception.CustomException;
import com.iib.gov.model.Udayan_hits_details;
import com.iib.gov.model.VahanVehicleDetails;
import com.iib.gov.repo.Udayan_hit_repo;

import com.iib.gov.service.VahanVehicleDetailsServiceI;

@RestController
@RequestMapping("/accessToIIB")
public class VahanVehicleDetailsController2 {

	static Logger log = Logger.getLogger(VahanVehicleDetailsController2.class);

	@Autowired
	private VahanVehicleDetailsServiceI service;

	int count = 0;

	@Autowired
	private Udayan_hit_repo repo;

	@GetMapping("/getVehicleDetails")
	public VahanVehicleDetails getVehicleDetailsVahan(@RequestParam(name = "Regno") String regno,
			@RequestParam(name = "Chassisno") String chassisno, HttpServletRequest request) {

		// specific time validation
//		Date datehrDate=new Date();
//		
//		int hours = datehrDate.getHours();
//		
//		System.err.println("current hour:"+hours);
//		
//		System.err.println(hours<15);

//		if(hours<11 || hours>15) {
//			throw new CustomException("APi is only available from 11am to 4pm.Please access during the given time.");
//		}

		String remoteAddr = request.getRemoteAddr();

		log.info("Request sent by ip:" + remoteAddr);

		// to get the username

		String name = SecurityContextHolder.getContext().getAuthentication().getName();

		// get count for specific user

//		if(name.equals("124567") && service.getCount(name)>50000) {
//			
//			
//			throw new CustomException("You have exceeded the limit(50k).");
//			
//		}

		log.info("entering udayan controller" + "\nregno:" + regno + "----chassisno:" + chassisno + "\nusername:"
				+ name);

		// for storing logs
		Udayan_hits_details hits_details = new Udayan_hits_details();

		hits_details.setChassisno(chassisno);
		hits_details.setHit_time(LocalDateTime.now().toString());
		hits_details.setIp_address(remoteAddr);
		hits_details.setUsernamne(name);
		hits_details.setRegno(regno);

		// for regno and chassisno validation
		if (regno.equals("") && chassisno.equals("")) {

			log.warn("You have to pass either registration number or chassis number.");

			throw new CustomException("You have to pass either registration number or chassis number.");
		}

		// for registration number vehicle

		if ((regno.startsWith("DL") || regno.startsWith("dl") || regno.startsWith("BR") || regno.startsWith("GJ"))
				&& !(regno.substring(2, 3).equals("0")) && (!regno.substring(2, 4).matches("(^\\d{2})"))) {

			// && !regno.substring(2,4).matches("(^\\d{2})")

			System.out.println("Entering block DL regno validation1");

			System.err.println(regno.substring(0, 2));
			log.info("Entering block DL regno validation1 ");

			log.info("DLregno val1:" + regno);

			String concatreg1 = regno.substring(0, 2) + 0 + regno.substring(2);

			System.err.println("after validation regno:" + concatreg1);

			// calling service for Vehicle Details

			VahanVehicleDetails detailsBySpecificregno = service.getDetailsBySpecificregno(concatreg1, regno);

			if (detailsBySpecificregno == null) {

				log.warn("No details available in the given regno");
				hits_details.setResponse_msg("No details available in the given regno");
				repo.save(hits_details);
				throw new CustomException("No details available in the given regno");

			}
			System.out.println("returning response");
			hits_details.setResponse_msg("details available in the given regno");

			repo.save(hits_details);

			return detailsBySpecificregno;

		}

		// Dl validation 2 regnumber
		else if (regno.startsWith("DL") || regno.startsWith("dl")
				|| (regno.startsWith("BR") || regno.startsWith("GJ")) && regno.substring(2, 3).equals("0")) {

			System.out.println("Entering block DL regno validation2");

			log.info("Entering block DL regno validation2 ");

			log.info("DLregno val2:" + regno);

			String concatreg2 = regno.substring(0, 2) + regno.substring(3);

			// Calling service method for Vehicle details

			VahanVehicleDetails detailsBySpecificregno = service.getDetailsBySpecificregno(concatreg2, regno);
			
			
			if (detailsBySpecificregno == null) {

				log.warn("No details available in the given regno");
				hits_details.setResponse_msg("No details available in the given regno");
				repo.save(hits_details);
				throw new CustomException("No details available in the given regno");

			}
			System.out.println("returning response");
			hits_details.setResponse_msg("details available in the given regno");

			repo.save(hits_details);

			return detailsBySpecificregno;
			
			

		}

		else if (!regno.equals("") && chassisno.equals("")) {

			log.info("calling service method(registartion number)");
			try {
				VahanVehicleDetails detailsByregno = service.getDetailsByregno(regno);

				System.err.println(detailsByregno);

				if (detailsByregno == null) {

					log.warn("No details available in the given regno");
					hits_details.setResponse_msg("No details available in the given regno");
					repo.save(hits_details);
					throw new CustomException("No details available in the given regno");

				}
				System.out.println("returning response");
				hits_details.setResponse_msg("details available in the given regno");

				repo.save(hits_details);

				return detailsByregno;
			} catch (IncorrectResultSizeDataAccessException e) {
				throw new CustomException("Multiple records found in the given regno");
			}

		}

		else if (!chassisno.equals("") && regno.equals("")) {

			log.info("calling service method(chassis number)");
			try {

				VahanVehicleDetails detailsBychassisno = service.getDetailsBychassisno(chassisno);

				System.err.println(detailsBychassisno);

				if (detailsBychassisno == null) {

					log.warn("No details available in the given chassino");

					hits_details.setResponse_msg(" No details available in the given chassisno");
					repo.save(hits_details);
					throw new CustomException("No details available in the given chassisno");

				}
				hits_details.setResponse_msg("Details available in the given chassisno");
				repo.save(hits_details);

//	String encrypt = encryptservice.encrypt(detailsBychassisno.toString(), "sanujava");

				return detailsBychassisno;

			} // try

			catch (IncorrectResultSizeDataAccessException e) {
				throw new CustomException("Multiple records found in the given chassisno");
			}

		}

		else {

			throw new CustomException("Something went wrong.Please try later");
		}

	}
}
