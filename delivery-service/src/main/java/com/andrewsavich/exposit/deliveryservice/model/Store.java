package com.andrewsavich.exposit.deliveryservice.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
	private int id;
	private String title;
	private String description;
	private ArrayList<StorePosition> positions;

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

	public ArrayList<StorePosition> getPositions() {
		return positions;
	}

	public void setPositions(ArrayList<StorePosition> positions) {
		this.positions = positions;
	}

	public void addPosition(StorePosition position) {
		if (positions.contains(position)) {
			int indexExistingPosition = positions.indexOf(position);
			int quantityProductsInExistingPosition = positions.get(indexExistingPosition).getQuantity();
			positions.get(indexExistingPosition).setQuantity(++quantityProductsInExistingPosition);
			return;
		}
		
		position.setStore(this);
		positions.add(position);
	}

	public void showAllPositions() {
		if (positions.isEmpty()) {
			System.out.println("Our delivery servise has no positions");
			return;
		}

		for (StorePosition position : positions) {
			System.out.println(position);
		}
	}

	public ArrayList<StorePosition> sortPositionsByPriceUp() {
		List<StorePosition> sortedPositionsByPriceUp = getPositions().stream()
				.sorted(Comparator.comparing(StorePosition::getPrice)).collect(Collectors.toList());

		return new ArrayList<StorePosition>(sortedPositionsByPriceUp);
	}

	public ArrayList<StorePosition> sortPositionsByPriceDown() {
		List<StorePosition> sortedPositionsByPriceDown = getPositions().stream()
				.sorted(Comparator.comparing(StorePosition::getPrice).reversed()).collect(Collectors.toList());

		return new ArrayList<StorePosition>(sortedPositionsByPriceDown);
	}

}
