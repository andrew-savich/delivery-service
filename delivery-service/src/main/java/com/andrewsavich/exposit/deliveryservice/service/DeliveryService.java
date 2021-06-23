package com.andrewsavich.exposit.deliveryservice.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.andrewsavich.exposit.deliveryservice.model.Client;
import com.andrewsavich.exposit.deliveryservice.model.Order;
import com.andrewsavich.exposit.deliveryservice.model.Store;
import com.andrewsavich.exposit.deliveryservice.model.StorePosition;

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
			System.out.println("The client: " + client + " exists in our delivery service");
			return;
		}

		clients.add(client);
	}

	public List<StorePosition> getAllPositions() {
		List<StorePosition> allStorePositions = new ArrayList<>();

		for (Store store : stores) {
			allStorePositions.addAll(store.getPositions());
		}

		return allStorePositions;
	}

	public void showAllPositions() {
		List<StorePosition> allPositions = getAllPositions();

		if (allPositions.isEmpty()) {
			System.out.println("Our delivery service has no positions of products");
			return;
		}

		for (StorePosition position : allPositions) {
			System.out.println(position);
		}
	}
	
	public List<StorePosition> sortPositionsByPrice(){
		
		return getAllPositions().stream().sorted(Comparator.comparing(StorePosition::getPrice)).collect(Collectors.toList());
		
	}
	
	public void showSortedPositionsByPriceUp() {
		List<StorePosition> sortedPositionsByPriceUp = sortPositionsByPrice();

		for (StorePosition position : sortedPositionsByPriceUp) {
			System.out.println(position);
		}
	}
	
	public void showSortedPositionsByPriceDown() {
		List<StorePosition> sortedPositionsByPriceDown = sortPositionsByPrice().stream().sorted(Comparator.comparing(StorePosition::getPrice).reversed()).collect(Collectors.toList());;

		for (StorePosition position : sortedPositionsByPriceDown) {
			System.out.println(position);
		}
	}
	
	public List<StorePosition> getPositionsFormStore(Store store){
		if (!stores.contains(store)) {
			throw new IllegalArgumentException("The store + " + store.getTitle() + " hasn't been registerein our service");
		}
		
		return store.getPositions();
	}

}
