package in.sina.projects.service;

import java.util.List;

import in.sina.projects.entity.Employee;

public interface IEmployeeService {

	Integer saveEmployee(Employee emp);
	void updateEmployee(Employee emp);
	void deleteEmployee(Integer id);
	Employee getOneEmployee(Integer id);
	List<Employee> getAllEmployee();
}
