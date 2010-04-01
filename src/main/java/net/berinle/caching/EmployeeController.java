package net.berinle.caching;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

	private static Logger log = Logger.getLogger(EmployeeController.class);
	
	@Autowired private EmployeeService employeeService;	
	
	@RequestMapping(value="/paging", method=RequestMethod.GET)
	public void paging(Model model){
	
		log.debug("paging called.");
		List<Employee> employees = employeeService.getEmployees();
		model.addAttribute("employees", employees);		
	}
}
