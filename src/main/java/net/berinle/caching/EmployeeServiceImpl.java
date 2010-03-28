package net.berinle.caching;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired EmployeeDao employeeDao;
	
	public List<Employee> getEmployees(){
		//TODO: check cache first before calling DAO
		return employeeDao.getEmployees();		
	}
}
