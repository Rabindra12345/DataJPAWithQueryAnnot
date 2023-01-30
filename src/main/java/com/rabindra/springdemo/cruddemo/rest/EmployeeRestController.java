package com.rabindra.springdemo.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.rabindra.springdemo.cruddemo.dao.EmployeeDAO;
import com.rabindra.springdemo.cruddemo.entity.Customer;
import com.rabindra.springdemo.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	//inject the DAO 
	@Autowired
	private EmployeeService employeeService;
	
	//expose the endpoint for the /employees
	
	@GetMapping("/employees")
	public List<Customer> getAll(){
		
		return employeeService.getAll();
	}
	
	@GetMapping("employees/{employeeId}")
	public Customer getEmployee(@PathVariable int employeeId){
		
		Customer theEmployee = employeeService.getEmployeeById(employeeId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return theEmployee;
	}
	
	@GetMapping("employees/{firstName}")
	public List <Customer> getEmployeeByFirstName(@PathVariable String firstName) {
		List <Customer> theCustomer = employeeService.getCustomerByLastname(firstName);
		return theCustomer;
		
	}
	
	//coz here i m trying to access those users whose firstname is roshan
	// and i have included that name in the query itself so there is no need to pass 
	//roshan as an argument from out method so no need of using pathvariable and stuffs
	@GetMapping("employees/roshan")
	public List <Customer> getEmployeeWHosNameIsRoshan() {
		List <Customer> theCustomer = employeeService.getCustomerHavingNameRoshan();
		return theCustomer;
			
	}
	
}
