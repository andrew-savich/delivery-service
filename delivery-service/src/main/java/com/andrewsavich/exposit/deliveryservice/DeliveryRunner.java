package com.andrewsavich.exposit.deliveryservice;

import com.andrewsavich.exposit.deliveryservice.model.Client;
import com.andrewsavich.exposit.deliveryservice.model.product.Product;
import com.andrewsavich.exposit.deliveryservice.model.product.ProductType;
import com.andrewsavich.exposit.deliveryservice.model.store.Store;
import com.andrewsavich.exposit.deliveryservice.service.DeliveryService;

public class DeliveryRunner {

	public static void main(String[] args) {
		Product ipnoneX = new Product("iPhoneX Grey", "description for iphone x", ProductType.ELECTRONICS);
		Product samsungS20 = new Product("Samsung S20", "description for Samsung S20", ProductType.ELECTRONICS);
		
		Store vek21 = new Store("21 Vek", "Internet store");
		Store element5 = new Store("5 Element", "5 element store");
		
		
		Client andrew = new Client("andrewsavich", "Andrew Savich", "Andrew's address");
		
		DeliveryService deliveryService = new DeliveryService("The 1st delivery serice");
		
		vek21.createPosition(samsungS20, 999.99, 1);
		
		vek21.createPosition(ipnoneX, 1299.99, 8);
		vek21.addProduct(ipnoneX, 521);
		
		vek21.removeProduct(samsungS20);
		
		deliveryService.registerNewStore(vek21);
		deliveryService.registerNewClient(andrew);
		
		deliveryService.showAllPositions();
		deliveryService.showAllClients();
		
		
	}

}
