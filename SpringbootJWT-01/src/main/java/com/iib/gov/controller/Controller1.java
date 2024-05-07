package com.iib.gov.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller1 {
	
	@GetMapping("/accessBySoumya")
	public String getCurrentDateAndTime() {
		
		return LocalDateTime.now().toString();
	}

	
	
	
}
