package com.gustavobussolotti.personapi.repository;

import com.gustavobussolotti.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
