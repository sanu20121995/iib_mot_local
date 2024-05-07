package com.iib.gov.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iib.gov.entity.vcvhsentity.VchvsEntity;
import com.iib.gov.entity.vcvhsentity2.VchvsEntity2;
import com.iib.gov.repo.vcvhsrepo.VchvsRepo;
import com.iib.gov.repo.vcvhsrepo2.VchvsRepo2;
@Service
public class VchvsServiceImpl implements VchvsService {
	
	@Autowired
	private VchvsRepo repository;
	
	@Autowired
	private VchvsRepo2 repository2;

	@Override
	public List<VchvsEntity> getAllDetails(String chassisno) {
		// TODO Auto-generated method stub
		return repository.getalldata(chassisno);
	}

	@Override
	public List<VchvsEntity2> getAllDetails2(String chassisno) {
		// TODO Auto-generated method stub
		return repository2.getalldata2(chassisno);
	}

}
