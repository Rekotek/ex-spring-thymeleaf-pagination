package com.example;

import com.example.entities.Person;
import com.example.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by taras on 20.01.17.
 */

@Component
public class DataInitializer
{
    private final String[] SURNAMES = {
            "Водкин", "Коньяков", "Винокуров", "Пивоваров", "Самогонкин", "Хреновухин",
            "Перцовочка", "Бородинский", "Чача", "Кальвадосов"
    };

    private final String[] NAMES = {
            "Тимофей", "Дормидонт", "Феофил", "Иоанн", "Макарий", "Епифан", "Филипп", "Пересвет",
            "Ослабля", "Христофор"
    };

    private final String[] SECOND_NAMES = {
            "Христофорович", "Изяславович", "Перегонович", "Змеевекович", "Ростиславович",
            "Никифорович", "Преферансович"
    };

    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    public void initData()
    {
        List<Person> personList = new ArrayList<>();

        Random randomAge = new Random(System.currentTimeMillis());

        for (String surname : SURNAMES) {
            for (String name : NAMES) {
                for (String secondName : SECOND_NAMES) {
                    Person person = new Person(
                            surname,
                            name,
                            secondName,
                            10 + randomAge.nextInt(70)
                    );

                    personList.add(person);
                }
            }
        }

        Collections.shuffle(personList);

        personRepository.save(personList);
    }
}
