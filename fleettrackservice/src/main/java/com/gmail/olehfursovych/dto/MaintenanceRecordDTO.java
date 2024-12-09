package com.gmail.olehfursovych.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceRecordDTO {
    private Long recordId;
    private Long vehicleId;
    private LocalDate maintenanceDate;
    private String description;
    private Long performedBy; // Personnel ID
}