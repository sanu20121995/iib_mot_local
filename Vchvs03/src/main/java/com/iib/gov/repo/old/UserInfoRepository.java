package com.iib.gov.repo.old;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iib.gov.entity.vchvsEntityOld.InsurerInfo;



@Repository
public interface UserInfoRepository extends CrudRepository<InsurerInfo, Integer>{ 
	
	@Query(value = "select * from Insurer_Info where username=:username", nativeQuery = true)
	public Optional<InsurerInfo> findByicode(String username); 
	
	
	@Query(value = "select count(*) from Insurer_Info where username=:username", nativeQuery = true)
	public Integer findByUsername(String username); 
}


//@Repository
//public interface UserInfoRepository extends JpaRepository<UserInfo, Object>{
//	
//}

