package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;

import jakarta.transaction.Transactional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	@Query("select p from Person p")
	public List<Person> getAllPerson();
	
	@Query("select p from Person p where p.id =:i")
	public Person getPersonById(@Param("i") Long id);
	
	@Query(value="update Person p set p.name =:name, p.salary =:salary where p.id =:id" )
	public Person updatePersonById( @Param("id") Long id, @Param("salary") Double salary);
}
