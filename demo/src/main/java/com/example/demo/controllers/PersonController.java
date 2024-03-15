package com.example.demo.controllers;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.exceptions.ResourceNotFountException;
import com.example.demo.services.PersonService;

import jakarta.annotation.Generated;

@RequestMapping("api")
@RestController
public class PersonController {
	@Autowired
	private PersonService service;
	
	@PostMapping("/savePerson")
	public ResponseEntity<Person> savePerson(@RequestBody Person person){
		Person person1 = service.savePerson(person);
		return new ResponseEntity<>(person1,HttpStatus.CREATED);
	}
	
	@GetMapping("/getPerson")
	public List<Person> getAllPerson(){
		List<Person> p = service.getAllPerson();
		return p;
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
		Person p = service.getPersonById(id);
		return new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("updatePerson/{id}")
	public Person updatePersonById(@PathVariable Long id, @PathVariable Double salary) {
		return service.updatePersonById(id, salary);
	}


}
