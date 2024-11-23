package com.gmail.olehfursovych.service.exeptions;;

public class VehicleNotFoundException extends RuntimeException {
    private String message;

    public VehicleNotFoundException() {}

    public VehicleNotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }
}