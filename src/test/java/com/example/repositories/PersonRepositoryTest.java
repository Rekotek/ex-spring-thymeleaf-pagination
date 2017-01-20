package com.example.repositories;

import com.example.entities.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by taras on 20.01.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest
{

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void initialQuantity()
    {
        long count = personRepository.count();

        assertTrue(count > 0);
    }

    @Test
    public void findPersonBySurname()
    {
        List<Person> persons = (List<Person>) personRepository.findBySurname("Водкин");

        assertTrue(persons.size() > 0);
        assertEquals("Водкин", persons.get(0).getSurname());
    }
}
