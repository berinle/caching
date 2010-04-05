package net.berinle.caching;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
	List<Employee> getEmployees();

	void addEmployee(Employee employee);

	Map getEmployees(int startIndex);
}
