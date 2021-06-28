package com.andrewsavich.exposit.deliveryservice.model.store;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.andrewsavich.exposit.deliveryservice.model.product.Product;

public class Store {
	private String title;
	private String description;
	private List<Position> positions;
	
	public Store() {
		this.positions = new ArrayList<>();
	}

	public Store(String title, String description) {
		this.title = title;
		this.description = description;
		this.positions = new ArrayList<>();
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

	public void createPosition(Product product, double price, int quantity) {
		Position newPosition = new Position(product, price, quantity, this);

		if (positions.contains(newPosition)) {
			System.out
					.println("Position " + product.getTitle() + " is exist, you should add product in this position!");
		} else {
			positions.add(newPosition);
		}
	}

	public void addProduct(Product product, int quantity) {
		if (isExistPositionWithThisProduct(product)) {
			getPositionByProduct(product).increaseQuantity(quantity);
		} else {
			System.out.println("Position " + product.getTitle()
					+ " doesn't exist, you should create position with price and quantity");
		}
	}

	public void removeProducts(Product product, int quantity) {
		Position position = getPositionByProduct(product);
		
		if (position == null) {
			System.out.println("No positions with this product " + product.getTitle());
			return;
		}
		
		position.decreaseQuantity(quantity);
		
		if(position.getQuantity() == 0) {
			position.getStore().removePosition(position);
		}
		
	}

	private void removePosition(Position position) {
		positions.remove(position);
	}

	private boolean isExistPositionWithThisProduct(Product product) {
		for (Position position : positions) {
			if (position.getTitle().equals(product.getTitle())) {
				return true;
			}
		}

		return false;
	}

	private Position getPositionByProduct(Product product) {
		for (Position position : positions) {
			if (position.getTitle().equals(product.getTitle())) {
				return position;
			}
		}

		return null;
	}

	public void showAllPositions() {
		if (positions.isEmpty()) {
			System.out.println("Our delivery servise has no positions");
			return;
		}

		for (Position position : positions) {
			System.out.println(position);
		}
	}

	public List<Position> getPositions() {
		return positions;
	}

	public ArrayList<Position> sortPositionsByPriceUp() {
		List<Position> sortedPositionsByPriceUp = getPositions().stream()
				.sorted(Comparator.comparing(Position::getPrice)).collect(Collectors.toList());

		return new ArrayList<Position>(sortedPositionsByPriceUp);
	}

	public ArrayList<Position> sortPositionsByPriceDown() {
		List<Position> sortedPositionsByPriceDown = getPositions().stream()
				.sorted(Comparator.comparing(Position::getPrice).reversed()).collect(Collectors.toList());

		return new ArrayList<Position>(sortedPositionsByPriceDown);
	}

}
