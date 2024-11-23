package com.gmail.olehfursovych.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "maintenance_records")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long recordId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @Column(name = "maintenance_date")
    private LocalDate maintenanceDate;

    private String description;

    @ManyToOne
    @JoinColumn(name = "performed_by")
    private Personnel personnel;
}