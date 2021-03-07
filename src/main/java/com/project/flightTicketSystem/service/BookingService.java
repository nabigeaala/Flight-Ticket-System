package com.project.flightTicketSystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.flightTicketSystem.model.ABSTRACT_AIRPORT;
import com.project.flightTicketSystem.model.Abstract_Flight;
import com.project.flightTicketSystem.model.Airport;
import com.project.flightTicketSystem.model.Flight;
import com.project.flightTicketSystem.model.Root;
import com.project.flightTicketSystem.repository.AirportRepository;
import com.project.flightTicketSystem.repository.FlightRepository;

@Service
public class BookingService {
	
	@Autowired
	AirportRepository airportRepo;
	
	@Autowired
	FlightRepository flightRepo;
	
	private Integer KEY=0;
     
	//store the roots as list of airport id 
	public Map<Integer, List<Long>> ROOT= new HashMap<>();

	public Map<Integer, Root> getRoots(Set<List<Long>> aids) {
		Map<Integer, Root> roots= new HashMap<>();
		
		//List<ABSTRACT_AIRPORT> abs_airport= new ArrayList<>();
		
		//make list if abstract airport from aids
		for(List<Long> aid_list: aids) {
			
			if(!ROOT.containsValue(aid_list))
				ROOT.put(KEY++, aid_list);
					
			int key= ROOT.entrySet().stream().filter(e-> e.getValue().equals(aid_list)).map(Map.Entry::getKey).findFirst().get();
			roots.put(key, createRootObjectFromListOfAirportId(aid_list));
		}
		
		return roots;
	}
	
	public Root createRootObjectFromListOfAirportId(List<Long> aid_list) {
		List<ABSTRACT_AIRPORT> abs_airport= new ArrayList<>();
		List<Abstract_Flight> flights= new ArrayList<>();
		int totalFare=0;
		
		//make list of ABSTRACT_Airport 
		aid_list.forEach(id->{
			Airport airport = airportRepo.findById(id).get();
			abs_airport.add(new ABSTRACT_AIRPORT(airport.getId(), airport.getName(), airport
					.getCity(), airport.getAirport_code(), airport.getCountry()));
		});
		
		//make list of abstract_flight
		int count=0;
		Long prev=(long) -1;
		for(Long id : aid_list) {
			if(count==0) {
			   prev= id;
			   count++;
			   continue;
			}
			
			Flight flight= flightRepo.findByDepartureAirport_IdAndDestinationAirport_Id(prev, id).get();
			flights.add(new Abstract_Flight(flight.getId(), flight.getName(), 
					flight.getFare(), flight.getDeparture_time(), flight.getDestination_time()));
			totalFare+= flight.getFare();
		
			prev= id;
			count++;
		}
		
		return new Root(abs_airport, flights, totalFare);
		
	}
	
	
}
