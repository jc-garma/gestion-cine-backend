package com.gestion.cine.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Film implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String description;

	private String photo;

	private String director;

	private String releasedate;

	private String duration;
	
	@OneToMany(mappedBy = "film")
	@JsonIgnore
	private Collection<Projection> projections;

	@ManyToOne
	private Category category;

	public Film() {

	}

	public Film(String title, String description, String photo, String director, String releasedate, String duration) {
		this.title = title;
		this.description = description;
		this.photo = photo;
		this.director = director;
		this.releasedate = releasedate;
		this.duration = duration;
	}

	public Film(String title, String description, String photo, String director, String releasedate, String duration,
			Collection<Projection> projections, Category category) {
		this.title = title;
		this.description = description;
		this.photo = photo;
		this.director = director;
		this.releasedate = releasedate;
		this.duration = duration;
		this.projections = projections;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getReleaseDate() {
		return releasedate;
	}

	public void setReleaseDate(String releasedate) {
		this.releasedate = releasedate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Collection<Projection> getProjections() {
		return projections;
	}

	public void setProjections(Collection<Projection> projections) {
		this.projections = projections;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
