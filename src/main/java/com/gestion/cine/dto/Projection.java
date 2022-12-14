package com.gestion.cine.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Projection implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date dateprojection;

	private double price;

	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Salle salle;

	@ManyToOne
	private Film film;

	@OneToMany(mappedBy = "projection")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Ticket> tickets;

	@ManyToOne
	private Seance seance;

	public Projection() {
		
	}

	public Projection(Date dateprojection, double price, Salle salle, Film film, Collection<Ticket> tickets,
			Seance seance) {
		this.dateprojection = dateprojection;
		this.price = price;
		this.salle = salle;
		this.film = film;
		this.tickets = tickets;
		this.seance = seance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateProjection() {
		return dateprojection;
	}

	public void setDateProjection(Date dateprojection) {
		this.dateprojection = dateprojection;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Collection<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Collection<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

}
