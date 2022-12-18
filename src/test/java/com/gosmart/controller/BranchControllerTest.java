package com.gosmart.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.repository.entity.BranchEntity;
import com.gosmart.service.BranchService;

@RunWith(SpringJUnit4ClassRunner.class)
public class BranchControllerTest {
	@InjectMocks
	private BranchController branchController;
	@Mock
	private BranchService  service;
	@Test
	public void testInsertBranch() throws Exception{
		BranchEntity branchEntity=new BranchEntity();
		
		Integer branchId=1;
		when(service.insertBranch(branchEntity)).thenReturn(branchId);
		
		ResponseEntity<Integer> responseEntity=branchController.insertBranch(branchEntity);
		assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
		
	}
	
	@Test
	public void testInsertBranch_Exception() throws Exception{
		BranchEntity branchEntity=new BranchEntity();
		
		when(service.insertBranch(branchEntity)).thenThrow(NullPointerException.class);
		
		ResponseEntity<Integer> response=branchController.insertBranch(branchEntity);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
		
	}
	
	
	@Test
	public void testGetALLBranches() throws Exception{
		List<BranchEntity> branchList=new ArrayList<>();
		
		when(service.getAllBranches()).thenReturn(branchList);
		ResponseEntity<List<BranchEntity>> response=branchController.getAllranches();
		assertEquals(HttpStatus.OK,response.getStatusCode());
		
	}
	@Test
	public void testGetALLBranches_Exception() throws Exception{
		List<BranchEntity> branchList=new ArrayList<>();
		
		when(service.getAllBranches()).thenThrow(NullPointerException.class);
		ResponseEntity<List<BranchEntity>> response=branchController.getAllranches();
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
		
	}
}
