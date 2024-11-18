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
@Table(name = "personnel")
public class Person {

    @Id
    @SequenceGenerator(
            name = "personnel_id_sequence",
            sequenceName = "personnel_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "personnel_id_sequence"
    )
    @Column(name = "personnel_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "position")
    private String position;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @ManyToMany(mappedBy = "personnelSet")
    private Set<Vehicle> vehicleSet = new HashSet<>();

    @OneToMany(mappedBy = "personnel")
    private Set<MaintenanceRecord> maintenanceRecords;

    @OneToMany(mappedBy = "personnel")
    private Set<VehicleAssignment> vehicleAssignments;

    @OneToMany(mappedBy = "personnel")
    private Set<ServiceHistory> serviceHistories;

    @ManyToMany
    @JoinTable(
            name = "personnel_roles",
            joinColumns = @JoinColumn(name = "personnel_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}