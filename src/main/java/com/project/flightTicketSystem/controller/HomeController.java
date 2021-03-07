package com.project.flightTicketSystem.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flightTicketSystem.model.Root;
import com.project.flightTicketSystem.repository.AirportRepository;
import com.project.flightTicketSystem.repository.FlightRepository;
import com.project.flightTicketSystem.service.BookingService;
import com.project.flightTicketSystem.service.Graph;

@RestController
@RequestMapping("/")
public class HomeController {
    
	@Autowired
	Graph graph;
	
	@Autowired
	AirportRepository airportRepo;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	FlightRepository flightRepo;
	
	@GetMapping("search")
	public Map<Integer, Root> getRoot(@RequestParam("from") Long from, @RequestParam("to") Long to, Model model){
		graph.makeGraph();
		Set<List<Long>> aids= graph.search(from, to);
		
		//Map<Long, List<Root>> response= new HashMap<>();
		
		if(aids.isEmpty()) {
			model.addAttribute("message", "Sorry No roots are available");
			return null;
		}
		
		return bookingService.getRoots(aids);
	}
	
	@GetMapping("bookingPreview")
	public Root showPreviewAndGetDetailsOfPassenger(@RequestParam("key") Integer key) {
		List<Long> aid_list= bookingService.ROOT.get(key);
		return bookingService.createRootObjectFromListOfAirportId(aid_list);
	
	}
    
}
