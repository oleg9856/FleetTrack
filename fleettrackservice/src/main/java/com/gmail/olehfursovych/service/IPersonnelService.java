package com.gmail.olehfursovych.service;

import com.gmail.olehfursovych.dto.PersonnelDTO;

public interface IPersonnelService {
    PersonnelDTO getPersonById(long id);
    PersonnelDTO getPersonByLastName(String lastName);
    PersonnelDTO findByEmailAndAndFirstNameAndLastName(String email, String firstName, String lastName);
    Iterable<PersonnelDTO> getAllPersons();
    void savePerson(PersonnelDTO personnel);
    void deletePerson(long id);
}
