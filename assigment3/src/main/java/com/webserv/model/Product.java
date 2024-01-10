package com.webserv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(name="title")
	String title;
	
	@Column(name="quantity")
	int quantity;
	
	@Column(name="size")
	String size;
	
	@Column(name = "image")
	String imageData;

	
	public Product() {
		super();
	}

	public Product(String title, int quantity, String size, String imageData) {
		super();
		this.title = title;
		this.quantity = quantity;
		this.size = size;
		this.imageData = imageData;
	}

	public Product(int id, String title, int quantity, String size, String imageData) {
		super();
		this.id = id;
		this.title = title;
		this.quantity = quantity;
		this.size = size;
		this.imageData = imageData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getImageLink() {
		return imageData;
	}

	public void setImageLink(String imageData) {
		this.imageData = imageData;
	}
}
