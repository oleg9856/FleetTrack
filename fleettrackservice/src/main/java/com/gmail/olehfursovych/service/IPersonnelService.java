package com.gmail.olehfursovych.service;

import com.gmail.olehfursovych.entity.Personnel;

import java.util.Optional;

public interface IPersonnelService {
    Personnel getPersonById(long id);
    Personnel getPersonByLastName(String lastName);
    Personnel findByEmailAndAndFirstNameAndLastName(String email, String firstName, String lastName);
    Iterable<Personnel> getAllPersons();
    void savePerson(Personnel personnel);
    void deletePerson(long id);
}
