package com.accenture.lkm.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.Employee;
import com.accenture.lkm.service.EmployeeServiceImpl;

@RestController
// extends @Controller
// object are automatically converted to JSON or XML
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	
	
	@RequestMapping(value="emp/controller/getDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> getEmployeeDetails(){
		Collection <Employee> listEmployee = employeeService.getEmployeeDetails();
		System.out.println(listEmployee);
		return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
	}
	
	@RequestMapping(value="emp/controller/getDetailsById/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeDetailByEmployeeId(@PathVariable("id") int myId){
		Employee employee = employeeService.getEmployeeDetailByEmployeeId(myId);
		
		if(employee!=null)
		{
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/emp/controller/addEmp",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		int id= employeeService.addEmployee(employee);
		System.out.println("[id]:"+id);
		return new ResponseEntity<String>("Employee added successfully with id:"+id,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/emp/controller/updateEmp",
			method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee employee2= employeeService.updateEmployee(employee);
		if(employee2==null){
			return new ResponseEntity<Employee>(employee2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println(employee);
		return new ResponseEntity<Employee>(employee2,HttpStatus.OK);
	}
	@RequestMapping(value="/emp/controller/deleteEmp/{id}",
			method=RequestMethod.DELETE,
			//consumes=MediaType.TEXT_PLAIN_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int myId){
		Employee employee= employeeService.deleteEmployee(myId);
		if(employee==null){
			return new ResponseEntity<Employee>(employee,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println("Removed: "+employee);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	//query method
		//http://localhost:8090/emp/controller/getDetails/dept=101,sal=11000 
		@RequestMapping(value="emp/controller/getDetails/dept={v1},sal={v2}",method=RequestMethod.GET,
														produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Collection<Employee>> getAllEmployeeFromDepartmentGTSalary(@PathVariable("v1")Integer departmentCode,@PathVariable("v2")double salary){
			Collection <Employee> listEmployee = employeeService.getAllEmployeeFromDepartmentGTSalary(departmentCode,salary);
			System.out.println(listEmployee);
			return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
		}
		
		//http://localhost:8090/emp/controller/getDetailsOrderByDeptDesc
		@RequestMapping(value="emp/controller/getDetailsOrderByDeptDesc",method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Collection<Employee>> getEmployeeDetailsOrderByDepartmentCodeDesc(){
			Collection <Employee> listEmployee = employeeService.getEmployeeDetailsOrderByDepartmentcodedesc();
			System.out.println(listEmployee);
			return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
		}
		
		//http://localhost:8090/emp/controller/getDetailsEmpNamePatternOrderByDeptDesc/J
		@RequestMapping(value="emp/controller/getDetailsEmpNamePatternOrderByDeptDesc/{patt}",method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Collection<Employee>> findByEmployeeNameContainingOrderByDepartmentCodeDesc(@PathVariable("patt") String pattern){
			Collection <Employee> listEmployee = employeeService.findByEmployeeNameContainingOrderByDepartmentCodeDesc(pattern);
			System.out.println(listEmployee);
			return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
		}
		
		//http://localhost:8090/emp/controller/getDetailsBetweenDept/param1=101--param2=102	
		@RequestMapping(value="emp/controller/getDetailsBetweenDept/param1={v1}--param2={v2}",method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Collection<Employee>> findByDepartmentCodeGreaterThanEqualAndLessThanEqual(@PathVariable("v1") Integer var1,@PathVariable("v2") Integer var2){
			Collection <Employee> listEmployee = employeeService.findByDepartmentCodeGreaterThanEqualAndLessThanEqual(var1,var2);
			System.out.println(listEmployee);
			return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
		}
		
		//http://localhost:8090/emp/controller/getDetailsBetweenDept2/param1=101--param2=102
		@RequestMapping(value="emp/controller/getDetailsBetweenDept2/param1={v1}--param2={v2}",method=RequestMethod.GET,
		produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Collection<Employee>> findByDepartmentBetween(@PathVariable("v1") Integer var1,@PathVariable("v2") Integer var2){
			Collection <Employee> listEmployee = employeeService.findByDepartmentBetween(var1,var2);
			System.out.println(listEmployee);
			return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
		}
		
		//http://localhost:8090/emp/controller/getDetailsSalary/20000
		@RequestMapping(value="emp/controller/getDetailsSalary/{sal}",method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Collection<Employee>> getAllEmployeesBySalary(@PathVariable("sal")Double salary ){
			Collection <Employee> listEmployee = employeeService.getAllEmployeesBySalary(salary);
			System.out.println(listEmployee);
			return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
		}
		
		
		//http://localhost:8090/emp/controller/getEmployeeCountDept
		@RequestMapping(value="emp/controller/getEmployeeCountDept",method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Collection> getDeptCodesAndCountOfEmployee(){
			Collection listEmployee = employeeService.getDeptCodesAndCountOfEmployee();
			System.out.println(listEmployee);
			return new ResponseEntity<Collection>(listEmployee, HttpStatus.OK);
		}
	
}
