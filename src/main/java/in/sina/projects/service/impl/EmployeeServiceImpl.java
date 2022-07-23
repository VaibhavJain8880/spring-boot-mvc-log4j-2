package in.sina.projects.service.impl;

import java.util.List;
import java.util.Optional;



import in.sina.projects.entity.Employee;
import in.sina.projects.excetion.EmployeeNotFoundException;
import in.sina.projects.repo.EmployeeRepo;
import in.sina.projects.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

	private EmployeeRepo repo;
	@Override
	public Integer saveEmployee(Employee emp) {
		emp = repo.save(emp);
		return emp.getEmpId();
	}

	@Override
	public void updateEmployee(Employee emp) {
		if(emp.getEmpId()==null || !repo.existsById(emp.getEmpId())) {
			throw new EmployeeNotFoundException(emp.getEmpId() +"-not exist");}
			else {
				repo.save(emp);
			}

	}

	@Override
	public void deleteEmployee(Integer id) {
		repo.delete(getOneEmployee(id));

	}

	@Override
	public Employee getOneEmployee(Integer id) {
		Optional<Employee>opt=repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new EmployeeNotFoundException(id+"-not exist");
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee>list=repo.findAll();
		return list;
	}

}
