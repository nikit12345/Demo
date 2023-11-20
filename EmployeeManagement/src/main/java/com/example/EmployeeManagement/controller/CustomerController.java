package com.example.EmployeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagement.Entity.Customer;
import com.example.EmployeeManagement.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customer")

public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/get")
	public List<Customer> findAll(){
		return service.findAll();
		}
	
	@GetMapping("get/{name}")
	public Customer findByName(@PathVariable String name) {
		return service.findBycustomername(name);
		
	}
	
	@PostMapping("/post")
	public Customer saveCust(@RequestBody Customer cust) {
		return service.saveCust(cust);
		
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Customer> updateCustome 	(@RequestBody Customer c, @PathVariable int id){
		return new ResponseEntity<Customer>(service.updateCustomer(id, c)
				, HttpStatus.CREATED);
		
	}
    @DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
		return new ResponseEntity<String>(service.deleteCust(id),HttpStatus.OK);
		
	}
	
}
