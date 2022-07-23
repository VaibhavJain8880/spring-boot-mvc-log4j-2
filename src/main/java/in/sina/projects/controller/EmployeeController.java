package in.sina.projects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.sina.projects.entity.Employee;
import in.sina.projects.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	//1.show Register page
	@GetMapping("/register")
	public String showReg() {
		return "EmployeeRegister";
	}
	//2.Read Form data and save(on submit)
	@PostMapping("/save")
	public String saveEmp(
			@ModelAttribute Employee employee,
			Model model
			) {
		Integer id = service.saveEmployee(employee);
		String msg = "Employee '"+id+"' create! ";
		model.addAttribute("message", msg);
		return "EmployeeRegister";
	}
	//3.show all Employees
	@GetMapping("/all")
	public String viewAll(Model model) {
		List<Employee>list = service.getAllEmployee();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
}
