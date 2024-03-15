package com.example.demo.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Person;

public interface PersonService {
	
	public Person savePerson(Person person);
	
	public List<Person> getAllPerson();
	
	public Person getPersonById( Long id);
	
	public Person updatePersonById(  Long id, Double salary);



}
