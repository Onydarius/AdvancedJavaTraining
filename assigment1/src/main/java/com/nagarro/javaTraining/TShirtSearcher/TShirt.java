package com.nagarro.javaTraining.TShirtSearcher;

import com.opencsv.bean.CsvBindByName;

public class TShirt {

    @CsvBindByName
    private String id;
    @CsvBindByName(column = "NAME")
    private String name;
    @CsvBindByName(column = "COLOUR")
    private String color;
    @CsvBindByName(column = "GENDER_RECOMMENDATION")
    private String gender;
    @CsvBindByName(column = "SIZE")
    private String size;
    @CsvBindByName(column = "PRICE")
    private double price;
    @CsvBindByName(column = "RATING")
    private float rating;
    @CsvBindByName(column = "AVAILABILITY")
    private String availability;


    // Constructor
    public TShirt() {
    }

    public TShirt(String color, String size, String gender, double price, float rating) {
        this.color = color;
        this.size = size;
        this.gender = gender;
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

    public String getColor() {
        return color;
    }

    public String getGender() {
        return gender;
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

    public void setColor(String color) {
        this.color = color;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
		return "ID: " + id + ", Name: " + name + ", Color: " + color + ", Gender: " + gender + ", Size: " + size
				+ ", Price: " + price + ", Rating: " + rating + ", Availability: " + availability;
	}

    
}
