package com.example.demo.services;

import com.example.demo.entity.Person;

public interface PersonService {

	Person saveData(Person person);

	Person getPersonById(Long id);

}
