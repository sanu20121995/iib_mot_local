//package com.iib.gov.controller;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
////import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.iib.gov.entity.vchvsEntityOld.VchvsEntity;
//import com.iib.gov.entity.vchvsEntityOld.VchvsEntity6;
//import com.iib.gov.entity.vchvsEntityOld.Vchvs_hits_details;
//import com.iib.gov.exception.CustomException;
//import com.iib.gov.repo.old.Vchvs_hit_repo;
//import com.iib.gov.service.ClaimHistoryService;
//import com.iib.gov.service.RequestipService;
//import com.iib.gov.service.VchvsService;
//
//@RestController
//@RequestMapping("/access")
//public class VchvsController2 {
//
//	@Autowired
//	private VchvsService service;
//
//	@Autowired
//	private RequestipService requestService;
//	@Autowired
//	private Vchvs_hit_repo hit_repo;
//
//	private List<Object> dl3regnolist;
//	private List<Object> dl2regnolist;
//	private List<Object> dl1regnolist;
//	private List<Object> regnolist;
//	private List<Object> claimDeatils;
//	private List<Object> dl1claim;
//	private List<Object> dl2claim;
//	private List<Object> dl3claim;
//	private List<ClaimHistoryService> claimByRegno;
//	private List<Object> policyInfoByChassisnoNewTable;
//	private List<Object> chassisnolist;
//	private List<Object> claimByChassino;
//	private String rootName;
//	private String rootName1;
//	private String rootname3;
//	private String rootname4;
//	private List<VchvsEntity6> score;
//	private Vchvs_hits_details hitDetails;
//	private boolean b1;
//	private boolean b2;
//	private boolean b3;
//	private boolean b4;
//	private boolean b5;
//	private boolean b6;
//	private boolean b7;
//
//	private boolean b9;
//	private boolean b10;
//	private boolean b11;
//	private boolean b12;
//
//	private final ObjectMapper mapper = new ObjectMapper();
//
//	static Logger log = Logger.getLogger(VchvsController2.class);
//
//	//private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(VchvsController2.class);
//
//	// @SuppressWarnings("unchecked")
//	@GetMapping("/getVehicleDetails")
//	public String getVehicleDetails(@RequestParam String regno,
//			@RequestParam(required = false, defaultValue = "") String chassisno, HttpServletRequest request,
//			HttpServletResponse res) throws Exception {
//		
//		//getting ip address
//				String ipAddress = request.getRemoteAddr();
//				
//				log.info("client IP:"+ipAddress);
//				
//				//getting username
//				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//			
//				String name = authentication.getName();
//				
//				log.info("Username:"+name);
//				
//				Vchvs_hits_details hits_details=new Vchvs_hits_details();
//				hits_details.setHit_time(LocalDateTime.now().toString());
//				hits_details.setIp_address(ipAddress);
//				hits_details.setUsernamne(name);
//		
//		
//
//		if (chassisno.length() < 11 && chassisno.length() > 0) {
//
//			throw new CustomException("Chassino. should not be less than 11 digits");
//		}
//
//		if (regno.length() < 6 && regno.length() > 0) {
//
//			throw new CustomException("Regno. should not be less than 6 digits");
//		}
//
//		if (regno.equals("") && chassisno.equals("")) {
//
//			throw new CustomException("You have to pass either registration number or chassis number or both");
//			
//		}
//		
//////////////////////////////////////chassisno and registration number////////////////////////////////////////////////////////////////////////
//		
//		if (!regno.equals("") && !chassisno.equals("")) {
//			
//			hits_details.setChassisno(chassisno);
//			hits_details.setRegno(regno);
//			
//			log.info("entering to block where chassisno and regno both are there ");
//			
//			log.info("Regno:"+regno+"/////"+"Chassisno:"+chassisno);
//			
//			System.out.println("entering to block where chassisno and regno both are there ");
//			
//			System.out.println("getting policy details");
//		final List<VchvsEntity> info4 = service.getInfo4(regno, chassisno);
//			
//		  System.out.println("getting claim details");
//		final   List<ClaimHistoryService> claimInfo3 = service.getClaimInfo3(regno, chassisno);
//		
//		//policy
//		if (!info4.isEmpty()) {
//			
//			hits_details.setResponse_msg(info4.toString().substring(0, 10));
//
//			rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(info4));
//		} else {
//			
//			hits_details.setResponse_msg("policy not found");
//
//			rootName = (mapper.writer().withRootName("PolicyDetails")
//					.writeValueAsString(" policy data not found in given chassisno."));
//
//		}
//         //Claims
//		if (!claimInfo3.isEmpty()) {
//			
//			hits_details.setResponse_msg(claimInfo3.toString().substring(0, 10));
//
//			rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimInfo3));
//		} else {
//			
//			hits_details.setResponse_msg("Claims not found");
//			rootName1 = (mapper.writer().withRootName("ClaimDetails")
//					.writeValueAsString("Claim Record not found in given chassisno."));
//
//		}
//		rootname4 = (mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Chassis Number AND Registration Number"));
//	final String resultString = rootName.concat(rootName1).concat(rootname4);
//
//	final String data = resultString.replace("}{", ",");
//	
//	 hits_details.setResponse_given(LocalDateTime.now().toString());
//	  hit_repo.save(hits_details);
//
//		return data;
//
//		
//		
//		}
//		
//		////////////////////////////////////chassisno Only////////////////////////////////////////////////////////////////////////
//
//		if (regno.equals(" ") || regno.equals("") && !chassisno.equals("")) {
//			
//			hits_details.setChassisno(chassisno);
//		//	hits_details.setRegno(regno);
//
//			log.info("entering to block where only chassisno is there ");
//			
//			log.info("Chassisno:"+chassisno);
//
//			System.err.println("Entering to block where only chassisno is there ");
//
//			// policy details
//			final List<VchvsEntity> info1 = service.getInfo1(chassisno);
//
//			// claim details
//			final List<ClaimHistoryService> claimInfo2 = service.getClaimInfo2(chassisno);
//			
//			//risk score details
//			
//			List<VchvsEntity6> score2 = service.getScore2(chassisno);
//
//			//policy
//			if (!info1.isEmpty()) {
//				
//				hits_details.setResponse_msg(info1.toString().substring(0, 10));
//
//				rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(info1));
//			} else {
//
//				hits_details.setResponse_msg("policy not found");
//				rootName = (mapper.writer().withRootName("PolicyDetails")
//						.writeValueAsString(" policy data not found in given chassisno."));
//
//			}
//
//			//claims
//			if (!claimInfo2.isEmpty()) {
//				hits_details.setResponse_msg(claimInfo2.toString().substring(0, 10));
//
//				rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimInfo2));
//			} else {
//				hits_details.setResponse_msg("Claim not found.");
//				rootName1 = (mapper.writer().withRootName("ClaimDetails")
//						.writeValueAsString("Claim Record not found in given chassisno."));
//
//			}
//			
//			//risk score
//			
//if (!score2.isEmpty()) {
//				
//				hits_details.setResponse_msg(score2.toString());
//				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(score2));
//			} else {
//
//				hits_details.setResponse_msg("Risk score not found");
//				
//				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(
//						"This Vehicle may not be a private car or no risk score generated for this vehicle."));
//
//			}
//			
//			
//			rootname4 = (mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Chassis Number"));
//		final String resultString = rootName.concat(rootName1).concat(rootname3).concat(rootname4);
//
//		final String data = resultString.replace("}{", ",");
//		
//		 hits_details.setResponse_given(LocalDateTime.now().toString());
//		  hit_repo.save(hits_details);
//
//			return data;
//		}
//		
//		
//		
//	////////////////////////////////////////////////////registration number///////////////////	
//
//		// ** condition registration no. is there but chassisno is empty
//
//		// condition for DL registration number(val1)
//		if ((regno.startsWith("DL") || regno.startsWith("dl")) && !regno.substring(2, 3).equals("0")
//				&& !regno.substring(2, 4).matches("(^\\d{2})")) { // && !regno.substring(2,4).matches("(^\\d{2})")
//			
//			
//
//			hits_details.setRegno(regno);
//			
//			log.info("Entering block DL regno validation1 ");
//			
//			log.info("DLregno val1:"+regno);
//
//			String concatreg1 = "DL" + 0 + regno.substring(2);
//			// calling service method policy details
//			final List<VchvsEntity> dlVehicleDetails = service.getDlVehicleDetails(concatreg1, regno);
//			// calling service method for claim details
//			final List<ClaimHistoryService> claimDetailsforDl = service.getClaimDetailsforDl(concatreg1, regno);
//			// calling service for risk score details
//
//			final List<VchvsEntity6> score = service.getScore1(concatreg1, regno);
//			// policy
//
//			if (!dlVehicleDetails.isEmpty()) {
//				
//				hits_details.setResponse_msg(dlVehicleDetails.toString().substring(0, 10));
//
//				rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(dlVehicleDetails));
//			} else {
//				
//				hits_details.setResponse_msg("Policy not found");
//
//				rootName = (mapper.writer().withRootName("PolicyDetails")
//						.writeValueAsString(" policy data not found in given regno."));
//
//			}
//			// claims
//
//			if (!claimDetailsforDl.isEmpty()) {
//
//				hits_details.setResponse_msg(claimDetailsforDl.toString().substring(0, 10));
//				
//				rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimDetailsforDl));
//			} else {
//				
//				hits_details.setResponse_msg("Claim not found");
//
//				rootName1 = (mapper.writer().withRootName("ClaimDetails")
//						.writeValueAsString(" Claim Record not found in given regno."));
//
//			}
//			// riskscore
//
//			if (!score.isEmpty()) {
//				
//				hits_details.setResponse_msg(score.toString());
//				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(score));
//			} else {
//
//				hits_details.setResponse_msg("Risk score not found");
//				
//				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(
//						"This Vehicle may not be a private car or no risk score generated for this vehicle"));
//
//			}
//			rootname4 = (mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Registration Number"));
//		final	String resultString = rootName.concat(rootName1).concat(rootname3).concat(rootname4);
//
//		final	String data = resultString.replace("}{", ",");
//		
//		 hits_details.setResponse_given(LocalDateTime.now().toString());
//		  hit_repo.save(hits_details);
//		  
//		  log.info("Exiting block DL regno validation1 ");
//
//			return data;
//
//		} // condition for DL registration number(val1) end
//
//		// condition for DL registration number(val2) start
//		else if (regno.startsWith("DL") || regno.startsWith("dl") && regno.substring(2, 3).equals("0")) {
//			
//			hits_details.setRegno(regno);
//
//			log.info("Entering block DL regno validation2 ");
//
//			log.info("DLregno val2:"+regno);
//			String concatreg2 = regno.substring(0, 2) + regno.substring(3);
//
//			// calling service method policy details
//			final List<VchvsEntity> dlVehicleDetails = service.getDlVehicleDetails(concatreg2, regno);
//			// calling service method for claim details
//			final List<ClaimHistoryService> claimDetailsforDl = service.getClaimDetailsforDl(concatreg2, regno);
//			// calling service method for riskscore details
//
//			final List<VchvsEntity6> score = service.getScore1(concatreg2, regno);
//
//			// policy
//
//			if (!dlVehicleDetails.isEmpty()) {
//				
//				hits_details.setResponse_msg(dlVehicleDetails.toString().substring(0, 10));
//
//				System.err.println("policy data found");
//				rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(dlVehicleDetails));
//			} else {
//
//				
//				hits_details.setResponse_msg("Policy not found");
//				
//				rootName = (mapper.writer().withRootName("PolicyDetails")
//						.writeValueAsString(" policy data not found in given regno."));
//
//			}
////claims
//
//			if (!claimDetailsforDl.isEmpty()) {
//				
//				hits_details.setResponse_msg(claimDetailsforDl.toString().substring(0, 10));
//
//				System.err.println("claims data found");
//				rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimDetailsforDl));
//			} else {
//
//				hits_details.setResponse_msg("Claim not found ");
//				rootName1 = (mapper.writer().withRootName("ClaimDetails")
//						.writeValueAsString(" Claim Record not found in given regno."));
//
//			}
//			// riskscore
//
//			if (!score.isEmpty()) {
//				
//				hits_details.setResponse_msg(score.toString());
//
//				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(score));
//			} else {
//
//				hits_details.setResponse_msg("Riskscore not found ");
//				
//				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(
//						"This Vehicle may not be a private car or no risk score generated for this vehicle"));
//
//			}
//			rootname4 = (mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Registration Number"));
//
//		final	String resultString = rootName.concat(rootName1).concat(rootname3).concat(rootname4);
//
//		final	String data = resultString.replace("}{", ",");
//		 hits_details.setResponse_given(LocalDateTime.now().toString());
//		  hit_repo.save(hits_details);
//		  
//		  log.info("Exiting block DL regno validation2 ");
//
//			return data;
//
//		} // condition for DL registration number(val2) end
//		
//		
//		
//		
//		
//
//		// for rest of all regno
//		else {
//			
//		    hits_details.setRegno(regno);
//			
//			log.info("Entering to block-general regnos ");
//			
//			log.info("General regnos:"+regno);
//			
//			System.err.println("Entering to block-general regnos");
//			// policy details
//			final List<VchvsEntity> regnolist = service.getInfo(regno);
//			// claim details
//			final List<ClaimHistoryService> claimInfo1 = service.getClaimInfo1(regno);
//			// riskscore details
//			final List<VchvsEntity6> collectscore = service.getScore(regno);
//
//			b3 = (!regnolist.isEmpty());
//			//System.err.println(regnolist.isEmpty());
//			if (b3) {
//				
//				hits_details.setResponse_msg(regnolist.toString().substring(0, 10));
//
//				rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(regnolist));
//
//			} else {
//				
//				hits_details.setResponse_msg("Policy not found");
//
//				rootName = (mapper.writer().withRootName("PolicyDetails")
//						.writeValueAsString("policy data not found in given regno"));
//
//			}
//
//			// claim details
//
//			b6 = (!claimInfo1.isEmpty());
//
//			System.err.println(!claimInfo1.isEmpty());
//
//			if (b6) {
//				
//				hits_details.setResponse_msg(claimInfo1.toString().substring(0, 10));
//
//				rootName1 = mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimInfo1);
//
//			}
//
//			else {
//				
//				hits_details.setResponse_msg("Claim not found");
//
//				rootName1 = (mapper.writer().withRootName("ClaimDetails")
//						.writeValueAsString("Claim Record not Found in given reg no"));
//
//			}
//
//			// risk score details
//			b7 = (collectscore.isEmpty());
//
//			if (b7) {
//				
//				hits_details.setResponse_msg("riskscore not found");
//
//				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(
//						"This Vehicle may not be a private car or no risk score generated for this vehicle"));
//
//			}
//
//			else {
//				
//				hits_details.setResponse_msg(collectscore.toString().substring(0, 8));
//
//				rootname3 = mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(collectscore);
//
//			}
//
//			rootname4 = (mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Registration Number"));
//			String resultString = rootName.concat(rootName1).concat(rootname3).concat(rootname4);
//
//			String data = resultString.replace("}{", ",");
//			
//			 hits_details.setResponse_given(LocalDateTime.now().toString());
//			  hit_repo.save(hits_details);
//			  
//			  log.info("Exiting to block-general regnos ");
//
//			return data;
//		}
//
//	}
//
//}
