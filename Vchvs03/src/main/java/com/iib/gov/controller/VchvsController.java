//package com.iib.gov.controller;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//import org.apache.commons.logging.Log;
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
////import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
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
//public class VchvsController {
//
//	@Autowired
//	private VchvsService service;
//	
//	
//	
//	
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
//	private List<Object> claimByRegno;
//	private List<Object> policyInfoByChassisnoNewTable;
//	private List<Object> chassisnolist;
//	private List<Object> claimByChassino ;
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
//    private final ObjectMapper mapper=  new ObjectMapper();
//    
//    static Logger log = Logger.getLogger(VchvsController.class);
//    
//    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(VchvsController.class);
//    
////    public VchvsController() {
////		System.out.println("controller object created");
////		mapper=  new ObjectMapper();
////	}
//    
//    //creating logger object
//  //  public static final	Logger logger=Logger.getLogger(VchvsController.class);
//	// get policy details based on both reg no and chassis no
//
//	@GetMapping("/getClaimDetails")
//	
//	public  String getPolicy(@RequestParam String regno)  throws IOException, SQLException  {
//		
//	//	boolean b1= (!dl2regnolist.isEmpty());
//		
//		
//		
//		regnolist = service.getInfo(regno).stream().map(element -> (Object) element).collect(Collectors.toList());
//		
//		
//		
//		claimDeatils=service.getClaimInfo1(regno).stream().map(claimdetails -> (Object)claimdetails).collect(Collectors.toList());
//		
//		
//		
//		String rootName;
//		String rootName1;
//		 ObjectMapper mapper = new ObjectMapper();
//		 if(regnolist.isEmpty()){
//				
//			
//				
//					rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString("No Policy Record Found in this reg no"));
//				
//				
//			}
//			else {
//				
//				
//					rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(regnolist));
//				
//			}
//		 
//		 if(claimDeatils.isEmpty()){
//				
//				// regDetails.setFound("N"); 
//		    
//				rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString("No Claim Record Found in this reg no"));
//	
//		     
//			} else {
//			
//					rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimDeatils));
//			}
//		 
//		
//		 
//			
//		 String rt = rootName;
//		 
//	
//		 
//		 String policyAndClaimdata= rt.replace("}{", ",");
//
//	
//		 
//		return rt;
//
//	}
//
//	//@SuppressWarnings("unchecked")
//	@GetMapping("/getVehicleDetails")
//	public  ResponseEntity<String> getVehicleDetails(@RequestParam String regno, @RequestParam (required = false, defaultValue="") String chassisno,HttpServletRequest request,HttpServletResponse res) throws Exception {
//		
//	//	synchronized (this) {
//			LOG.info("executed by");
//		
//     log.info("executed by sanu:" +Thread.currentThread().getName());
//			
//		log.info("Registration number:"+regno);
//		
//	//	logger.info("Entering to getVehicleDetails() method ");
//		
//	//	System.err.println(mapper.hashCode());
//		
//		//get the client ip
//		
//		String ipAddress = request.getRemoteAddr();
//		// String ipAddress = HttpUtils.getRequestURL(request).toString();
//		//Authentication case sensitive
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//	
//		String name = authentication.getName();
//	//	logger.info("Getting username from security context holder " + name);
//
//		System.err.println(name);
//		
//		
//		
//		//Inserting url hit records into db
//		
//		 hitDetails=new Vchvs_hits_details();
//	//	logger.info("creating object of 'Vchvs_hits_details' for storing logs ");
//
//		System.out.println("Registration number::" + regno + "\nChassis Number::" + chassisno);
//	//	logger.info("Registration number::" + regno + "\nChassis Number::" + chassisno);
//		//condition chassisno 
//		
//		if(chassisno.length() <11 && chassisno.length() > 0) {
//		//	logger.warn("Chassino. should not be less than 11 digits");
//			throw new CustomException("Chassino. should not be less than 11 digits");
//		}
//
//		if (regno.length() < 6 && regno.length() > 0) {
//			
//		//	logger.warn("Regno. should not be less than 6 digits");
//			
//			throw new CustomException("Regno. should not be less than 6 digits");
//		}
//
//		
//
//		// condition if both registartion number and chassis number are empty
//		if (regno.equals("") && chassisno.equals("")) {
//			
//		//	logger.warn("You have to pass either registration number or chassis number or both");
//			
//			throw new CustomException("You have to pass either registration number or chassis number or both");
//		}
//		
////////		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//		// condition if both registration number and chassis number are present
//
//		if (!regno.equals("") && !chassisno.equals("")) {
//			
//		//	logger.info("Entering into  logic condition if both registration number and chassis number are present");
//			
//			//validation for dl registraion number
//			
//
////	  if(service.getInfo4(regno, chassisno).isEmpty()) {
////	  
////	  return service.getInfo5(regno, chassisno); } else {
////	  
////	  return service.getInfo4(regno, chassisno); }
//
//			// using ternary operator policy details
//
//			List<Object> bothChassisAndRegistrationlist = 
//					
//					 service.getInfo4(regno, chassisno).stream().map(element -> (Object) element) 
//							.collect(Collectors.toList());
//			
//			
//			String rootName;
//			String rootName1;
//		//	 ObjectMapper mapper = new ObjectMapper();
//			 
//			  hitDetails.setHit_time(LocalDateTime.now().toString());
//			  hitDetails.setUsernamne(name);
//				hitDetails.setIp_address(ipAddress);
//				hitDetails.setChassisno(chassisno);
//				hitDetails.setRegno(regno);
//				
//				String resPolicyForboth=null;
//				String resClaimForboth=null;
//			 b11=bothChassisAndRegistrationlist.isEmpty();
//			 
//			 if(b11){
//				
//		//		 logger.info("No Policy Record Found in this regno and chassisno");
//				 resPolicyForboth="No Policy Record Found in this regno and chassisno.";
//						rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString("No Policy Record Found in this reg no and chassis no"));
//					
//					
//				}
//				else {
//				
//		//			logger.info("Policy details found");
//					resPolicyForboth="Policy Record Found in this regno and chassisno.";
//						rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(bothChassisAndRegistrationlist));
//					
//				}
//			 
//			 List<Object> claimInfoBybothRegAndChassisno=	 service.getClaimInfo3(regno, chassisno).stream().map(element -> (Object) element).collect(Collectors.toList());
//              b12=claimInfoBybothRegAndChassisno.isEmpty();
//			//claim details
//			if(b12) {
//				
//		//		logger.info("No Claim Record Found in this regno and chassisno");
//				resClaimForboth="No Claim Found in this regno and chassisno.";
//				rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString("No Claim Record Found in this reg no and chassis no"));
//				
//			     
//			} 
//			
//			else {
//				
//				
//			
//					rootName1 = (mapper.writer().withRootName("ClaimDetails")
//							.writeValueAsString(claimInfoBybothRegAndChassisno));
//					
//			//		logger.info("Claim Record Found in this reg no and chassis no");
//					resClaimForboth="Claim Found in this regno and chassisno.";
//			}
//			rootname4=(mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Chassis Number "+"AND"+" Registration Number"));
//			String rt = rootName+rootName1+rootname4;
//			
//			//Inserting into log tables(for both regno and chassis no)
//			
////			if(b11 && b12) {
////				
////				  hitDetails.setHit_time(LocalDateTime.now().toString());
////				  hitDetails.setUsernamne(name);
////					hitDetails.setIp_address(ipAddress);
////					hitDetails.setChassisno(chassisno);
////					hitDetails.setRegno(regno);
////					hitDetails.setResponse_msg("Policy not found and Claim Not Found in given reg no and chassisno");
////					hit_repo.save(hitDetails);
////				
////			}
////			
////			else if((!b11) && b12) {
////				  hitDetails.setHit_time(LocalDateTime.now().toString());
////				  hitDetails.setUsernamne(name);
////					hitDetails.setIp_address(ipAddress);
////					hitDetails.setChassisno(chassisno);
////					hitDetails.setRegno(regno);
////					hitDetails.setResponse_msg("Policy found and ClaimNot Found in given reg no and chassisno");
////					hit_repo.save(hitDetails);
////				
////			}
////			else if((b11) && (!b12)) {
////				  hitDetails.setHit_time(LocalDateTime.now().toString());
////				  hitDetails.setUsernamne(name);
////					hitDetails.setIp_address(ipAddress);
////					hitDetails.setChassisno(chassisno);
////					hitDetails.setRegno(regno);
////					hitDetails.setResponse_msg("Policy not  found and Claim Found in given reg no and chassisno");
////					hit_repo.save(hitDetails);
////				
////			}
////			else {
////				 hitDetails.setHit_time(LocalDateTime.now().toString());
////				  hitDetails.setUsernamne(name);
////					hitDetails.setIp_address(ipAddress);
////					hitDetails.setChassisno(chassisno);
////					hitDetails.setRegno(regno);
////					hitDetails.setResponse_msg("Policy found and Claim Found in given reg no and chassisno");
////					hit_repo.save(hitDetails);
////			}
//		 
//			hitDetails.setResponse_msg(resPolicyForboth+resClaimForboth);
//			hit_repo.save(hitDetails);
//			
//			 String policyAndClaimdataByRegnoAndChassisno= rt.replace("}{", ",");
//
//			return new ResponseEntity<String>(policyAndClaimdataByRegnoAndChassisno, HttpStatus.OK);
//			
//			
//
//			
//		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		
//		// condition if registration is empty and chassissno is there
//
//		if (regno.equals(" ") || regno.equals("") && !chassisno.equals("")) {
//			
//		//	logger.info("Entering into logic condition if registration number is empty and chassis number is present");
//			
//			 hitDetails.setHit_time(LocalDateTime.now().toString());
//			  hitDetails.setUsernamne(name);
//				hitDetails.setIp_address(ipAddress);
//				hitDetails.setChassisno(chassisno);
//				
//				String reschassisPolicy=null;
//				String reschassisClaim=null;
//
//			// if chassis no not present in 2021 and 2122
//				
//				 chassisnolist = 
//						 service.getInfo1(chassisno).stream().map(element -> (Object) element)
//								.collect(Collectors.toList());
//			 
//			 
//			 
//			 b9=chassisnolist.isEmpty();
//			 
//			if (b9) {
//				
//		//	logger.info("There is no policy data in this chassisno");
//             reschassisPolicy="There is no policy data in given chassisno.";
//             
//				rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString("There is no policy data in this chassisno"));
//
//			}
//
//			
//
//		
//				
//				else {
//			//		logger.info("Policy details found from motorDB database.");
//					
//					reschassisPolicy="policy data found in given chassisno.";
//					
//					rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(chassisnolist));
//					
//				
//			}
//				
//				//for claim details
//				 claimByChassino =	service.getClaimInfo2(chassisno).stream().map(element -> (Object) element).collect(Collectors.toList());
//				
//				 b10=claimByChassino.isEmpty();
//				 if(b10) {
//				
//			//		 logger.info("No Claim Record Found in this  chassis no");
//					reschassisClaim="No Claim Record Found in this chassisno.";
//					rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString("No Claim Record Found in this  chassis no"));
//					
//				     
//				} 
//				
//				else {
//				
//			//		 logger.info("Claim Record Found in this  chassis no");
//
//					 reschassisClaim="Claim Record Found in given chassisno.";
//						rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimByChassino));
//				}
//				
//				rootname4=(mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Chassis Number"));
//				 
//				String rt = rootName+rootName1+rootname4;
//
//				 
//				hitDetails.setResponse_msg(reschassisPolicy+reschassisClaim);
//				hit_repo.save(hitDetails);
//				 String policyAndClaimdataByChassisno= rt.replace("}{", ",");
//
//				return new ResponseEntity<String>(policyAndClaimdataByChassisno, HttpStatus.OK);
//				// return policyAndClaimdataByChassisno;
//
//			}
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
//
//		// condition registration no. is there but chassisno is empty
//
//		if (!regno.equals("") && chassisno.equals("")) {
//			
//			log.info("Registration number:::::::::"+regno);
//			
//	//		synchronized (this) {
//	//			log.info("Entering into logic condition registration no. is there but chassisno is empty:"+LocalDateTime.now().toString());
//			
//			
//	//		logger.info("Entering into logic condition registration no. is there but chassisno is empty");
//			
//			String responsemsg=null;
//			String resmsgPolicy = null;
//			String resmsgClaim=null;
//			String  resmsgriskScore;
//			hitDetails.setHit_time(LocalDateTime.now().toString());
//		    hitDetails.setUsernamne(name);
//			hitDetails.setIp_address(ipAddress);
//			hitDetails.setRegno(regno);
//			
//			//condition for dl vehicle for policy
////			if(regno.startsWith("DL")) {
////				
////				 System.out.println("Control flow coming to DL validation 1 ");
////				dl1regnolist = (service.getInfo(regno).isEmpty())
////						? service.getInfo2(regno).stream().map(element -> (Object) element).collect(Collectors.toList())
////						: service.getInfo(regno).stream().map(element -> (Object) element).collect(Collectors.toList());
////				
////				if(! dl1regnolist.isEmpty()) {
////					rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(dl1regnolist));
////
////					//rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString("There is no policy data in this DL validation1 regno"));
////				}
//				
////				else {
//			
//			//condition for dl vehicle for policy
//			
//					
//					 if(regno.startsWith("DL") && !regno.substring(2,3).equals("0") && !regno.substring(2,4).matches("(^\\d{2})")) { //&& !regno.substring(2,4).matches("(^\\d{2})")
//        //                 logger.info("Entering into DL validation 1");
//                         
//					 System.out.println("Control flow coming to DL validation 1 ");
//						String concatreg1 ="DL"+0+regno.substring(2);
//						dl2regnolist =  service.getDlVehicleDetails(concatreg1,regno).stream().map(element -> (Object) element).collect(Collectors.toList());
//			
//						 b1=(! dl2regnolist.isEmpty());
//						
//						if(b1) {
//						
//	//						logger.info("policy data found in given DL validation 1 regno");
//							resmsgPolicy="****"+dl2regnolist.toString().substring(0, 10);
//							rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(dl2regnolist));
//
//							//rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString("There is no policy data in this DL validation1 regno"));
//						}
//						else {
//							
//							//hitDetails.setChassisno(chassisno);
//						//	logger.info("There is no policy data in given DL validation 1 regno");
//							resmsgPolicy="policy data not found in given regno.";
//							rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString("policy data not found in given regno."));
//						}
//					 
//					 }
//					 
//					 else if(regno.startsWith("DL") && regno.substring(2,3).equals("0")){
//						 
//		//				 logger.info("Entering into DL validation 2");
//						 
//							System.out.println("Control flow coming to DL validation 2 ");
//							
//							String concatreg2=	regno.substring(0, 2) + regno.substring(3);
//							System.out.println(concatreg2+"validation 3 regno");
//							dl3regnolist=	 service.getDlVehicleDetails(concatreg2,regno).stream().map(element -> (Object) element).collect(Collectors.toList());
//							
//							 b2=(! dl3regnolist.isEmpty());
//							
//							if (b2) {
//								
//		//						logger.info("policy data found in given DL validation 2 regno");
//								
//								resmsgPolicy="****"+dl3regnolist.toString().substring(0, 10);;
//	                            
//								rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(dl3regnolist));
//							}
//							else {
//		//						logger.info("policy data not found in DL validation 2 regno");
//								
//								resmsgPolicy="policy data not found in given regno.";
//								
//								rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(" policy data not found in given regno."));
//								
//						}
//					 
//					 }
//					
//			
//			else {
//
//			//policy details
//			
//				regnolist= service.getInfo(regno).stream().map(element -> (Object) element).collect(Collectors.toList());
//			
//			 b3=(!regnolist.isEmpty());
//			 System.err.println(regnolist.isEmpty());
//			if (b3) {
//				
//			//	logger.info("policy data found in given regno");
//			//	resmsgPolicy=" ****"+regnolist.toString().substring(0,10);
//				rootName = mapper.writer().withRootName("PolicyDetails").writeValueAsString(regnolist);
//			}
//			else {
//				
//			//	logger.info("policy data not found in given regno");
//				resmsgPolicy="policy data not found in given  regno.";
//				rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString("policy data not found in given regno"));
//			}
//			
//			}
//			
//			//Dl validation for claim details 
//			
////			if(regno.startsWith("DL")) {
////				
////			  dl1claim= service.getClaimInfo1(regno).stream().map(element -> (Object) element).collect(Collectors.toList());
////			  
////			  if(! dl1claim.isEmpty()) {
////					rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString(dl1claim));
////
////				}
//	//		  else {
//					 
//					//Dl validation for claim details 
//					 
//				  if(regno.startsWith("DL") && !regno.substring(2,3).equals("0") && !regno.substring(2,4).matches("(^\\d{2})")) {
//				//	  logger.info("Entering into DL validation 1 claim details");
//					  System.out.println("Control flow coming to DL validation 1 claim");
//					  String concat ="DL"+0+regno.substring(2);
//					  dl2claim=service.getClaimDetailsforDl(concat,regno).stream().map(element -> (Object) element).collect(Collectors.toList());
//					  System.out.println(dl2claim.isEmpty() +"**************");
//					  
//					  b4=(! dl2claim.isEmpty());
//					  
//					  if(b4) {
//						  
//				//		  logger.info("Claim Record Found in given DL validation 1 reg no");
//						  resmsgClaim="&&&&&&"+dl2claim.toString().substring(0, 10);
//							rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString(dl2claim));
//
//						}
//					  else {
//						  
//				//		  logger.info("Claim Record Not Found in given DL validation 1 reg no");
//						  resmsgClaim="Claim Record Not Found regno.";
//							rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString("Claim Record Not Found in given reg no"));
//						}
//					  
//				  }
//				  
//				 
//						 else if(regno.startsWith("DL") && regno.substring(2,3).equals("0")){
//							 
//				//			 logger.info("Entering into DL validation 2 claim details");
//							 
//								System.out.println("Control flow coming to DL validation 2 claim");
//								
//								String concat2=	regno.substring(0, 2) + regno.substring(3);
//								
//								dl3claim=service.getClaimDetailsforDl(concat2,regno).stream().map(element -> (Object) element).collect(Collectors.toList());
//								
//								 b5=(! dl3claim.isEmpty());
//								
//								 if(b5) {
//									 
//				//					 logger.info("Claim Record Found in given DL validation 2 reg no");
//									 resmsgClaim="&&&&&&"+dl3claim.toString().substring(0, 10);
//									 
//										rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString(dl3claim));
//
//									}
//								  else {
//									  
//						//				 logger.info("No Claim Record Not Found in given DL validation 2 reg no");
//										 resmsgClaim="Claim Record not Found in given regno.";
//									
//										rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString("Claim Record not found in given  reg no"));
//									}
//				  }
//				  
//			  
//				
//			
//			else {
//				
//			
//			
//				claimByRegno = service.getClaimInfo1(regno).stream().map(element -> (Object) element).collect(Collectors.toList());
//			
//			  b6=(!claimByRegno.isEmpty());
//			  
//			  System.err.println(!claimByRegno.isEmpty());
//			 
//			if(b6) {
//				
//			//	 logger.info("Claim Record Found in given reg no");
//			//	resmsgClaim="&&&&&&"+claimByRegno.toString().substring(0, 10);
//				rootName1 = mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimByRegno);
//				
//			     
//			} 
//			
//			else {
//				
//		//		 logger.info("Claim Record not Found in given reg no");
//				 resmsgClaim="Claim Record not Found in given regno.";
//					rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString("Claim Record not Found in given reg no"));
//			}
//			}
//				  
//				  
//			//Get risk score details
//				  
//	final  List<VchvsEntity6> collectscore = service.getScore(regno);
//			 
//			 
//	//		 System.out.println(score+"///////////////////////");
//			 
//			//System.out.println(score.toString().equals(""));
//			 
//			 b7=(collectscore.isEmpty());
//			 
//			 if(b7) {
//		//		 logger.info("Risk score not Found in given reg no");
//				 resmsgriskScore="Risk score not Found in given regno.";
//				 rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString("This Vehicle may not be a private car or no risk score generated for this vehicle"));
//				 
//				
//			 }
//			 
//			 else {
//				 
//	//		String finalscore= score.replaceAll("\r","");
//		
//	//		  System.out.println(finalscore.length()+"///////////////////////");
//			
//		//	if(finalscore!=null || !finalscore.contains("") ) {
//				 
//				
//			
//			  
//		//	  logger.info("Risk score Found in given reg no");
//		//	  resmsgriskScore="#######"+score.toString().substring(0);
//				rootname3 = mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(collectscore);
//			
//			 }
//			
//			 rootname4=(mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Registration Number"));
//			 //////////////////////////////
//			 
//			 
//		
//			 
//	//		 hitDetails.setResponse_msg(resmsgPolicy+resmsgClaim+resmsgriskScore);
//	
//			 
//		}
//		
//		
//		//condition for maintaining log details if in table
////		
////		 if( ((!b1 && b2) || b3) && ((!b4&&b5) || b6) && b7) {
////		   // hitDetails.setChassisno(chassisno);
////		    hitDetails.setHit_time(LocalDateTime.now().toString());
////			hitDetails.setIp_address(clientIp);
////			hitDetails.setRegno(regno);
////			hitDetails.setResponse_msg("Policy data not found in given regno.Claim Record not Found in given reg no.Risk Score not found in given regno");
////			hit_repo.save(hitDetails);
////		 }
//		 
//		String policyAndClaimdataByRegno;
//		
//			
//		//	String rt = rootName+rootName1+rootname3+rootname4;
//			
//		//final String rt = rootName.concat(rootName1).concat(rootname3).concat(rootname4);
//		
//        final String rt=rootName;
//
//			 
//	//	  policyAndClaimdataByRegno= rt.replace("}{", ",");
//			
//		
//		
//		 
//	//	 log.info("Response::::" +policyAndClaimdataByRegno);
//		 
//	//		log.info("Response return time"+LocalDateTime.now().toString());
//			
//			hitDetails.setResponse_given(LocalDateTime.now().toString());
//			hit_repo.saveAndFlush(hitDetails);
//		
//      // 	return new ResponseEntity<String>(policyAndClaimdataByRegno, HttpStatus.OK);
//			
//	  return ResponseEntity.ok(rt);
//		
//	//	}// synchronize end
//		
//		
//	}
//
//}
