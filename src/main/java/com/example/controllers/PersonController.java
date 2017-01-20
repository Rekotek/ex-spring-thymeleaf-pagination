package com.example.controllers;

import com.example.entities.Person;
import com.example.services.PersonProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by taras on 20.01.17.
 */

@Controller
public class PersonController
{
    private final int ITEMS_PER_PAGE = 15;

    @Autowired
    private PersonProcessingService personService;

    @RequestMapping(value = "/", method = GET)
    public ModelAndView getPersonListPage(@RequestParam(required = false) Integer page,
                                          @RequestParam(required = false) Integer size)
    {

        ModelAndView modelAndView = new ModelAndView("persons");

        long totalCount = personService.getAllCount();
        int requestedSize = (size == null) ? ITEMS_PER_PAGE : Math.abs(size);
        int requestedPageNumber = (page == null) ? 0 : Math.abs((page - 1));

        int numOfPages = (int) (totalCount / ITEMS_PER_PAGE);
        if (requestedPageNumber > numOfPages) {
            requestedPageNumber = numOfPages;
        }

        Page<Person> persons = personService.getPersons(requestedPageNumber, requestedSize);

        modelAndView.addObject("persons", persons);
        modelAndView.addObject("currentPageNumber", persons.getNumber() + 1);
        modelAndView.addObject("requestedSize", requestedSize);
        modelAndView.addObject("totalCount", totalCount);
        modelAndView.addObject("numOfPages", numOfPages);

        return modelAndView;
    }
}
