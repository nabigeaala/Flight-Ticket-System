package com.project.flightTicketSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.flightTicketSystem.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
     
	Optional<Flight> findByDepartureAirport_IdAndDestinationAirport_Id(@Param("from")Long from, @Param("to")Long to);
}
