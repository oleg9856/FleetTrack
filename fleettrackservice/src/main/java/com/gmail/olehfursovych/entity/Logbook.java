package com.gmail.olehfursovych.entity;


import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "logbook")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Logbook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    @NotNull
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "personnel_id")
    private Personnel personnel;

    @Column(name = "log_date", nullable = false)
    private LocalDate logDate;

    private String description;
}