package com.nagarro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TShirts")

public class TShirt {
	@Id
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "colour")
	private String colour;

	@Column(name = "gender",  length = 1)
	private String GENDER_RECOMMENDATION;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "rating")
	private float rating;
	
	@Column(name = "availability")
	private char availability;

	public TShirt() {
		super();
	}

	public TShirt(String name, String colour, String genderRecomendation, String size, float price, float rating,
			char availability) {
		super();
		this.name = name;
		this.colour = colour;
		this.GENDER_RECOMMENDATION = genderRecomendation;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getGenderRecomendation() {
		return GENDER_RECOMMENDATION;
	}

	public void setGenderRecomendation(String genderRecomendation) {
		this.GENDER_RECOMMENDATION = genderRecomendation;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public char getAvailability() {
		return availability;
	}

	public void setAvailability(char availability) {
		this.availability = availability;
	}
}
