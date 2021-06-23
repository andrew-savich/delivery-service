package com.andrewsavich.exposit.deliveryservice.model;

public class StorePosition {
	private Product product;
	private double price;
	private int quantity;
	
	public StorePosition(Product product, double price, int quantity) {
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
