package com.project.flightTicketSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.flightTicketSystem.model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
   
}
