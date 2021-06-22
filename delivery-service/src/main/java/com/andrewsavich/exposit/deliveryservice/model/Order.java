package com.andrewsavich.exposit.deliveryservice.model;

import java.util.ArrayList;

public class Order {
	private int id;
	private Client client;
	private ArrayList<Product> products;
	
	public Order(int id, Client client, ArrayList<Product> products) {
		this.id = id;
		this.client = client;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
}
