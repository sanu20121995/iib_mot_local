package com.iib.main.controller;



import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.iib.main.entity.File;
import com.iib.main.entity.IibappUploadfile;
import com.iib.main.entity.PolicyRequestpojo;
import com.iib.main.entity.Policydetails;
import com.iib.main.exception.CustomException;
import com.iib.main.repository.FileRepository;
import com.iib.main.service.PolicyService;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

@RestController
public class TestController_policy {

	@Autowired
	private FileRepository repo;
	
	@Autowired
	private PolicyService service;
	
	@GetMapping("/message")
	public String welcome() {
		
      return "Welcome to IIB.";
	}

	// @SuppressWarnings("resource")
	@PostMapping("/toIIB/policydetails")
	public String getUsers(@RequestBody PolicyRequestpojo request)
			throws IOException, JSchException, SftpException, NoSuchFieldException, SecurityException {

		if (request.getInsurercode() == null || request.getControlamount() == null || request.getFromdate() == null
				|| request.getTodate() == null || request.getDetails() == null) {

			throw new CustomException("Request body not properly built as per IIB.");

		}

		// get insurer code
		String insurercode = request.getInsurercode();

		if (insurercode == null || insurercode.equals("")) {

			throw new CustomException("Insurer code can't be null");

		}

		// setting insurer id
		int insurerid = 0;
		switch (insurercode) {

		case "58":
			insurerid = 15;
			break;

		case "90":
			insurerid = 13;
			break;
		case "102":
			insurerid = 27;
			break;
		case "103":
			insurerid = 9;
			break;
		case "106":
			insurerid = 8;
			break;
		case "108":
			insurerid = 20;
			break;
		case "113":
			insurerid = 16;
			break;
		case "115":
			insurerid = 7;
			break;
		case "123":
			insurerid = 4;
			break;
		case "129":
			insurerid = 39;
			break;
		case "131":
			insurerid = 40;
			break;
		case "132":
			insurerid = 3;
			break;

		case "134":
			insurerid = 12;
			break;
		case "137":
			insurerid = 11;
			break;
		case "139":
			insurerid = 18;
			break;
		case "141":
			insurerid = 10;
			break;
		case "144":
			insurerid = 22;
			break;
		case "145":
			insurerid = 43;
			break;
		case "146":
			insurerid = 28;
			break;
		case "148":
			insurerid = 41;
			break;
		case "149":
			insurerid = 21;
			break;
		case "150":
			insurerid = 23;
			break;
		case "152":
			insurerid = 26;
			break;
		case "153":
			insurerid = 44;
			break;

		case "155":
			insurerid = 31;
			break;
		case "157":
			insurerid = 35;
			break;
		case "158":
			insurerid = 32;
			break;
		case "159":
			insurerid = 33;
			break;
		case "545":
			insurerid = 2;
			break;
		case "556":
			insurerid = 1;
			break;

		default:
			throw new CustomException("Insurer code not matching as per IIB:" + insurercode);
		}

		System.out.println("Insurer id:" + insurerid);

		// get from date

		String fromdate = request.getFromdate();

		// get todate

		String todate = request.getTodate();

		// from date validation

		if (!fromdate.matches("(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0,1,2])-(19|20)\\d{2}")) {

			throw new CustomException("from_date should be in dd-mm-yyyy proper format.");

		}

		// to date validation

		if (!todate.matches("(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0,1,2])-(19|20)\\d{2}")) {

			throw new CustomException("to_date should be in dd-mm-yyyy format.");

		}
		
		
		//date validation(financial year)
		
		
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	      //  Date currentDate = new Date(); // Current date
	      //  System.out.println("current date:"+currentDate);
	        
	        Date specifiedDate = null;
	        Date date1 = null;
			Date date2 =null;
	        
			try {
				specifiedDate = sdf.parse("01-04-2024");
				System.out.println("specified date:"+specifiedDate);
			    date1 = sdf.parse(fromdate);
			    System.out.println("from date:"+date1);
			    date2 = sdf.parse(todate);
			    
			    System.out.println("Todate:"+date2);
			    boolean before = date1.before(specifiedDate);
			    System.out.println(before);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

	        // Compare dates(from date)
	        if (date1.before(specifiedDate)) {
	            throw new CustomException("from-date shouldn't be before 01-04-2024 ");
	        } 
	        
	        if (date2.before(date1)) {
	           throw new CustomException("To-date shouldn't be before fromdate");
	        }

		// getting month from todate
		String month = todate.substring(3, 5);

		System.out.println("Month:" + month);
		
		if (month.startsWith("0")) {

			//System.out.println("if block not executing");
			
			month = month.substring(1);
				

		}

		// getting year from todate

		String year = todate.substring(6, 10);

		System.out.println("Year:" + year);

		// get no. of month
//		int month = request.getMonth();
//		
//		if(month ==0) {
//			throw new CustomException("Month can't be 0 or empty.");
//		}
//		
//		String monthnum = String.valueOf(month);
//
//		// get year
//		String year = request.getYear();
//		
//		if(year==null||year.equals("")) {
//			
//			throw new CustomException("Year can't be empty.");
//			
//		}
//		
//	if(! year.matches("(19|20)[0-9][0-9]")) {
//			throw new CustomException("Year is not in proper format");
//		}
//		

		// get controlamount

		String controlamount = request.getControlamount();

		if (controlamount == null || controlamount.equals("")) {
			throw new CustomException("Controlamount can't be empty.");
		}

		// get policy details
		List<Policydetails> policydetails = request.getDetails();

		System.out.println(policydetails);

//		if(fields2.length !=63) {
//			
//			System.out.println("if block not executing.");
//			throw new CustomException("Total no. fileds not matching!");
//			
//		}

		// get control number

		int size = policydetails.size();

		String controlnumber = String.valueOf(size);

		int controlnumber2 = request.getControlnumber();
		System.out.println("Total count:" + controlnumber2);

		System.out.println("No. of records sent" + size);

		if (size != request.getControlnumber()) {

			throw new CustomException(
					"Total_count not matching with the no. of records you sent." + "No. of records:" + size);

		}

		// transaction id can't be duplicate

		HashSet<String> tphashset = new HashSet<>();

		for (Policydetails policy : policydetails) {

			String txt_Transaction_ID = policy.getTxt_Transaction_ID();
			String txt_Insurer = policy.getTxt_Insurer();

			System.out.println("Txt_Transaction_ID::" + txt_Transaction_ID);
			System.out.println("Txt_insurer::" + txt_Insurer);

			if (policy.getBoo_AntiTheft() == null || policy.getNum_Net_TP_Premium() == null
					|| policy.getNum_Trailers_OD_Premium() == null

					|| policy.getTxt_Transaction_ID() == null || policy.getNum_Bifuel_OD_Premium() == null
					|| policy.getNum_Coolies_TP_Premium() == null

					|| policy.getBoo_Own_Premises() == null || policy.getOD_Policy_Start_Date() == null
					|| policy.getOD_Policy_Start_Date() == null || policy.getTxt_IIB_Make_Code() == null

					|| policy.getNum_NCB_Percentage() == null || policy.getTxt_CC_PCC_GVW_Code() == null
					|| policy.getNum_Basic_TP_Premium() == null

					|| policy.getTxt_Previous_Policy_Number() == null
					|| policy.getBoo_educational_institution_bus() == null || policy.getTxt_Class_Code() == null

					|| policy.getNum_NCB() == null || policy.getTxt_Insurer() == null
					|| policy.getTxt_Policy_Code() == null

					|| policy.getTxt_Year_of_Manufacturing() == null || policy.getTxt_Endorsement_Number() == null
					|| policy.getTxt_Distribution_Channel_Code() == null || policy.getTP_Policy_End_Date() == null

					|| policy.getEndorsement_Effective_Date() == null || policy.getNum_Other_TP_Premium() == null
					|| policy.getTxt_PAN_Number() == null

					|| policy.getTxt_Reg_Number_Vehicle() == null || policy.getOD_Policy_End_Date() == null
					|| policy.getNum_Other_PA_Premium() == null || policy.getNum_Cleaner_TP_Premium() == null
					|| policy.getTxt_RTA_Code() == null || policy.getTxt_Policy_Number() == null

					|| policy.getNum_Conductor_TP_Premium() == null || policy.getNum_Type_of_Fuel() == null
					|| policy.getPA_Policy_End_Date() == null || policy.getBoo_AutoAssociation() == null

					|| policy.getBoo_Zero_Depreciation() == null || policy.getBoo_Side_Car() == null
					|| policy.getBoo_Vintage_Car() == null || policy.getPA_Policy_Start_Date() == null

					|| policy.getNum_Trailers_TP_Premium() == null || policy.getBoo_Spl_Design() == null
					|| policy.getTxt_Year_of_Registration() == null

					|| policy.getNum_Bifuel_TP_Premium() == null || policy.getNum_Net_ZD_Premium() == null
					|| policy.getTxt_Endt_Type() == null || policy.getTxt_Policy_Number() == null

					|| policy.getNum_HP_tractor() == null || policy.getTxt_Policy_Remarks() == null
					|| policy.getNum_Elec_OD_Premium() == null || policy.getTP_Policy_Start_Date() == null
					|| policy.getNum_Basic_OD_Premium() == null || policy.getNum_Voluntary_Excess() == null
					|| policy.getCurrent_Year_IDV() == null || policy.getNum_Owner_PA_Premium() == null
					|| policy.getBoo_Fleet_Policy() == null || policy.getRunning_Year_of_Policy() == null
					|| policy.getBoo_TPPDStatutoryCoveronly() == null || policy.getNum_GVW() == null
					|| policy.getNum_Driver_LL_TP_Premium() == null || policy.getTxt_Aadhar_Number() == null
					|| policy.getDate_Transaction_ID() == null || policy.getNum_CC() == null
					|| policy.getTxt_Engine_Number() == null || policy.getTxt_Office_Code() == null
					|| policy.getNum_Net_OD_Premium() == null || policy.getPA_Ownerdriver_Sum_Insured() == null
					|| policy.getNum_PCC() == null || policy.getTxt_Chassis_Number() == null) {

				throw new CustomException("Request body of Policy_Details not properly built.");

			}

			if (!txt_Insurer.equals(insurercode)) {

				throw new CustomException("Insurer_code not matching with Txt_Insurer");

			}

			if (txt_Transaction_ID == null || txt_Transaction_ID.equals("")) {

				throw new CustomException("Transaction id can't be empty or null");

			}

			// except 90 or 58
			if (txt_Insurer.equals("58") || txt_Insurer.equals("90")) {

				if (!txt_Transaction_ID.substring(0, 2).equals(txt_Insurer)) {

					throw new CustomException("Transaction id not matching with txt_insurer:" + txt_Transaction_ID);

				}

			}

			else {
				if (!txt_Transaction_ID.substring(0, 3).equals(txt_Insurer)) {

					throw new CustomException("Transaction id not matching with txt_insurer:" + txt_Transaction_ID);

				}

			}

			if (tphashset.add(txt_Transaction_ID) == false) {

				throw new CustomException("Duplicate transaction id:" + txt_Transaction_ID);
			}

		}

		Gson gson = new Gson();

		String json = gson.toJson(policydetails);

		// String filename1 = insurercode + "_MOT_TP_CLAIM_" + monthinwords + "_" + year
		// +stringdate+ ".json";

		String filename1 = insurercode + "_MOT_PREM_" + fromdate + "to" + todate + ".json";

		System.out.println(filename1 + "***************************");

		// creating file and filename
		// File file1 = new File("/home/ewa/ewa/iib-poc/media/uploads/" + filename1);
		//File file1 = new File("D:/tp_claimsfiles" + filename1);
		 
		 List<String> statuslist = service.getStatus(filename1);

			System.out.println("status:" + statuslist);

			if (!statuslist.isEmpty()) {

				for (String status : statuslist) {
					System.out.println("for-loop executing...............");

					// for file status success

					if (status.equals("SUCCESS")) {

						throw new CustomException(
								"You already sent records in given duration.Please change fromdate and todate.");
					}
					
					
					if (status.equals("FAILURE")) {
						
						System.out.println("Failure logic executing...............");

					}
					
//					if (status.equals("PARTIALLY SUCCESS") ) { //&& failurecount.equals(controlnumber)
//						
//						System.out.println("partiaally success logic executing...............");
//
//						filename1 =repo.getFilename(insurerid,year,"PREMIUM") ;
//
//						String substring2 = filename1.substring(29, 44);
//						String substring = filename1.substring(39);
//
//						boolean contains = substring2.contains("_1");
//
//						System.out.println(contains);
//
//						System.out.println("new file length:" + substring + "----" + substring2);
//						
//						boolean contains2 = substring2.contains("_4");
//						System.out.println(contains2+"4fileeeeeeeeeeeeeeeeeeeeeeeee");
//
//						if (substring2.contains("_1")) {
//
//							filename1 = insurercode + "_MOT_PREM_" + fromdate + "to" + todate + "_2" + ".json";
//
//						}
//						
//						else if (substring2.contains("_2")) {
//
//							filename1 = insurercode + "_MOT_PREM_" + fromdate + "to" + todate + "_3" + ".json";
//
//						}
//						
//						else if (substring2.contains("_3")) {
//
//							filename1 = insurercode + "_MOT_PREM_" + fromdate + "to" + todate + "_4" + ".json";
//
//						}
//						else if (substring2.contains("_4")) {
//
//							filename1 = insurercode + "_MOT_PREM_" + fromdate + "to" + todate + "_5" + ".json";
//
//						}
//						else if (substring2.contains("_5")) {
//
//							filename1 = insurercode + "_MOT_PREM_" + fromdate + "to" + todate + "_6" + ".json";
//
//						}
//						else {
//							System.out.println("else also executing.");
//						filename1 = insurercode + "_MOT_PREM_" + fromdate + "to" + todate + "_1" + ".json";
//						}
//						System.out.println("new file name==" + filename1);
//
//						// throw new CustomException("success");
//
//					} //end of partial success logic

					if (status.equals("PROCESSING")) {
						
						System.out.println("processing logic executing...............");
						
						throw new CustomException(
								"Records are in process. Please check after sometime.");

					}
				}//for
					
				} //file status success validation
//		if (file1.exists()) {
//
//			throw new CustomException("You already sent records in given duration.Please change fromdate and todate.");
//
//		}

		FileWriter file = new FileWriter("/home/ewa/ewa/iib-poc/media/uploads/" + filename1);
		//FileWriter file = new FileWriter("D:/tp_claimsfiles" + filename1);
		System.out.println(json);

		file.write(json.toString());

		// file.append(json.toString());

		file.close();// end of file creation

		// uploading file details in db
		IibappUploadfile filedetails = new IibappUploadfile();

		filedetails.setFilename(filename1);

		filedetails.setFiletype("PREMIUM");
		
		System.out.println("new month:"+month);
		filedetails.setMonth(month);
		filedetails.setYear(year);
		filedetails.setUploadedon(LocalDateTime.now().toString());
		filedetails.setUploadedfile("uploads/" + filename1);
		filedetails.setFilestatus("RECEIVED");
		filedetails.setControlamount(controlamount);
		filedetails.setControlnumber(controlnumber);
		// filedetails.setFailedreason();
		filedetails.setProcessedon(LocalDateTime.now().toString());
		filedetails.setInsurerid(insurerid);
		filedetails.setUploadedbyuserid(5608);

		// filedetails.setProcessrecords(0);
		// filedetails.setSuccessrecords(0);
		filedetails.setFileextension("json");
		filedetails.setIsactive(1);

		// saving file details into db
		 repo.save(filedetails);

		System.out.println("file stored to db successfully.");
//		//jsech implementation
//        JSch jsch = new JSch();
//        Session session = jsch.getSession("ewa", "10.0.2.39", 22); // 22 for SFTP
//        session.setPassword("Covalense@135$");
//
//
//        java.util.Properties config = new java.util.Properties();
//        config.put("StrictHostKeyChecking", "no");
//        session.setConfig(config);
//
//        session.connect();
//        Channel channel = session.openChannel("sftp");
//        channel.connect();
//
//        System.out.println("Connection Opened");
//        ChannelSftp channelSftp = (ChannelSftp) channel;
//       
//        InputStream inputStream = new FileInputStream("D:/tp_claimsfiles/"+filename1);
//      
//        
//        channelSftp.put(inputStream, "/home/ewa/ewa/iib-poc/media/uploads/"+filename1);
//
//        System.out.println("File uploaded in remote server successfully.");
//
//        channelSftp.disconnect();
//        session.disconnect();

		return size + "no. of records pushed to IIB successfully.\nFor error records please refer this file:"+"'"+filename1+"'";

	}

}
