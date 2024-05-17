package com.iib.main.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.iib.main.repository.FileRepository;


@Service
public class PolicyService {
	
	@Autowired
	private FileRepository repository;
	
	
	public List<String> getStatus(String filename) {
		System.out.println("file name in service:"+filename);
		List<String> filestatus = repository.getstatus(filename);
		return filestatus;
		
		
	}
	
	
	
   
}
