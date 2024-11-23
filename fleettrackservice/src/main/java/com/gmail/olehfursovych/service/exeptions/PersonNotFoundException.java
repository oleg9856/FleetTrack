package com.gmail.olehfursovych.service.exeptions;

public class PersonNotFoundException extends RuntimeException {
    private String message;

    public PersonNotFoundException() {}

    public PersonNotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }

}
