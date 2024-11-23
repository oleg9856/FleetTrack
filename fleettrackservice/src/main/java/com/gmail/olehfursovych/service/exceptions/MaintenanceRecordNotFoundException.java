package com.gmail.olehfursovych.service.exceptions;

public class MaintenanceRecordNotFoundException extends RuntimeException {
    private String message;

    public MaintenanceRecordNotFoundException() {}

    public MaintenanceRecordNotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
