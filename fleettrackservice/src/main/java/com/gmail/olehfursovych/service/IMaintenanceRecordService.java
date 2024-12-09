package com.gmail.olehfursovych.service;

import com.gmail.olehfursovych.entity.MaintenanceRecord;

import java.util.List;

public interface IMaintenanceRecordService {
    MaintenanceRecord getMaintenanceRecordById(long id);
    List<MaintenanceRecord> getAllMaintenanceRecords();
    void saveMaintenanceRecord(MaintenanceRecord maintenanceRecord);
    void deleteMaintenanceRecord(long id);
    MaintenanceRecord updateMaintenanceRecord(long id, MaintenanceRecord updatedMaintenanceRecord);

}
