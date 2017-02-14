package com.szatmary.peter.db.repository;

import com.szatmary.peter.db.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    @Query("select u from Person u where u.name = :name")
    List<Person> findByName(String name);
}
