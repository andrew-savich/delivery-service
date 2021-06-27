package com.andrewsavich.exposit.deliveryservice.model.cart;

import com.andrewsavich.exposit.deliveryservice.model.Product;
import com.andrewsavich.exposit.deliveryservice.model.store.Position;

public class Item {
	private String title;
	private Product product;
	private int quantity;
	private double price;
	
	public Item (Position position) {
		this.title = position.getTitle();
		this.product = position.getProduct();
		this.quantity = 1;
		this.price = position.getPrice();
	}

	public String getTitle() {
		return title;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}
	
}
