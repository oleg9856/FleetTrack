package com.gmail.olehfursovych.repository;


import com.gmail.olehfursovych.entity.Personnel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonnelRepository extends CrudRepository<Personnel, Long> {
    Optional<Personnel> findByLastName(String lastName);
    Optional<Personnel> findByEmailAndAndFirstNameAndLastName(String email, String firstName, String lastName);
    List<Personnel> findAll();
}
