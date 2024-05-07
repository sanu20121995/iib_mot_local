package com.iib.gov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.iib.gov.entity.Vchvs_User_Details;
import com.iib.gov.repo.CustomerRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private CustomerRepo customerRepo;
    
   

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Vchvs_User_Details user = customerRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        
      
        UserDetails userdetails = User
        		.withUsername(user.getUsername())
        		
        		.password(user.getPassword())
        		
        		.authorities("USER").build();
        
       
        
   
        return userdetails;
    }
 
}