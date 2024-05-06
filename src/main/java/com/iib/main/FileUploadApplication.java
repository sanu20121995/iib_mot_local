package com.iib.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileUploadApplication {
	
	

//	@Value("${spring.servlet.multipart.max-file-size}") String maxFileSize;
//	@Value("${spring.servlet.multipart.max-request-size}") String maxRequestSize;

	public static void main(String[] args) {
		SpringApplication.run(FileUploadApplication.class, args);
	}

	
//	@Bean
//	public MultipartResolver commonsMultipartResolver(){
//		
//		
//		StandardServletMultipartResolver standardServletMultipartResolver = new StandardServletMultipartResolver();
//		standardServletMultipartResolver.setMaxUploadSize(DataSize.parse(maxRequestSize).toBytes());
//		standardServletMultipartResolver.setMaxUploadSizePerFile(DataSize.parse(maxFileSize).toBytes());
//		standardServletMultipartResolver.s
//		
//		return standardServletMultipartResolver;
//	}

}
