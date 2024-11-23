package com.gmail.olehfursovych.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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

    @Column(name = "license_plate", nullable = false, unique = true)
    private String licensePlate;

    private String make;
    private String model;
    private Integer year;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private VehicleStatus status = VehicleStatus.Active;

    @OneToOne(mappedBy = "assignedVehicle")
    private Personnel assignedPersonnel;

    @OneToMany(mappedBy = "vehicle")
    private Set<MaintenanceRecord> maintenanceRecords;

    @OneToMany(mappedBy = "vehicle")
    private Set<VehicleAssignment> vehicleAssignments;

    @OneToMany(mappedBy = "vehicle")
    private Set<Logbook> logEntries;

    public enum VehicleStatus {
        Active, Maintenance, Inactive
    }



}
