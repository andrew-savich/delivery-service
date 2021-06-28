package com.andrewsavich.exposit.deliveryservice.dataload;

import java.util.List;

public interface DataLoader<T> {
	List<T> load();
}
