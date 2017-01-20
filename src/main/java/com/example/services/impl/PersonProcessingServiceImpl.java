package com.example.services.impl;

import com.example.entities.Person;
import com.example.repositories.PersonRepository;
import com.example.services.PersonProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by taras on 20.01.17.
 */

@Service
public class PersonProcessingServiceImpl implements PersonProcessingService
{
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Page<Person> getPersons(int forPage, int withPageSize)
    {
        return personRepository.findAll(new PageRequest(forPage, withPageSize));
    }

    @Override
    public Iterable<Person> getPersons()
    {
        return personRepository.findAll();
    }

    @Override
    public long getAllCount()
    {
        return personRepository.count();
    }
}
