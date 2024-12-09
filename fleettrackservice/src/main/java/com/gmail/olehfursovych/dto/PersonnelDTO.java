package com.gmail.olehfursovych.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonnelDTO {
    @NotNull(message = "Id must not equal null!")
    private Long id;

    @Size(min = 2, max = 70, message = "Please enter your first name")
    @NotBlank(message = "Please provide a name")
    private String firstName;

    @Size(min = 2, max = 70, message = "Please enter your last name")
    @NotBlank(message = "Please provide a last name")
    private String lastName;

    @Size(min = 4, max = 8, message = "Please enter a correct password")
    @NotBlank(message = "Please provide a password")
    private String password;

    @NotBlank(message = "Please provide your position, if you don't have one, please contact with your manager")
    private String position;

    @Size(min = 10, max = 10, message = "The field must be exactly 10 characters long")
    private String phoneNumber;

    @Email(message = "Please provide a valid email address")
    private String email;

    private Long assignedVehicle;
}