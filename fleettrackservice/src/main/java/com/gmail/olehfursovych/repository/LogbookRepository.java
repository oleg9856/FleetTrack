package com.gmail.olehfursovych.repository;

import com.gmail.olehfursovych.entity.Logbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogbookRepository extends JpaRepository<Logbook, Long> {
}
