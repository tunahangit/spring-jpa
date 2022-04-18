package com.uygulama.springjpa.repository;

import com.uygulama.springjpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
