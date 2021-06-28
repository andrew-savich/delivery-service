package com.andrewsavich.exposit.deliveryservice.dataload.product;

import java.util.List;

public interface DataLoader<T> {
	List<T> load();
}
