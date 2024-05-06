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
//import com.iib.main.service.FileService;
//
//
//
//
//@RestController
//@RequestMapping("/api/files")
//public class FileUploadAPIController {
//
//    @Autowired
//    FileService fileService;
//
//    @PostMapping("/upload")
//    public ResponseEntity<?> handleFileUpload(
//            @RequestParam("uploaded-file") List<MultipartFile> uploadedFiles)
//        throws IOException {
//        System.out.println("Uploaded files size : {}"+ uploadedFiles.size());
//        fileService.copyFile(uploadedFiles);
//        return ResponseEntity.ok().build();
//    }
//}
