package com.iib.gov.repo.vcvhsrepo2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iib.gov.entity.vcvhsentity2.VchvsEntity2;

@Repository
public interface VchvsRepo2 extends JpaRepository<VchvsEntity2, Integer> {
	
//	@Query("from FruadEntity where input_inserted_date=:input_inserted_date and a_TXT_INSURER=:a_TXT_INSURER")
	
	@Query(value="select * from IIW_MOT_PUBLIC_SEARCH_2021 with(nolock) where TXT_CHASSIS_NUMBER=:chassisno"
			
			,nativeQuery = true)
	public List<VchvsEntity2> getalldata2(String chassisno);

}
