package com.accenture.ui;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.accenture.dao.EmployeeDAO;
import com.accenture.entity.EmployeeEntityBean;
import com.accenture.resource.JavaConfig;

public class UITester1 {

	public static void main(String[] args) {
		
		EmployeeDAO employeeDAOIMPL=null;
		try{
			
			AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
			employeeDAOIMPL = (EmployeeDAO) applicationContext.getBean("employeeDAO");
			
			//1 FindAll
			findAll(employeeDAOIMPL);

			applicationContext.close();
				
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	
	
	public static void findAll(EmployeeDAO daoimpl) {

		try {
			List<EmployeeEntityBean> list = new ArrayList<>();
			
			Sort sort = new Sort(new Sort.Order(Direction.ASC, "name"));
			Pageable pageable = new PageRequest(0, 5, sort);
			
			daoimpl.findAll(pageable).forEach(e -> list.add(e));
			for(EmployeeEntityBean bean:list){
				System.out.println(bean);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}