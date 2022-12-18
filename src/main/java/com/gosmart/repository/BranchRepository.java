package com.gosmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gosmart.repository.entity.BranchEntity;

public interface BranchRepository extends JpaRepository<BranchEntity, Integer>{
	
}
