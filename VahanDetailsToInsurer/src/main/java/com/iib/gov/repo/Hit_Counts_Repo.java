package com.iib.gov.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iib.gov.model.Udayan_hits_details;

public interface Hit_Counts_Repo extends JpaRepository<Udayan_hits_details, Integer>  {
	
	@Query( value="select count(*) from udayan_hits_testing with(nolock) where usernamne=:username", nativeQuery = true  )
	public Integer getCount(String username);
	
	
	

}
