package com.cts.cassandra.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.cassandra.model.Employee;
import com.cts.cassandra.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	EmployeeRepository repository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return repository.findAll();
	}
	
	@GetMapping("/employeesByDept/{dept}")
	public List<Employee> getEmployeesByDept(@PathVariable("dept") String dept){
		return repository.findEmployeeByDept(dept);
	}
	
	@PostMapping(path="/employees/create" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee customer) {
		LOGGER.info("Create Employee: " + customer.getFirstname() + "...");
 
		Employee emp = repository.save(customer);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
 
	@PutMapping(path="/employees/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		LOGGER.info("Update Employee with ID = " + id + "...");
 
		Employee emp = repository.findById( id);
		if (emp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		emp.setFirstname(employee.getFirstname());
		emp.setLastname(employee.getLastname());
		emp.setDept(employee.getDept());
		Employee updatedcustomer = repository.save(emp);
		return new ResponseEntity<>(updatedcustomer, HttpStatus.OK);
	}
 
	@DeleteMapping(path="/employees/{id}" , consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
		LOGGER.info("Delete Employee with ID = " + id + "...");
		repository.deleteById( id);
		return new ResponseEntity<>("Employee has been deleted!", HttpStatus.OK);
	}
 
}
