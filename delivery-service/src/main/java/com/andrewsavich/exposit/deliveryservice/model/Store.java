package com.andrewsavich.exposit.deliveryservice.model;

import java.util.ArrayList;

public class Store {
	private int id;
	private String title;
	private String description;
	private ArrayList<Product> products;
	
	public Store(int id, String title, String description, ArrayList<Product> products) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.products = products;
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

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
}
