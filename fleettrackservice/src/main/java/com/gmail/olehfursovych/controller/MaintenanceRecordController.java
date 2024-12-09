package com.gmail.olehfursovych.controller;

import com.gmail.olehfursovych.dto.MaintenanceRecordDTO;
import com.gmail.olehfursovych.entity.MaintenanceRecord;
import com.gmail.olehfursovych.service.IMaintenanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/maintenance-records")
public class MaintenanceRecordController {

    @Autowired
    private IMaintenanceRecordService maintenanceRecordService;

    @GetMapping
    public List<MaintenanceRecordDTO> getAllMaintenanceRecords() {
        List<MaintenanceRecord> records = maintenanceRecordService.getAllMaintenanceRecords();
        return records.stream().map(this::mapToDTO).toList();
    }

    @GetMapping("/{id}")
    public MaintenanceRecordDTO getMaintenanceRecordById(@PathVariable Long id) {
        MaintenanceRecord record = maintenanceRecordService.getMaintenanceRecordById(id);
        return mapToDTO(record);
    }

    @PostMapping
    public MaintenanceRecordDTO createMaintenanceRecord(@RequestBody MaintenanceRecordDTO maintenanceRecordDTO) {
        MaintenanceRecord record = mapToEntity(maintenanceRecordDTO);
        maintenanceRecordService.saveMaintenanceRecord(record);
        return mapToDTO(record);
    }

    @PutMapping("/{id}")
    public MaintenanceRecordDTO updateMaintenanceRecord(@PathVariable Long id, @RequestBody MaintenanceRecordDTO maintenanceRecordDTO) {
        MaintenanceRecord record = mapToEntity(maintenanceRecordDTO);
        record.setRecordId(id);
        maintenanceRecordService.updateMaintenanceRecord(id, record);
        return mapToDTO(record);
    }

    @DeleteMapping("/{id}")
    public void deleteMaintenanceRecord(@PathVariable Long id) {
        maintenanceRecordService.deleteMaintenanceRecord(id);
    }

    private MaintenanceRecordDTO mapToDTO(MaintenanceRecord record) {
        return MaintenanceRecordDTO.builder()
                .recordId(record.getRecordId())
                .vehicleId(record.getVehicle().getVehicleId())
                .maintenanceDate(record.getMaintenanceDate())
                .description(record.getDescription())
                .performedBy(record.getPersonnel().getPersonnelId())
                .build();
    }

    private MaintenanceRecord mapToEntity(MaintenanceRecordDTO maintenanceRecordDTO) {
        MaintenanceRecord record = new MaintenanceRecord();
        record.setRecordId(maintenanceRecordDTO.getRecordId());
        record.setVehicle(null);
        record.setMaintenanceDate(maintenanceRecordDTO.getMaintenanceDate());
        record.setDescription(maintenanceRecordDTO.getDescription());
        record.setPersonnel(null);
        return record;
    }
}