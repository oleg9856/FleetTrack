package com.gmail.olehfursovych.repository;

import com.gmail.olehfursovych.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
