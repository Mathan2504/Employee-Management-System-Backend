package mini_project.ems_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mini_project.ems_backend.entity.Employee;
import mini_project.ems_backend.exception.NotFoundException;
import mini_project.ems_backend.service.EmpService;
@CrossOrigin(origins = "https://employee-management-system-backend-1-osnv.onrender.com")
@RestController
@RequestMapping("/api/emp")

public class EmpController {
	
	
	@Autowired
	private EmpService empSer;
	
	@PostMapping
	public ResponseEntity<Employee> createEmp(@RequestBody Employee e)
	{
		return empSer.createEmp(e);
	}
	
	
	@GetMapping
	public Employee getById(@RequestParam long id){
		
		return empSer.getById(id);
			
		}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id)
	{
		
			return empSer.delete(id);
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody Employee e,@PathVariable long id)
	{
	
			return empSer.update(e,id);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAll() {

	    return empSer.getAll();

	   
	}

}
