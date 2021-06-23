package com.andrewsavich.exposit.deliveryservice.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int id;
	private Client client;
	private List<Product> products = new ArrayList<>();
	
	public Order(int id, Client client, List<Product> products) {
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
}
