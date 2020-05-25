package com.ste5an.springdata.repository;

import com.ste5an.springdata.entity.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    void findByFirstName() throws Exception {

        List<Person> people = personRepository.findByFirstName("Bob");

        assertThat(people).hasSize(1);
        assertThat(people.get(0).getLastName()).isEqualTo("Jobs");
    }
}