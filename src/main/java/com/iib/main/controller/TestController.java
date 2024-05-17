//package com.iib.main.controller;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.google.gson.Gson;
//import com.iib.main.entity.User;
//import com.jcraft.jsch.Channel;
//import com.jcraft.jsch.ChannelSftp;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.JSchException;
//import com.jcraft.jsch.Session;
//import com.jcraft.jsch.SftpException;
//
//@RestController
//public class TestController {
//	
//	@SuppressWarnings("resource")
//	@PostMapping("/put/userdetails")
//	public String getUsers( @RequestBody List<User> user) throws IOException, JSchException, SftpException {
//		
//	
//		
////		Gson gson = new Gson();
////		
////		String json = gson.toJson(user);
////		
////		
////		
////		FileWriter file = new FileWriter("E:/soumya/output.json");
////		
////		File file1=new File("E:/soumya/output.json");
////		
////	//	System.out.println(file1.exists());
////		
////		if(file1.exists()) {
////			
////			return "file already exist.";
////			
////		}
////		
////		
////        file.write(json.toString());
////        file.close();
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
//        session.connect(10000);
//        Channel channel = session.openChannel("sftp");
//        channel.connect();
//
//        System.out.println("Connection Opened");
//        ChannelSftp channelSftp = (ChannelSftp) channel;
//        InputStream inputStream = new FileInputStream("E:/soumya/output.json");
//        
//        InputStream inputStream2 = channelSftp.get("/home/ewa/ewa/iib-poc/media/dat_uploads/115_MOT_PREM_SEP_2022.dat");
//        System.out.println("File:"+inputStream2);
//        
//        channelSftp.put(inputStream, "/home/ewa/ewa/iib-poc/media/dat_uploads/output.json");
//
//        System.out.println("File should be uploaded");
//
//        channelSftp.disconnect();
//        session.disconnect();
//        
//		return "file saved successfully.";
//		
//	}
//
//}
