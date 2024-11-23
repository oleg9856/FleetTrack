package com.gmail.olehfursovych.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@Entity(name = "PersonnelEntity")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "personnel")
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personnel_id")
    private Long personnelId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String position;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;

    @OneToOne
    @JoinColumn(name = "assigned_vehicle", unique = true)
    private Vehicle assignedVehicle;

    @OneToMany(mappedBy = "personnel")
    private Set<MaintenanceRecord> performedMaintenances;

    @OneToMany(mappedBy = "personnel")
    private Set<VehicleAssignment> vehicleAssignments;

    @OneToMany(mappedBy = "personnel")
    private Set<ServiceHistory> serviceHistory;

    @ManyToMany
    @JoinTable(
            name = "personnel_roles",
            joinColumns = @JoinColumn(name = "personnel_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}