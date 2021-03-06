package it.uniroma3.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@NamedQuery(name = "findAll", query = "SELECT p FROM Picture p")
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	@NotNull
	@Size(min = 1)
	private String title;
	@Column(nullable = false)
	@NotNull
	private Integer year;
	@Column(nullable = false)
	@NotNull
	@Size(min = 1)
	private String technique;
	@Column(nullable = false)
	@NotNull
	@Size(min = 1)
	private String dimension;
   
	@ManyToOne
	private Author author;
	
	
	public Picture(){ }
	
	public Picture(String title, Integer year, String technique, String dimension, Author author){
		this.title = title; 
		this.year = year; 
		this.technique = technique; 
		this.dimension = dimension; 
		this.author = author; 
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getTechnique() {
		return this.technique;
	}

	public void setTechnique(String technique) {
		this.technique = technique;
	}


	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	
	
	
	

}