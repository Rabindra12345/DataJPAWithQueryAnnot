package com.rabindra.springdemo.cruddemo.service;

import java.util.List;

import com.rabindra.springdemo.cruddemo.entity.Customer;


public interface EmployeeService {
	

	public List<Customer> getAll();
	
	public Customer getEmployeeById(int employeeId);
	
	public List<Customer> getCustomerByLastname(String firstName);
	
	public List<Customer> getCustomerHavingNameRoshan();

	
//	List<User> findUserByEmails(Set<String> emails);
//    
//    List<User> findAllUsersByPredicates(Collection<Predicate<User>> predicates);
	
}
