package com.gmail.olehfursovych.service.impl;

import com.gmail.olehfursovych.dto.PersonnelDTO;
import com.gmail.olehfursovych.entity.Personnel;
import com.gmail.olehfursovych.repository.PersonnelRepository;
import com.gmail.olehfursovych.service.IPersonnelService;
import com.gmail.olehfursovych.service.exceptions.PersonNotFoundException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonnelService implements IPersonnelService {

    private final PersonnelRepository personnelRepository;
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder(16);
    private final Validator validator;

    @Autowired
    public PersonnelService(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public PersonnelDTO getPersonById(long id) {
        return personnelRepository.findById(id).map(this::mapToDTO).orElseThrow(
                () -> {
            log.error("Personnel with id {} not found", id);
            return new PersonNotFoundException("Personnel with id " + id + " not found");
        });
    }

    @Override
    public PersonnelDTO getPersonByLastName(String lastName) {
        return personnelRepository.findByLastName(lastName).map(this::mapToDTO).orElseThrow(
                () -> {
                    log.error("Personnel with last name {} not found", lastName);
                    return new PersonNotFoundException("Personnel with last name " + lastName + " not found");
                }
        );
    }

    @Override
    public PersonnelDTO findByEmailAndAndFirstNameAndLastName(String email, String firstName, String lastName) {
        return personnelRepository.findByEmailAndAndFirstNameAndLastName(email, firstName, lastName).map(this::mapToDTO).orElseThrow(
                () -> {
                    log.error("Personnel with these parameters {} not found", email + firstName + lastName);
                    return new PersonNotFoundException("Personnel with these parameters " + email + firstName + lastName + " not found");
                }
        );
    }

    @Override
    public Iterable<PersonnelDTO> getAllPersons() {
        return personnelRepository.findAll()
        .stream()
        .map(this::mapToDTO)
        .toList();
    }

    @Override
    public void savePerson(PersonnelDTO personnelDTO) {
        Set<ConstraintViolation<PersonnelDTO>> violations = validator.validate(personnelDTO);
        if(!violations.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(ConstraintViolation<PersonnelDTO> violation : violations){
                sb.append(violation.getMessage()).append("\n");
            }
            throw new IllegalArgumentException("Personnel validation failed:\n" + sb.toString());
        }

        var personEntity = mapToEntity(personnelDTO);
        String hashPassword = ENCODER.encode(personEntity.getPassword());
        personEntity.setPassword(hashPassword);

        personnelRepository.save(personEntity);
    }

    @Override
    public void deletePerson(long id) {
        personnelRepository.deleteById(id);
    }

        private PersonnelDTO mapToDTO(Personnel personnel) {
        return PersonnelDTO.builder()
                .id(personnel.getPersonnelId())
                .firstName(personnel.getFirstName())
                .lastName(personnel.getLastName())
                .position(personnel.getPosition())
                .phoneNumber(personnel.getPhoneNumber())
                .email(personnel.getEmail())
                .build();
    }


    private Personnel mapToEntity(PersonnelDTO personnelDTO) {
        return Personnel.builder()
                .personnelId(personnelDTO.getId())
                .firstName(personnelDTO.getFirstName())
                .lastName(personnelDTO.getLastName())
                .password(personnelDTO.getPassword())
                .position(personnelDTO.getPosition())
                .phoneNumber(personnelDTO.getPhoneNumber())
                .email(personnelDTO.getEmail())
                .build();
    }
}
