package com.gmail.olehfursovych.controller;


import com.gmail.olehfursovych.dto.PersonnelDTO;
import com.gmail.olehfursovych.entity.Personnel;
import com.gmail.olehfursovych.service.IPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/personnel")
public class PersonnelController {

    @Autowired
    private IPersonnelService personnelService;


    @GetMapping("/login")
    private PersonnelDTO getPerson(@RequestParam String email, @RequestParam String firstName, @RequestParam String lastName) {
        Personnel personnel = personnelService.findByEmailAndAndFirstNameAndLastName(email, firstName, lastName);
        return mapToDTO(personnel);
    }

    @PostMapping("/register")
    private PersonnelDTO register(@RequestBody PersonnelDTO personnelDTO) {
        Personnel personnel = mapToEntity(personnelDTO);
        personnelService.savePerson(personnel);
        return mapToDTO(personnel);
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
                .position(personnelDTO.getPosition())
                .phoneNumber(personnelDTO.getPhoneNumber())
                .email(personnelDTO.getEmail())
                .build();
    }


}
