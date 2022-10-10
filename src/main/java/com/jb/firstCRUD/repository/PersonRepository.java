package com.jb.firstCRUD.repository;

import com.jb.firstCRUD.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findAllByFirstName(String name);
    List<Person> findAllByLastName(String name);
}
