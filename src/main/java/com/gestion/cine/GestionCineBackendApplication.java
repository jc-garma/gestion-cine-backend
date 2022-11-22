package com.gestion.cine;

import com.gestion.cine.service.ICinemaInitService;
import com.gestion.cine.dto.Film;
import com.gestion.cine.dto.Salle;
import com.gestion.cine.dto.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestionCineBackendApplication {
	
	@Autowired
	private ICinemaInitService iCinemaInitService;

	public static void main(String[] args) {
		SpringApplication.run(GestionCineBackendApplication.class, args);
		System.out.println("Inicio");
	}
	
	@Bean
	public CommandLineRunner demoVetRepository() {
		return (args) -> {
				
	  iCinemaInitService.initCities();
	  iCinemaInitService.initCinemas();
	  iCinemaInitService.initSalles();
	  iCinemaInitService.initPlaces();
	  iCinemaInitService.initSeances();
	  iCinemaInitService.initCategories();
	  iCinemaInitService.initFilms();
	  iCinemaInitService.initProjections();
	  iCinemaInitService.initTickets();
			
	};
	}

}
