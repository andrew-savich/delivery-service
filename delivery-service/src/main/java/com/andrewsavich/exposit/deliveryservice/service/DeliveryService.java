package com.andrewsavich.exposit.deliveryservice.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.andrewsavich.exposit.deliveryservice.model.Client;
import com.andrewsavich.exposit.deliveryservice.model.Order;
import com.andrewsavich.exposit.deliveryservice.model.Store;
import com.andrewsavich.exposit.deliveryservice.model.Position;

public class DeliveryService {
	private String title;
	private int orderId = 0;

	private List<Store> stores = new ArrayList<>();
	private Map<String, Client> clients = new HashMap<>();
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
		if (clients.containsKey(client.getUsername())) {
			System.out.println("The client with username: " + client.getUsername() + " exists in our delivery service");
			return;
		}

		clients.put(client.getUsername(), client);
	}

	public void registerNewClient(String username, String fullName, String address) {
		Client newClient = new Client(username, fullName, address);

		if (clients.containsKey(newClient.getUsername())) {
			System.out.println("Client with username: " + newClient.getUsername() + " already exist in our system");
			return;
		}

		clients.put(newClient.getUsername(), newClient);
	}

	public void removeClient(Client client) {
		if (clients.containsKey(client.getUsername())) {
			clients.remove(client.getUsername());
			System.out.println("Client " + client.getUsername() + " was removed from our system");
			return;
		}

		System.out.println("Client " + client.getUsername() + " didn't register in our system");
	}

	public Client getClientByUsername(String username) {
		if (clients.containsKey(username)) {
			Client client = clients.get(username);
			return client;
		}

		throw new IllegalArgumentException("Client " + username + " doesn't exist in our system");
	}

	public List<Position> getAllPositions() {
		List<Position> allStorePositions = new ArrayList<>();

		for (Store store : stores) {
			allStorePositions.addAll(store.getPositions());
		}

		return allStorePositions;
	}

	public void showAllPositions() {
		List<Position> allPositions = getAllPositions();

		if (allPositions.isEmpty()) {
			System.out.println("Our delivery service has no positions of products");
			return;
		}

		for (Position position : allPositions) {
			System.out.println(position);
		}
	}

	public void showSortedPositionsByPriceUp() {
		List<Position> sortedPositionsByPriceUp = getAllPositions().stream()
				.sorted(Comparator.comparing(Position::getPrice)).collect(Collectors.toList());

		for (Position position : sortedPositionsByPriceUp) {
			System.out.println(position);
		}
	}

	public void showSortedPositionsByPriceDown() {
		List<Position> sortedPositionsByPriceDown = getAllPositions().stream()
				.sorted(Comparator.comparing(Position::getPrice).reversed()).collect(Collectors.toList());

		for (Position position : sortedPositionsByPriceDown) {
			System.out.println(position);
		}
	}

	public List<Position> getPositionsFormStore(Store store) {
		if (!stores.contains(store)) {
			throw new IllegalArgumentException(
					"The store + " + store.getTitle() + " hasn't been registerein our service");
		}

		return store.getPositions();
	}

	public List<Position> getPositionsByPrice(double minPrice, double maxPrice) {
		if (minPrice < 0 || maxPrice <= 0) {
			throw new IllegalArgumentException("Invalid price (less than zero)");
		}

		if (minPrice > maxPrice) {
			throw new IllegalArgumentException("Invalid price (min price is bigger than max price)");
		}

		List<Position> positionsByPrice = new ArrayList<>();

		for (Position position : getAllPositions()) {
			if (position.getPrice() >= minPrice && position.getPrice() <= maxPrice) {
				positionsByPrice.add(position);
			}
		}

		return positionsByPrice;

	}

}
