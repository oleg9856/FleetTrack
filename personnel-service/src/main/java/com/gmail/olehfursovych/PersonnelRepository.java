package com.gmail.olehfursovych;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelRepository extends JpaRepository<Person, Integer> {
}
