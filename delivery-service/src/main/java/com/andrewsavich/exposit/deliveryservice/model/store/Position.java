package com.andrewsavich.exposit.deliveryservice.model.store;

import com.andrewsavich.exposit.deliveryservice.model.product.Product;

public class Position {
	private String title;
	private Product product;
	private double price;
	private int quantity;
	private Store store;
	
	public Position(Product product, double price, int quantity, Store store) {
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.title = product.getTitle();
		this.store = store;
	}
	
	public Position(Product product, double price, Store store) {
		this.product = product;
		this.price = price;
		this.quantity = 1;
		this.title = product.getTitle();
		this.store = store;
	}
	
	public String getTitle() {
		return title;
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
	
	public void increaseQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	public void decreaseQuantity() {
		--this.quantity;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [title=" + title + ", product=" + product + ", price=" + price + ", quantity=" + quantity
				+ ", store=" + store + "]";
	}
	
	
}
