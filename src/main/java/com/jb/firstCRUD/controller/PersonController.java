package com.jb.firstCRUD.controller;

import com.jb.firstCRUD.entity.Person;
import com.jb.firstCRUD.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person/api")
public class PersonController {
    @Autowired
    private PersonService ps;

    @GetMapping
    public List<Person> getAllData() {
        return ps.getAllPersons();
    }

    @PostMapping
    public Person addData(@RequestBody Person person) {
        return ps.savePerson(person);
    }

    // Post Mapping(s)
    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person) {
        return ps.savePerson(person);
    }

    @PostMapping("/adds")
    public List<Person> addPerson(@RequestBody List<Person> persons) {
        return (List<Person>) ps.savePersons(persons);
    }

    // Get Mapping(s)
    @GetMapping("/getbyid/{id}")
    public Person getPersonById(@PathVariable int id) {
        return ps.getPersonById(id);
    }

    @GetMapping("/getall")
    public List<Person> getAllPersons() {
        return ps.getAllPersons();
    }

    @GetMapping("/getByName/{name}")
    public List<Person> findAllByFirstName(@PathVariable String name) {
        return ps.getPersonsByName(name);
    }

    // PUT Mapping
    @PutMapping("/update")
    public Person update(@RequestBody Person person) {
        return ps.update(person);
    }

    // Delete Mapping
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return ps.deletePerson(id);
    }

    @DeleteMapping("/deleteall")
    public String deleteAll() {
        List<Person> allPersons =  ps.getAllPersons();
        List<Integer> ids = new ArrayList<>();
        for (Person person:allPersons
             ) {int pid = person.getId();
            ps.deletePerson(pid);
            ids.add(pid);
        }
        return "Deleted ids: " + ids;
    }

}
