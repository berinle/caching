package net.berinle.caching;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

	@Autowired private EmployeeService employeeService;
	
	@RequestMapping(value="/app/paging", method=RequestMethod.GET)
	public void paging(Model model){
	
		List<Employee> employees = employeeService.getEmployees();
		model.addAttribute("employees", employees);
	}
}
