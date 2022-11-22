package com.gestion.cine.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cinema implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private int sallenumber;

	@OneToMany(mappedBy = "cinema")
	private Collection<Salle> salles;

	@ManyToOne
	private City city;

	public Cinema() {
		
	}

	public Cinema(String name, int sallenumber, Collection<Salle> salles, City city) {
		this.name = name;
		this.sallenumber = sallenumber;
		this.salles = salles;
		this.city = city;
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

	public int getSalleNumber() {
		return sallenumber;
	}

	public void setSalleNumber(int sallenumber) {
		this.sallenumber = sallenumber;
	}

	public Collection<Salle> getSalles() {
		return salles;
	}

	public void setSalles(Collection<Salle> salles) {
		this.salles = salles;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
	   this.city = city;
	 }
}
