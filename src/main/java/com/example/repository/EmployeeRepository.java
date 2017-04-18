package com.example.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.model.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	
	public List<Employee> findByFirstName(@Param("firstName") String firstName);

}
