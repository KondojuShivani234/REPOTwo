package com.shiv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shiv.entity.EligibilityDetailsEntity;

public interface EligDtlsRepository extends JpaRepository<EligibilityDetailsEntity, Integer>{

	
	@Query("Select distinct(planName) from EligibilityDetailsEntity")
	public List<String> getUniquePlans();
	@Query("Select distinct(planStatus) from EligibilityDetailsEntity")
	public List<String> getUniqueStatus();
}
