package com.project.flightTicketSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages= {"com.project.flightTicketSystem.service"})
@EnableJpaRepositories
public class FlightTicketSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightTicketSystemApplication.class, args);
	}

}
