package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.exceptions.InvalidDataException;
import com.example.demo.exceptions.ResourceNotFountException;
import com.example.demo.repos.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository pRepo;

	@Override
	public Person savePerson(Person person) {
	   Person p = pRepo.save(person);
		return p;
	}

	@Override
	public List<Person> getAllPerson() {
		List<Person> p = pRepo.getAllPerson();
		p.forEach(System.out::println);
		return p;
	}

	@Override
	public Person getPersonById(Long id) {
		Person persn = pRepo.getPersonById(id);
		if(persn==null) {
			throw new ResourceNotFountException("person with "+id+" is not present");
		}
		return persn;
	}

	@Override
	public Person updatePersonById(Long id, Double salary) {
		return pRepo.updatePersonById(id, salary);
	}
	
	
}

     
	



	

