package com.gmail.olehfursovych;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @SequenceGenerator(
            name = "vehicle_id_sequence",
            sequenceName = "vehicle_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vehicle_id_sequence"
    )
    @Column(name = "vehicle_id")
    private Integer id;

    @Column(name = "license_plate", nullable = false, unique = true)
    private String licensePlate;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Integer year;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @ManyToMany(mappedBy = "vehicles")
    private Set<Person> people;

    @OneToMany(mappedBy = "vehicle")
    private Set<MaintenanceRecord> maintenanceRecords;

    @OneToMany(mappedBy = "vehicle")
    private Set<VehicleAssignment> vehicleAssignments;

    // Add ManyToMany relationship with Personnel
    @ManyToMany
    @JoinTable(
            name = "vehicles",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "personnel_id")
    )
    private Set<Person> personnelSet = new HashSet<>();
}