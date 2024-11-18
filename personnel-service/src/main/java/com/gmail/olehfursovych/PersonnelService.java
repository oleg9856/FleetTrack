package com.gmail.olehfursovych;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class PersonnelService {
    public final  PersonnelRepository repository;
    private final RestTemplate restTemplate;

    public void registerPersonnel(PersonnelRegistrationRequest request) {
        Person person = Person.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .phoneNumber(request.phoneNumber())
                .email(request.email())
                .build();


        // todo: check if email is valid
        // todo: check if phone number is valid
        // todo: check if person already exists
//        restTemplate.getForObject("http://localhost:8080/api/v1/")
        repository.save(person);


    }
}
