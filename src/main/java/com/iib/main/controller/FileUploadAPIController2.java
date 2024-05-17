//package com.iib.main.controller;
//
//
//
//import java.io.IOException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.iib.main.entity.File;
//import com.iib.main.repository.FileRepository;
//
//
//
//
//
//@RestController
//@RequestMapping("/api/files")
//public class FileUploadAPIController2 {
//
//	 @Autowired
//	   FileRepository fileRepository;
//	   @PostMapping("/upload")
//	   public String saveFile(@RequestParam("file") MultipartFile file){
//	     try {
//	      String fileName = file.getOriginalFilename();
//	      String contentType = file.getContentType();
//	      byte[] fileContent = file.getBytes();
//	      File savefile = new File(fileName, contentType, fileContent);
//	      fileRepository.save(savefile);
//	    
//	      return "File saved successfully";
//	     }
//	   
//	     catch(Exception e) {
//	      return "File not saved";
//	    }
//	   }
//}
