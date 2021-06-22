package com.andrewsavich.exposit.deliveryservice.model;

public class Delivery {
	private int id;
	private Client client;
	private Order order;

	public Delivery(int id, Client client, Order order) {
		this.id = id;
		this.client = client;
		this.order = order;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
