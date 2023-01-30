package com.rabindra.springdemo.cruddemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rabindra.springdemo.cruddemo.entity.Customer;

@Repository
public interface EmployeeRepository extends JpaRepository<Customer, Integer> {

	//that's it ........no need to write any code.........
	
	//this query 1 gave error saying unexpected token * near query ....
	
	//REASON: use of the wildcard character (*) in the SELECT statement. 
	//It's not supported in JPQL (Java Persistence Query Language)
	//which is used by the JPA (Java Persistence API) to perform database operations. 
	//Instead of using *, specify the specific columns you want to select from the table.
	
	//1----@Query(value="SELECT * FROM QueryAnnotPracJPA.customer where customer.first_name='roshan'")
	//public List<Customer> getCustomerByLastname(String firstName);
	
//	NO NEED TO USE FULLY QUALIFIED NAME JUSE USE ENITY CLASS NAME IN QUERY FOR TABLE NAME
	//@Query("SELECT c FROM QueryAnnotPracJPA.customer c WHERE c.first_name = :firstName")
	@Query("SELECT c FROM Customer c WHERE c.firstName = :firstName")
	public List<Customer> getCustomerByLastname(@Param("firstName") String firsttName);
	
	//@Query("SELECT c FROM Customer c WHERE c.firstName = 'roshan'")
	//FOR CASESENSITIVE SEARCH FOR 'Roshan' only coz by acc. to above query it gives 
	//all the customers whose first name starts with roshan', 'Roshan', and 'rOshan', etc.
	
	//SO , CAUTION:::::For case sensitive search 
	//you can specify the binary collation like this:
	
	//Also giving more space between clause doesnot affect either 
	//REASON:
	//Below query perfectly works
//	@Query("SELECT c FROM Customer c WHERE        c.firstName = 'roshan'")
	
	//You can modify the query to include leading and trailing spaces, like this:
	//@Query(value = "SELECT * FROM customer WHERE BINARY TRIM(customer.first_name) = 'roshan'", nativeQuery = true)
	
	@Query(value = "SELECT * FROM customer WHERE BINARY first_name = 'roshan'", nativeQuery = true)
	List<Customer> findCustomersWithFirstNameRoshan();

}

