package com.andrewsavich.exposit.deliveryservice.model.product;

public class Product {
	
	private String title;
	private String description;
	private ProductType type;
	
	public Product(String title, String description, ProductType type) {
		this.title = title;
		this.description = description;
		this.type = type;
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
		return "Product [title=" + title + ", description=" + description + ", type=" + type + "]";
	}
	
	
}
