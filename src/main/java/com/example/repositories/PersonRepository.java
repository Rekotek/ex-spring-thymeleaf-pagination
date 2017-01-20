package com.example.repositories;

import com.example.entities.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by taras on 20.01.17.
 */

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>
{
    Iterable<Person> findBySurname(String surname);
}
