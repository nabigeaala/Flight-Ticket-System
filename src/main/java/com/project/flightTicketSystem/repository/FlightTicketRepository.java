package com.project.flightTicketSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.flightTicketSystem.model.Flight_Ticket;

@Repository
public interface FlightTicketRepository extends JpaRepository<Flight_Ticket, Long> {

}
