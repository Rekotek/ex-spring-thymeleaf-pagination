package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by taras on 20.01.17.
 */

@Entity
public class Person
{
    @GeneratedValue
    @Id
    private Long id;

    private String surname;
    private String name;
    private String secondName;
    private int age;

    public Person()
    {
    }

    public Person(String surname, String name, String secondName, int age)
    {
        id = -1L;
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.age = age;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSecondName()
    {
        return secondName;
    }

    public void setSecondName(String secondName)
    {
        this.secondName = secondName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
