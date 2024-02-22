package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.exceptions.ResourceNotFountException;
import com.example.demo.repos.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository personrepo;
	
	
	public Person saveData(Person person) {
		Person pr=personrepo.save(person);
		return pr;
	}


	
	public Person getPersonById(Long id) {
		
		return personrepo.findById(id).orElseThrow(()->new ResourceNotFountException("person is not found"));
	}

}
