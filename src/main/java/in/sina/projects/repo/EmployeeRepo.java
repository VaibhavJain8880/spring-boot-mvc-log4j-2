package in.sina.projects.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sina.projects.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
