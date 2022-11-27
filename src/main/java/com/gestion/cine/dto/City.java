package com.gestion.cine.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class City implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "city")
	@JsonIgnore
	private Collection<Cinema> cinemas;

	public City() {
		
	}

	public City(String name, Collection<Cinema> cinemas) {
		this.name = name;
		this.cinemas = cinemas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Cinema> getCinemas() {
		return cinemas;
	}

	public void setCinemas(Collection<Cinema> cinemas) {
		this.cinemas = cinemas;
	}
}
