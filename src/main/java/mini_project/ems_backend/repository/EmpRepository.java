package mini_project.ems_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mini_project.ems_backend.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Long> {
	
	

}
