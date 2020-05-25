package com.ste5an.springdata;

import com.ste5an.springdata.entity.Person;
import com.ste5an.springdata.jdbc.PersonJdbcDao;
import com.ste5an.springdata.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringdataJPAApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataJPAApplication.class, args);
	}

	@Autowired
	PersonRepository personRepository;


	@Override
	public void run(String... args) throws Exception {

		Person anna = new Person( "Bob", "Jobs", "San Diego");
		Person david = new Person( "David", "Backhand", "London");
		Person alex = new Person( "Alex", "Clark", "Boston");

		List<Person> people = Arrays.asList(anna, david, alex);

		personRepository.saveAll(people);

		System.out.println(personRepository.findAll());
	}
}
