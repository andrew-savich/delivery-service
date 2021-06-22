package com.andrewsavich.exposit.deliveryservice.model;

import java.util.Set;

public class Product {
	
	private int id;
	private String title;
	private String description;
	private Set<ProductType> type;
	private double price;
	
	public Product(int id, String title, String description, Set<ProductType> type, double price) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.type = type;
		this.price = price;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ProductType> getType() {
		return type;
	}

	public void setType(Set<ProductType> type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
