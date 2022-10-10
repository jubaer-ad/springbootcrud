package com.jb.firstCRUD.service;

import com.jb.firstCRUD.entity.Person;
import com.jb.firstCRUD.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository pr;

    // Post Method(s)
    public Person savePerson(Person person) {
        return pr.save(person);
    }

    public List<Person> savePersons(List<Person> persons) {
        return pr.saveAll(persons);
    }

    // Get Method(s)
    public Person getPersonById(int id) {
        return (Person) pr.findById(id).orElse(null);
    }

    public List<Person> getAllPersons() {
        return pr.findAll();
    }

    public List<Person> getPersonsByName(String name){
        List<Person> personList = new ArrayList<>();
        String nameParts[] = name.split(" ");
        for (String namePart: nameParts) {
            personList.addAll((Collection<? extends Person>) pr.findAllByFirstName(namePart));
            personList.addAll((Collection<? extends Person>) pr.findAllByLastName(namePart));
        }
        return personList;

    }

    // Put method(s)
    public Person update(Person person) {
        Person existingPerson = (Person) pr.findById(person.getId()).orElse(null);
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        existingPerson.setAddress(person.getAddress());
        existingPerson.setMobile(person.getMobile());
        pr.save(existingPerson);
        return existingPerson;
    }

    // Delete Method(s)
    public String deletePerson(int id) {
        pr.deleteById(id);
        return "Deleted id: " + id;
    }
}
