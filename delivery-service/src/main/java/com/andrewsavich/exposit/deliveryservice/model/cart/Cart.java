package com.andrewsavich.exposit.deliveryservice.model.cart;

import java.util.ArrayList;
import java.util.List;

import com.andrewsavich.exposit.deliveryservice.model.Client;

public class Cart {
	private Client client;
	private List<Item> items = new ArrayList<>();

	public Cart(Client client) {
		this.client = client;
	}

	public void addItem(Item item) {
		if (items.contains(item)) {
			int indexOfExistItem = items.indexOf(item);
			int quantityItems = items.get(indexOfExistItem).getQuantity();
			items.get(indexOfExistItem).setQuantity(++quantityItems);
		}
		
		items.add(item);
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
	
	public double getSummaryCartPrice() {
		double summaryPrice = 0.0;
		
		for(Item item : items) {
			summaryPrice += item.getSummaryItemPrice();
		}
		
		return summaryPrice;
	}

}
