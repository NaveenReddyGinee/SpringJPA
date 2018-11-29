package com.accenture.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.accenture.entity.EmployeeEntityBean;

public interface EmployeeDAO extends PagingAndSortingRepository<EmployeeEntityBean, Integer>{
	

}
