package com.gmail.olehfursovych;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "maintenance_records")
public class MaintenanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private int recordId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @Column(name = "maintenance_date")
    @Temporal(TemporalType.DATE)
    private Date maintenanceDate;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "performed_by")
    private Person personnel;
}