package com.rabindra.springdemo.cruddemo.service;

import java.util.List;
import java.util.Optional;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rabindra.springdemo.cruddemo.dao.EmployeeRepository;
//import com.rabindra.springdemo.cruddemo.dao.EmployeeDAO;
import com.rabindra.springdemo.cruddemo.entity.Customer;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	//because we're usign jpa repository for db connection we removed @Transactional 
	//from each of the following method
	
	//inject the repository
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Customer> getAll() {
		return employeeRepository.findAll();
	}

	

	@Override
	public Customer getEmployeeById(int employeeId) {
		
		Optional<Customer> result=   employeeRepository.findById(employeeId);
		
		Customer theEmployee= null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Did not find the employee id" +employeeId);
		}
		
		return theEmployee;
	}



	@Override
	public List<Customer> getCustomerByLastname(String firstName) {
		
		return employeeRepository.getCustomerByLastname(firstName);
		
	}
	
	
	@Override
	public List<Customer> getCustomerHavingNameRoshan() {
		
		return employeeRepository.findCustomersWithFirstNameRoshan();
		
	}
	

}
