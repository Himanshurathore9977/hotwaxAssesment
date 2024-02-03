package com.hotwaxx.Assesment.service.implement;

import com.hotwaxx.Assesment.entity.Person;
import com.hotwaxx.Assesment.repository.PersonRepository;
import com.hotwaxx.Assesment.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository ;
    @Override
    public Person AddPerson(Person person){
            return personRepository.save(person) ;
    }
}
