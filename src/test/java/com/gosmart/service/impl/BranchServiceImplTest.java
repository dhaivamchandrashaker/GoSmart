package com.gosmart.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.repository.BranchRepository;
import com.gosmart.repository.entity.BranchEntity;

@RunWith(SpringJUnit4ClassRunner.class)
public class BranchServiceImplTest {
	@InjectMocks
	private BranchServiceImpl  service;
	@Mock
	private BranchRepository repository;
	@Test
	public void testInsertBranch() throws Exception{
		BranchEntity branchEntity=new BranchEntity();
		BranchEntity branchEntity2=new BranchEntity();
		when(repository.save(branchEntity)).thenReturn(branchEntity2);
		Integer branchId=service.insertBranch(branchEntity);
		assertNull(branchId);
		
	}
	@Test(expected = Exception.class)
	public void testInsertBranch_Exception() throws Exception{
		BranchEntity branchEntity=new BranchEntity();
		when(repository.save(branchEntity)).thenThrow(NullPointerException.class);
		service.insertBranch(branchEntity);
		
	}
	
	
}
