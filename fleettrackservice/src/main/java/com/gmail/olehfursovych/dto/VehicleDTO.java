package com.gmail.olehfursovych.dto;

import com.gmail.olehfursovych.entity.Vehicle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {


    private Long vehicleId;
    private String licensePlate;
    private String make;
    private String model;
    private Integer year;
    private String vehicleType;
    private Vehicle.Status status = Vehicle.Status.ACTIVE;

    public enum Status {
        ACTIVE,
        MAINTENANCE,
        INACTIVE
    }
}