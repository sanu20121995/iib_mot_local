package com.iib.gov.service;


import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.iib.gov.entity.vchvsEntityOld.InsurerInfo;
import com.iib.gov.entity.vchvsEntityOld.UserInfoDetails;
import com.iib.gov.repo.old.UserInfoRepository; 

@Service
public class UserInfoService implements UserDetailsService { 

	@Autowired
	private UserInfoRepository repository; 

	@Autowired
	private PasswordEncoder encoder; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 

		//Optional<InsurerInfo> userDetail = repository.findBycode(username); 
		System.out.println("username(userdetails):"+username);
		Optional<InsurerInfo> bycode = repository.findByicode(username);
         System.out.println(bycode+"000000000");
		// Converting userDetail to UserDetails 
		return bycode.map(UserInfoDetails::new) 
				.orElseThrow(() -> new UsernameNotFoundException("User not found " + username)); 
	}

//	public String addUser(UserInfo userInfo) {
//		// TODO Auto-generated method stub
//		return null;
//	} 

	public String addUser(com.iib.gov.entity.vchvsEntityOld.InsurerInfo userInfo) { 
		
		System.out.println("sanu"+userInfo);
		
		userInfo.setPassword(encoder.encode(userInfo.getPassword())); 
		
		System.err.println(userInfo.getInsurercode());
		
		if(Arrays.asList("556","545","132","123","115","106","103","141","137","134",
				"90","58","113","108","149","144","150","152","102","146","155","158","159","157").contains(userInfo.getInsurercode())) {
			
		
		
		
	
		Integer count = repository.findByUsername(userInfo.getUsername());
		System.err.println(count);
		if(count==0) {
			
			System.out.println("if block calling");
			
			repository.save(userInfo); 
			return "User Added Successfully"; 
			
			
			
		}
		
		return "User already Added "; 
	} 
	
	else {
		return "Insurer code doesn't match with IIB Insurer code master.";
	}

	}
} 

