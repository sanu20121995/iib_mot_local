package com.iib.gov.repo.old;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iib.gov.entity.vchvsEntityOld.Vchvs_hits_details;

@Repository
public interface Vchvs_hit_repo extends JpaRepository<Vchvs_hits_details, Integer> {

}
