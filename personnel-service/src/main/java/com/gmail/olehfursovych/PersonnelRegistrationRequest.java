package com.gmail.olehfursovych;

public record PersonnelRegistrationRequest(
        String firstName,
        String lastName,
        String phoneNumber,
        String email) {

}
