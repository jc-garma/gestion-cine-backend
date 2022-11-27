package com.gestion.cine.controller;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import com.gestion.cine.dao.CityRepository;
import com.gestion.cine.dto.Cinema;
import com.gestion.cine.dto.City;
import com.gestion.cine.dao.FilmRepository;
import com.gestion.cine.dao.TicketRepository;
import com.gestion.cine.dto.Film;
import com.gestion.cine.dto.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class CinemaController {
	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	
	@GetMapping("findAllFilms")
	public List<Film> findAllFilms(){
		return filmRepository.findAll();
	}
	
	@GetMapping("findFilmById/{id}")
	public Film findFilmById(@PathVariable(name = "id") Long id) {
		return filmRepository.findById(id).orElse(null);
	}
	
	
	@GetMapping("findAllTickets")
	public List<Ticket> findAllTickets(){
		return ticketRepository.findAll();
	}
	
	@GetMapping("findTicketById/{id}")
	public Ticket findTicketById(@PathVariable(name = "id") Long id){
		return ticketRepository.findById(id).orElse(null);
	}
	
	@GetMapping("findAllCities")
	public List<City> findAllCities(){
		return cityRepository.findAll();
	}
	
	@GetMapping("findAllCinemasByIdCity/{id}")
	public List<Cinema> findAllCinemasByIdCity(@PathVariable(name = "id") Long id){
		List<Cinema> cinemas = new ArrayList<Cinema>();
		City cityE = cityRepository.findById(id).orElse(null);
		cityE.getCinemas().forEach(cinema -> {
			cinemas.add(cinema);
		});
		
		return cinemas;
	}
	
	//Método que permitirá pagar uno o varios tickets, es decir, asignar un nameclient y un codepayment, inicialmente a 0 y null, a cada objeto Ticket ya generado.
	@PostMapping("/payTickets")
	public List<Ticket> payTickets(@RequestBody TicketFrom ticketFrom) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		ticketFrom.getTickets().forEach(idTicket -> {
			Ticket ticket = ticketRepository.findById(idTicket).orElse(null);
			ticket.setNameClient(ticketFrom.getNameClient());
			ticket.setCodePayement(ticketFrom.getCodePayement());
			ticket.setReserve(true); //Cambiamos a true la reserva
			ticketRepository.save(ticket);
			tickets.add(ticket);
		});
		return tickets;
	}

}

class TicketFrom {

	private String nameclient;
	private int codepayement;
	private List<Long> tickets = new ArrayList<Long>();

	public String getNameClient() {
		return nameclient;
	}

	public void setNameClient(String nameclient) {
		this.nameclient = nameclient;
	}

	public List<Long> getTickets() {
		return tickets;
	}

	public void setTickets(List<Long> tickets) {
		this.tickets = tickets;
	}

	public int getCodePayement() {
		return codepayement;
	}

	public void setCodePayement(int codepayement) {
		this.codepayement = codepayement;
	}

}
