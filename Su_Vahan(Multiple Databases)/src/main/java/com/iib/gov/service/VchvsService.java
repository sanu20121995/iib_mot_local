package com.iib.gov.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iib.gov.entity.vcvhsentity.VchvsEntity;
import com.iib.gov.entity.vcvhsentity2.VchvsEntity2;
@Service
public interface VchvsService {
	
	public List<VchvsEntity> getAllDetails(String chassisno);

	public List<VchvsEntity2> getAllDetails2(String chassisno);

}
