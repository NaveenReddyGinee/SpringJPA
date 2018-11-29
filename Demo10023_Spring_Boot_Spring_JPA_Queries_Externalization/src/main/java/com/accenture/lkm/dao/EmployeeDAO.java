package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.lkm.entity.EmployeeEntity;

public interface EmployeeDAO  extends JpaRepository<EmployeeEntity, Integer>
{
	
	List<EmployeeEntity> findBySalaryGreaterThanEqual(double salary);
	List<EmployeeEntity> findByDepartmentCodeAndSalaryGreaterThanEqual(Integer department,double salary);
	List<EmployeeEntity> findAllByOrderByDepartmentCodeDesc ();
	//like
	List<EmployeeEntity> findByEmployeeNameContainingOrderByDepartmentCodeDesc (String pattern);
	List<EmployeeEntity> findByDepartmentCodeGreaterThanEqualAndDepartmentCodeLessThanEqual(Integer param1, Integer param2);List<EmployeeEntity> findByDepartmentCodeBetween(Integer param1, Integer param2);

	@Query(name="EmployeeDAO.getAllEmployeesBySalary")
	List<EmployeeEntity> getAllEmployeesBySalary(Double salary);
	
	@Query(name="EmployeeDAO.getDeptCodesAndCountOfEmployee") 
	List getDeptCodesAndCountOfEmployee();
	// if @query is not having a valid query then 
	// then method signature is checked for the query method approach and translation 

}
