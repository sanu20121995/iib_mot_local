package com.iib.gov.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iib.gov.entity.Vchvs_User_Details;

public interface CustomerRepo extends JpaRepository<Vchvs_User_Details, Integer> {
	
	Vchvs_User_Details findByUsername(String username);

}
