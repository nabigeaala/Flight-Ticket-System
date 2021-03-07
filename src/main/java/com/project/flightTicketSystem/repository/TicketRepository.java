package com.project.flightTicketSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.flightTicketSystem.model.Ticket;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket, Long>{

}
