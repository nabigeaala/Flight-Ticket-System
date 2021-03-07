package com.project.flightTicketSystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import com.project.flightTicketSystem.model.Flight;
//import com.project.flightTicketSystem.repository.AirportRepository;
import com.project.flightTicketSystem.repository.FlightRepository;

@Service
public class Graph {
	
	//@Autowired
	//private AirportRepository airportRepo;
	
	@Autowired
    FlightRepository flightRepo;
	
	//private int no_of_airport= (int) airportRepo.count();
    
	private Map<Long, List<Long>> graph= new HashMap<>();
	
	public Graph() {
	}
	
	public void makeGraph() {
		for(Flight flight: flightRepo.findAll()) {
			addEdge(flight.getDeparture_airport().getId(), flight.getDestination_airport().getId());
		}
	}
	
	public void addEdge(Long from, Long to) {
		if(graph.containsKey(from))
			graph.get(from).add(to);
		else
			graph.computeIfAbsent(from, v-> new ArrayList<>()).add(to);
			
	}
	
	public void removeEdge(Long from, Long to) {
		if(graph.containsKey(from))
			graph.get(from).remove(to);
		
		else {
			//throw an exception
		}
	}
	
public Set<List<Long>> search(Long from, Long to){
		
		Set<List<Long>> ans= new HashSet<>();
		
		Map<Long, Boolean> visited= new HashMap<>();
		
		//Initialize the visited array
		for(Long airport_id : graph.keySet()) {
			visited.put(airport_id, false);
		}
		
		//int hopes=0;
		/*Queue<Long> q= new LinkedList<>();
		
		q.add(from);
		visited.replace(from, true);
		while(!q.isEmpty() && hopes < 3) {
			int size= q.size();
			for(int i=0; i<size; i++) {
				Long temp= q.poll();
				for(Long id : graph.getGraph().get(temp)) {
					if(visited.get(id) == false) {
						q.add(id);
						visited.replace(id, true);
					}
				}
			}
			hopes++;
		}*/
		
		Stack<Long> stack= new Stack<>();
		stack.push(from);
		visited.replace(from, true);
        
		return searchUtil(stack, visited, ans, to);
		
		/*while(stack.empty()==false) {
			Long temp= stack.peek();
			
			if(temp == to) {
				List<Long> list= new ArrayList<Long>(stack);
				
				ans.add(list);
				stack.pop();
			}
			boolean check= false;
			
			for(Long id : graph.get(stack.peek())) {
				if(visited.get(id)==false && stack.size() < 5) {
					check= true;
					stack.push(id);
					visited.replace(id, true);
				}
			}
			
			if(check==false) {
				 stack.pop();
			}
		}*/
		
	}

   private Set<List<Long>> searchUtil(Stack<Long> stack, Map<Long, Boolean> visited, Set<List<Long>> ans, Long to) {
	    
	   
	   for(Long id : graph.get(stack.peek())) {
		   
		   if(id == to) {
				List<Long> list= new ArrayList<Long>(stack);
				list.add(to);
				ans.add(list);
			}
		   
		   //set a limit so that maximum no of element in stack would be 4
		   else if(visited.get(id)==false && stack.size() < 3) {
				stack.push(id);
				visited.replace(id, true);
				ans= searchUtil(stack, visited, ans, to);
			}
		}
	    
		Long temp_id= stack.pop();
		
		visited.replace(temp_id, false);
	   
	   return ans;
   }

}
