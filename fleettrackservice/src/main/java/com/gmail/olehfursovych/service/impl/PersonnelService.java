package com.gmail.olehfursovych.service.impl;

import com.gmail.olehfursovych.entity.Personnel;
import com.gmail.olehfursovych.repository.PersonnelRepository;
import com.gmail.olehfursovych.service.IPersonnelService;
import com.gmail.olehfursovych.service.exceptions.PersonNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonnelService implements IPersonnelService {

    private final PersonnelRepository personnelRepository;

    @Autowired
    public PersonnelService(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

    @Override
    public Personnel getPersonById(long id) {
        return personnelRepository.findById(id).orElseThrow(
                () -> {
            log.error("Personnel with id {} not found", id);
            return new PersonNotFoundException("Personnel with id " + id + " not found");
        });
    }

    @Override
    public Personnel getPersonByLastName(String lastName) {
        return personnelRepository.findByLastName(lastName).orElseThrow(
                () -> {
                    log.error("Personnel with last name {} not found", lastName);
                    return new PersonNotFoundException("Personnel with last name " + lastName + " not found");
                }
        );
    }

    @Override
    public Personnel findByEmailAndAndFirstNameAndLastName(String email, String firstName, String lastName) {
        return personnelRepository.findByEmailAndAndFirstNameAndLastName(email, firstName, lastName).orElseThrow(
                () -> {
                    log.error("Personnel with these parameters {} not found", email + firstName + lastName);
                    return new PersonNotFoundException("Personnel with these parameters " + email + firstName + lastName + " not found");
                }
        );
    }

    @Override
    public Iterable<Personnel> getAllPersons() {
        return personnelRepository.findAll();
    }

    @Override
    public void savePerson(Personnel personnel) {
        // todo: hash password
        // todo: validate personnel
        personnelRepository.save(personnel);
    }

    @Override
    public void deletePerson(long id) {
        personnelRepository.deleteById(id);
    }
}
