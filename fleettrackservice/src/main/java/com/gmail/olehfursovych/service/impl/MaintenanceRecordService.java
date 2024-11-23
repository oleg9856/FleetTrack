package com.gmail.olehfursovych.service.impl;

import com.gmail.olehfursovych.entity.MaintenanceRecord;
import com.gmail.olehfursovych.repository.MaintenanceRecordRepository;
import com.gmail.olehfursovych.service.IMaintenanceRecordService;
import com.gmail.olehfursovych.service.exceptions.MaintenanceRecordNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MaintenanceRecordService implements IMaintenanceRecordService {

    private final MaintenanceRecordRepository maintenanceRecordRepository;

    @Autowired
    public MaintenanceRecordService(MaintenanceRecordRepository maintenanceRecordRepository) {
        this.maintenanceRecordRepository = maintenanceRecordRepository;
    }

    @Override
    public MaintenanceRecord getMaintenanceRecordById(long id) {
        return maintenanceRecordRepository.findById(id).orElseThrow(() -> {
            log.error("MaintenanceRecord with id {} not found", id);
            return new MaintenanceRecordNotFoundException("MaintenanceRecord with id " + id + " not found");
        });
    }

    @Override
    public List<MaintenanceRecord> getAllMaintenanceRecords() {
        return maintenanceRecordRepository.findAll();
    }

    @Override
    public void saveMaintenanceRecord(MaintenanceRecord maintenanceRecord) {
        maintenanceRecordRepository.save(maintenanceRecord);
    }

    @Override
    public void deleteMaintenanceRecord(long id) {
        maintenanceRecordRepository.deleteById(id);
    }

    @Override
    public MaintenanceRecord updateMaintenanceRecord(long id, MaintenanceRecord updatedMaintenanceRecord) {
        MaintenanceRecord maintenanceRecord = maintenanceRecordRepository.findById(id).orElseThrow(() -> {
            log.error("MaintenanceRecord with id {} not found", id);
            return new MaintenanceRecordNotFoundException("MaintenanceRecord with id " + id + " not found");
        });

        maintenanceRecord.setMaintenanceDate(updatedMaintenanceRecord.getMaintenanceDate());
        maintenanceRecord.setDescription(updatedMaintenanceRecord.getDescription());
        maintenanceRecord.setPersonnel(updatedMaintenanceRecord.getPersonnel());

        return maintenanceRecordRepository.save(maintenanceRecord);
    }
}