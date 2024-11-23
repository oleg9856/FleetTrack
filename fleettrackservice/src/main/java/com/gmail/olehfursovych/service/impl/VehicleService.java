package com.gmail.olehfursovych.service.impl;

import com.gmail.olehfursovych.entity.Vehicle;
import com.gmail.olehfursovych.repository.VehicleRepository;
import com.gmail.olehfursovych.service.exceptions.VehicleNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle getVehicleById(long id) {
        return vehicleRepository.findById(id).orElseThrow(
                () -> {
                    log.error("Vehicle with id {} not found", id);
                    return new VehicleNotFoundException("Vehicle with id " + id + " not found");
                });
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public void saveVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(long id) {
        vehicleRepository.deleteById(id);
    }

    public Vehicle updateVehicle(long id, Vehicle updatedVehicle) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> {
            log.error("Vehicle with id {} not found", id);
            return new VehicleNotFoundException("Vehicle with id " + id + " not found");
        });

        vehicle.setMake(updatedVehicle.getMake());
        vehicle.setModel(updatedVehicle.getModel());
        vehicle.setYear(updatedVehicle.getYear());
        vehicle.setVehicleType(updatedVehicle.getVehicleType());

        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicleStatus(long id, Vehicle.VehicleStatus status) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> {
            log.error("Vehicle with id {} not found", id);
            return new VehicleNotFoundException("Vehicle with id " + id + " not found");
        });

        vehicle.setStatus(status);

        return vehicleRepository.save(vehicle);
    }
}
