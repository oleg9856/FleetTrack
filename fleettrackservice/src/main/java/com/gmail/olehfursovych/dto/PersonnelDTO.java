package com.gmail.olehfursovych.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonnelDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private String phoneNumber;
    private String email;
    private Long assignedVehicle;
}