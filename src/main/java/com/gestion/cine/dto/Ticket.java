package com.gestion.cine.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Ticket implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nameclient;

	private double price;

	@Column(unique = false, nullable = true)
	private int codepayement;

	private boolean reserve;

	@ManyToOne
	private Place place;

	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Projection projection;

	public Ticket() {
	  
	}

	public Ticket(String nameclient, double price, int codepayement, boolean reserve, Place place,
			Projection projection) {
		this.nameclient = nameclient;
		this.price = price;
		this.codepayement = codepayement;
		this.reserve = reserve;
		this.place = place;
		this.projection = projection;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameClient() {
		return nameclient;
	}

	public void setNameClient(String nameclient) {
		this.nameclient = nameclient;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCodePayement() {
		return codepayement;
	}

	public void setCodePayement(int codepayement) {
		this.codepayement = codepayement;
	}

	public boolean isReserve() {
		return reserve;
	}

	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}
}
