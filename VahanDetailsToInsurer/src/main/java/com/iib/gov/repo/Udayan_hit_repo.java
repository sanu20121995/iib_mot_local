package com.iib.gov.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iib.gov.model.Udayan_hits_details;

@Repository
public interface Udayan_hit_repo extends JpaRepository<Udayan_hits_details, Integer> {

}
