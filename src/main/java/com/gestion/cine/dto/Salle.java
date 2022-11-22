package com.gestion.cine.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Salle implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	private String name;

	private int placenumber;

	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Cinema cinema;

	@OneToMany(mappedBy = "salle")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Place> places;

	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "salle")
	private Collection<Projection> projections;

	public Salle() {
		
	}

	public Salle(String name, int placenumber, Cinema cinema, Collection<Place> places,
			Collection<Projection> projections) {
		this.name = name;
		this.placenumber = placenumber;
		this.cinema = cinema;
		this.places = places;
		this.projections = projections;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlaceNumber() {
		return placenumber;
	}

	public void setPlaceNumber(int placenumber) {
		this.placenumber = placenumber;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Collection<Place> getPlaces() {
		return places;
	}

	public void setPlaces(Collection<Place> places) {
		this.places = places;
	}

	public Collection<Projection> getProjections() {
		return projections;
	}

	public void setProjections(Collection<Projection> projections) {
		this.projections = projections;
	}
}
