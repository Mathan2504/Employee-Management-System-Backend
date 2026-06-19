package mini_project.ems_backend.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import mini_project.ems_backend.exception.*;
import mini_project.ems_backend.entity.Employee;
import mini_project.ems_backend.repository.EmpRepository;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepository empRepo;
	
	public ResponseEntity<Employee> createEmp(Employee e)
	{
		return new ResponseEntity<Employee>(empRepo.save(e),HttpStatus.CREATED);
	}
	
	public Employee getById(long id){
		
	return empRepo.findById(id).orElseThrow(()->new NotFoundException("id not found"));
		
	}
	
	public ResponseEntity<String> delete(long id)
	{
		Optional<Employee> ou=empRepo.findById(id);
		
		if(ou.isPresent()) {
			empRepo.deleteById(id);
			return new ResponseEntity<String>("Data Deleted",HttpStatus.NO_CONTENT);
		}else
		{
			throw new NotFoundException("Id not found");
		}
	}
		
		public ResponseEntity<String> update(Employee newEmp,long id)
		{
			Optional<Employee> u=empRepo.findById(id);
			
			if(u.isPresent())
			{
				Employee exEmp=u.get();
				exEmp.setFirstName(newEmp.getFirstName());
				exEmp.setLastName(newEmp.getLastName());
				exEmp.setEmail(newEmp.getEmail());
				empRepo.save(exEmp);
				return new ResponseEntity<String>("Data Updated",HttpStatus.OK);
			}else
			{
				throw new NotFoundException("Id not found");
			}
			}
		public ResponseEntity<List<Employee>> getAll() {

		    List<Employee> employees = empRepo.findAll();

		    if (employees.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.OK); // 204
		    }

		    return ResponseEntity.ok(employees);
		}
			
		}
	

	
	
	


