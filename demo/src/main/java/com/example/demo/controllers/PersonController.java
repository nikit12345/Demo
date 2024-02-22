package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.services.PersonService;

@RequestMapping("api")
@RestController
public class PersonController {
	
	
	@Autowired
	private PersonService service;
	
	@PostMapping("post")
	public ResponseEntity<Person> savePerson(@RequestBody Person person){
		
		Person per=service.saveData(person);
		return new ResponseEntity<>(per,HttpStatus.CREATED);
		
	}
	
	@GetMapping("getByid/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable Long id){
		
		Person pp=service.getPersonById(id);
		return new ResponseEntity<>(pp,HttpStatus.OK);
	}
	


}
