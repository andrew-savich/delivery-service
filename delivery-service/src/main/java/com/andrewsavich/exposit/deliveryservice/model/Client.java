package com.andrewsavich.exposit.deliveryservice.model;

public class Client {
	private String username;
	private String fullName;
	private String address;
	
	public Client(String username, String fullName, String address) {
		this.username = username;
		this.fullName = fullName;
		this.address = address;
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
	


}
