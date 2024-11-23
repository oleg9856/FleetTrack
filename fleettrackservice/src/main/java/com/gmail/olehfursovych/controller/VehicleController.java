package com.gmail.olehfursovych.controller;

import com.gmail.olehfursovych.entity.Vehicle;
import com.gmail.olehfursovych.service.impl.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable long id) {
        return vehicleService.getVehicleById(id);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping
    public void saveVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable long id) {
        vehicleService.deleteVehicle(id);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable long id, @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(id, vehicle);
    }

    @PatchMapping("/{id}/status")
    public Vehicle updateVehicleStatus(@PathVariable long id, @RequestParam Vehicle.Status status) {
        return vehicleService.updateVehicleStatus(id, status);
    }
}