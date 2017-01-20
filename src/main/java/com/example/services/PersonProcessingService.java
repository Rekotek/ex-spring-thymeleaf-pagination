package com.example.services;

import com.example.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * Created by taras on 20.01.17.
 */

@Service
public interface PersonProcessingService
{
    Page<Person> getPersons(int forPage, int withPageSize);

    Iterable<Person> getPersons();

    long getAllCount();
}
