package com.andrewsavich.exposit.deliveryservice.service;

import java.util.ArrayList;
import java.util.List;

import com.andrewsavich.exposit.deliveryservice.model.Client;
import com.andrewsavich.exposit.deliveryservice.model.Order;
import com.andrewsavich.exposit.deliveryservice.model.Store;

public class DeliveryService {
	private String title;

	private List<Store> stores = new ArrayList<>();
	private List<Client> clients = new ArrayList<>();
	private List<Order> orders = new ArrayList<>();

	public DeliveryService(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void registerNewStore(Store store) {
		if (stores.contains(store)) {
			System.out.println("The store: " + store + " exists in our Delivery Service");
			return;
		}

		stores.add(store);
	}

	public void registerNewClient(Client client) {
		if (clients.contains(client)) {
			System.out.println("The client: " + client + " exists in our Delivery Service");
			return;
		}

		clients.add(client);
	}

	public void showAllProducts() {
		if (stores.isEmpty()) {
			System.out.println("Our delivery service has no products, because registered stores are absent");
			return;
		}

		for (Store store : stores) {
			System.out.println("Products from: " + store.getTitle() + ":");
			store.showProducts();
		}
	}

}
