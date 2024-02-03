package com.hotwaxx.Assesment.controller;

import com.hotwaxx.Assesment.entity.Person;
import com.hotwaxx.Assesment.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/")
    public Person addPerson(@RequestBody Person person){
        return personService.AddPerson(person);
    }

}
