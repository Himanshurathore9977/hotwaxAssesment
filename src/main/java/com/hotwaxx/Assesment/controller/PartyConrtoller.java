package com.hotwaxx.Assesment.controller;

import com.hotwaxx.Assesment.entity.Party;
import com.hotwaxx.Assesment.entity.Person;
import com.hotwaxx.Assesment.repository.PartyRepo;
import com.hotwaxx.Assesment.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/party")
public class PartyConrtoller {
    @Autowired
    PartyRepo partyRepo ;
    @Autowired
    PersonRepository personRepository ;
    @GetMapping
    public List<Party> getAllParty(){
        return (List<Party>)partyRepo.findAll() ;
    }

    @PostMapping
    public Party createParty( @RequestBody Party party ) {
        System.out.println(party.getPerson());
        if (party.getPerson() != null) {
            List<Person> people = party.getPerson();
            for (Person person : people) {
//                person.setParty(party);
                personRepository.save(person);
            }
        }
        return  partyRepo.save(party);

    }
}
