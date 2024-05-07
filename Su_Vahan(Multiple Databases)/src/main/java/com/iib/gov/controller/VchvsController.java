package com.iib.gov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iib.gov.config.motorconfig.MotorConfig;
import com.iib.gov.entity.vcvhsentity.VchvsEntity;
import com.iib.gov.entity.vcvhsentity2.VchvsEntity2;
import com.iib.gov.service.VchvsService;

@RestController
@RequestMapping("/getaccess")
public class VchvsController {
	@Autowired
	private VchvsService service;
	
	@Autowired
	private  MotorConfig config;
	
	
	@GetMapping(value= "/getPolicyDetails/{chassisno}")
	public List<VchvsEntity> getDetails(@PathVariable String  chassisno){
		System.out.println(chassisno+"--------------------------------");
		
		return service.getAllDetails(chassisno);
	}
	
	
	//for both registration n umber and chassis number
	
	@GetMapping(value= "/getPolicyDetails/{chassisno}/{regno}")
	public List<VchvsEntity> getDetails2(@PathVariable String  chassisno, @PathVariable String regno){
		System.out.println(chassisno+"--------------------------------");
		
		return service.getAllDetails(chassisno);
	} 
	
	
	@GetMapping(value= "/getPolicyDetails2/{chassisno}")
	public List<VchvsEntity2> getDetails2(@PathVariable String  chassisno){
		
		return service.getAllDetails2(chassisno);
	}

	
	
}
