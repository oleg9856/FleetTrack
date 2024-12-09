package com.gmail.olehfursovych.dto;

import com.gmail.olehfursovych.entity.Vehicle;
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
    @Builder.Default 
    private Vehicle.VehicleStatus status = Vehicle.VehicleStatus.Active;


    public enum VehicleStatus {
        ACTIVE, MAINTENANCE, INACTIVE
    }
}