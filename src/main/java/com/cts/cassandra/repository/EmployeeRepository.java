package com.cts.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.cassandra.model.Employee;

@Repository
public interface EmployeeRepository extends CassandraRepository<Employee, Integer>{

	@AllowFiltering
	public Employee findById(int ID);
	
	@Query(value="SELECT * FROM employee")
	public List<Employee> findAll();
	
	@Query(value="SELECT * FROM employee where dept=?0 ALLOW FILTERING")
	public List<Employee> findEmployeeByDept(String dept);
}
