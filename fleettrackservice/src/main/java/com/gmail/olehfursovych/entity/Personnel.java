package com.gmail.olehfursovych.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JoinColumn(name = "vehicle_id", unique = true)
    private Vehicle vehicle;
}