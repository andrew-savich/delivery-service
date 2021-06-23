package com.andrewsavich.exposit.deliveryservice.model;

public class StorePosition {
	private String title;
	private Product product;
	private double price;
	private int quantity;
	private Store store;
	
	public StorePosition(Product product, double price, int quantity) {
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.title = product.getTitle();
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
		StorePosition other = (StorePosition) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StorePosition [title=" + title + ", product=" + product + ", price=" + price + ", quantity=" + quantity
				+ ", store=" + store + "]";
	}
	
	
}
