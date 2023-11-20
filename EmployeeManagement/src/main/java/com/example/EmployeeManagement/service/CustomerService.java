package com.example.EmployeeManagement.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagement.Entity.Customer;
import com.example.EmployeeManagement.repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo repo;
	
	public List<Customer> findAll(){
		return (List<Customer>) repo.findAll();
	}
	
	public Customer findBycustomername(String customername) {
		
		return repo.findBycustomername(customername).orElseThrow((
				)-> new RuntimeException("customer not found"));
		
	}
	
	public Customer saveCust(Customer cust) {
		return repo.save(cust);
	}
	
	public Customer updateCustomer(int id, Customer cust) {
		Customer existingCust = repo.findById(id).orElseThrow(()-> 
		new RuntimeErrorException(  null, "no customer available with id"+id));
		
		if(cust.getCustomername()!=null)
			existingCust.setCustomername(cust.getCustomername());
		
		if(cust.getCustomeraddress()!=null)
			existingCust.setCustomeraddress(cust.getCustomeraddress());
		
		if(cust.getMobile()!=null)
			existingCust.setMobile(cust.getMobile());
			
		
		
		return repo.save(existingCust);
		
	}
	
	public String deleteCust(int id) {
		Customer existingCust = repo.findById(id).orElseThrow(()-> 
		new RuntimeErrorException(  null, "no customer available with id"+id));
		repo.deleteById(id);
		return "product deleted";
		
	}
}
