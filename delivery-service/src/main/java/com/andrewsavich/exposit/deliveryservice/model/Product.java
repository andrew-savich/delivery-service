package com.andrewsavich.exposit.deliveryservice.model;

public class Product {
	
	private int id;
	private String title;
	private String description;
	private ProductType type;
	
	public Product(int id, String title, String description, ProductType type) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.type = type;
	}

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

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", type=" + type + "]";
	}
	
	
}
