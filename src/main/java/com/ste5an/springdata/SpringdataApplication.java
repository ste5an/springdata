package com.ste5an.springdata;

import com.ste5an.springdata.entity.Person;
import com.ste5an.springdata.jdbc.PersonJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class SpringdataApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataApplication.class, args);
	}

	@Autowired
	PersonJdbcDao personJdbcDao;

	@Override
	public void run(String... args) throws Exception {

		Person anna = new Person( "Steve", "Jobs", "San Diego");
		Person david = new Person( "David", "Backhand", "London");
		Person alex = new Person( "Alex", "Clark", "Boston");

		personJdbcDao.insert(anna);
		personJdbcDao.insert(david);
		personJdbcDao.insert(alex);

		System.out.println("<<<<<<<<" + personJdbcDao.findAll());
	}
}