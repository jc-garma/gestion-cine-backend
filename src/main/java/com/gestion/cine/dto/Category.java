package com.gestion.cine.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category")
public class Category implements Serializable{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 private String name;

	 @Column(length = 75)
	 @OneToMany(mappedBy = "category")
	 @JsonIgnore
	 private Collection<Film> films;

	 public Category() {
	  
	 }
	    
	 public Category(String name, Collection<Film> films) {
	    this.name = name;
	    this.films = films;
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

	 public Collection<Film> getFilms() {
	    return films;
	 }

	 public void setFilms(Collection<Film> films) {
	    this.films = films;
	 }

}
