package com.andrewsavich.exposit.deliveryservice.model;

public class Client {
	private int id;
	private String fullName;
	private String fullAddress;
	
	public Client(int id, String fullName, String fullAddress) {
		this.id = id;
		this.fullName = fullName;
		this.fullAddress = fullAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	
}
