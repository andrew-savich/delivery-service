package com.andrewsavich.exposit.deliveryservice.model;

import com.andrewsavich.exposit.deliveryservice.model.cart.Cart;

public class Client {
	private String username;
	private String fullName;
	private String address;
	private Cart cart;
	
	public Client() {
		this.cart = new Cart(this);
	}

	public Client(String username, String fullName, String address) {
		this.username = username;
		this.fullName = fullName;
		this.address = address;
		this.cart = new Cart(this);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Cart getCart() {
		return cart;
	}

	@Override
	public String toString() {
		return "Client [username=" + username + ", fullName=" + fullName + ", address=" + address + "]";
	}
	
}
