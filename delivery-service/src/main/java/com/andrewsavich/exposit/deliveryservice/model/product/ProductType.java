package com.andrewsavich.exposit.deliveryservice.model.product;

public enum ProductType {
	PRODUCT(null),
		ELECTRONICS(PRODUCT),
			SMARTPHONE(ELECTRONICS),
			LAPTOP(ELECTRONICS),
			TV(ELECTRONICS),
		CLOTHES(PRODUCT),
			TSHIRT(CLOTHES),
			PANTS(CLOTHES),
			PARKA(CLOTHES),
		FOOD(PRODUCT),
			MEAT(FOOD),
			MILKY(FOOD),
			BREAD(FOOD);

	private ProductType parent = null;

	private ProductType(ProductType parent) {
		this.parent = parent;
	}

	public boolean is(ProductType otherType) {
		if (otherType == null) {
			return false;
		}

		for (ProductType type = this; type != null; type = type.parent) {
			if (otherType == type) {
				return true;
			}
		}
		return false;
	}

}
