package com.gosmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gosmart.repository.entity.BranchEntity;
import com.gosmart.service.BranchService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class BranchController {
	@Autowired
	private BranchService branchService;
	
	@PostMapping("/branch/save")
	public ResponseEntity<Integer> insertBranch(@RequestBody BranchEntity branchEntity)
	{
		try {
			Integer branchId=branchService.insertBranch(branchEntity);
			return new ResponseEntity<>(branchId,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
