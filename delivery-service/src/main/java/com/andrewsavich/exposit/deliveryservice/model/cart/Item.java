package com.andrewsavich.exposit.deliveryservice.model.cart;

import com.andrewsavich.exposit.deliveryservice.model.product.Product;
import com.andrewsavich.exposit.deliveryservice.model.store.Position;
import com.andrewsavich.exposit.deliveryservice.model.store.Store;

public class Item {
	private String title;
	private Product product;
	private int quantity;
	private double price;
	private Store store;
	
	public Item (Position position, int quantity) {
		this.title = position.getTitle();
		this.product = position.getProduct();
		this.quantity += quantity ;
		this.price = position.getPrice();
		this.store = position.getStore();
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

	@Override
	public String toString() {
		return "Item [title=" + title + ", product=" + product.getTitle() + ", from store: " + store.getTitle() + " quantity=" + quantity + ", price one=" + price + " summary price: " + price * quantity + "]";
	}
	
}
