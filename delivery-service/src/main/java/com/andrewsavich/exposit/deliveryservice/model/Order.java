package com.andrewsavich.exposit.deliveryservice.model;

import java.util.ArrayList;
import java.util.List;

import com.andrewsavich.exposit.deliveryservice.model.cart.Item;

public class Order {
	private int id;
	private Client client;
	private List<Item> items;
	
	public Order(int id, Client client, List<Item> items) {
		this.id = id;
		this.client = client;
		this.items = new ArrayList<>(items);
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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", client=" + client + ", items=" + items + "]";
	}

	
	
}
