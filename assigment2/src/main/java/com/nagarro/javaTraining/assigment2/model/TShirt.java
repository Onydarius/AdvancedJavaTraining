package com.nagarro.javaTraining.assigment2.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TShirt")
public class TShirt {

	@Id
	private String id;
	
	@Column(name = "name", length = 150)
	private String name;
	
	@Column(name = "colour", length = 50)
	private String colour;
	
	@Column(name = "gender",  length = 1)
	private String GENDER_RECOMMENDATION;
	
	@Column(name = "size", length = 4)
	private String size;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "rating")
	private float rating;
	
	@Column(name = "availability", length = 20)
	private String availability;

	// Constructor
	public TShirt() {
	}

	public TShirt(String color, String size, String gender, double price, float rating) {
		this.colour = color;
		this.size = size;
		this.GENDER_RECOMMENDATION = gender;
		this.price = price;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getId() {
		return id;
	}

	public String getColour() {
		return colour;
	}

	public String getGender() {
		return GENDER_RECOMMENDATION;
	}

	public double getPrice() {
		return price;
	}

	public float getRating() {
		return rating;
	}

	public String getSize() {
		return size;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setGender(String gender) {
		this.GENDER_RECOMMENDATION = gender;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name + ", Color: " + colour + ", Gender: " + GENDER_RECOMMENDATION + ", Size: " + size
				+ ", Price: " + price + ", Rating: " + rating + ", Availability: " + availability;
	}

}
