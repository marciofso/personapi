package com.marcio.personapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcio.personapi.domain.Person;

public interface PersonRepository extends JpaRepository <Person, Integer> {
}
