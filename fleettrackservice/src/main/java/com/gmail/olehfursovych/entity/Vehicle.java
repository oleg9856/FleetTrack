package com.gmail.olehfursovych.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name = "VehicleEntity")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long vehicleId;

    @Column(name = "license_plate",
            unique = true,
            nullable = false,
            length = 20)
    private String licensePlate;

    @Column(name = "make",
            length = 50)
    private String make;

    @Column(name = "model",
            length = 50)
    private String model;

    private Integer year;

    @Column(name = "vehicle_type",
            length = 50)
    private String vehicleType;


    @Column(name = "status", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    public enum Status {
        ACTIVE,
        MAINTENANCE,
        INACTIVE
    }

    @OneToOne(mappedBy = "vehicle")
    private Personnel personnel;


}
