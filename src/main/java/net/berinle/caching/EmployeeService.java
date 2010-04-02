package net.berinle.caching;

import java.util.List;

public interface EmployeeService {
	List<Employee> getEmployees();

	void addEmployee(Employee employee);
}
