package com.andrewsavich.exposit.deliveryservice;

import java.util.List;

import com.andrewsavich.exposit.deliveryservice.dataload.product.DataLoader;
import com.andrewsavich.exposit.deliveryservice.dataload.product.DataLoaderFromJson;
import com.andrewsavich.exposit.deliveryservice.model.Client;
import com.andrewsavich.exposit.deliveryservice.model.product.Product;
import com.andrewsavich.exposit.deliveryservice.model.store.Store;
import com.andrewsavich.exposit.deliveryservice.service.DeliveryService;

public class DeliveryDemoRunner {

	public static void main(String[] args) {

		DataLoader<Product> productsLoader = new DataLoaderFromJson<>("products.json", Product.class);
		DataLoader<Store> storesLoader = new DataLoaderFromJson<>("stores.json", Store.class);
		DataLoader<Client> clientsLoader = new DataLoaderFromJson<>("clients.json", Client.class);

		List<Product> products = productsLoader.load();
		List<Store> stores = storesLoader.load();
		List<Client> clients = clientsLoader.load();

		DeliveryService deliveryService = new DeliveryService("Test delivery serice");

		for (Product product : products) {
			double randomPrice = (Math.random() * 700) + 300;
			int randomQuantity = (int) ( Math.random() * 15 );
			stores.get(0).createPosition(product, randomPrice, randomQuantity);
		}
		

		for (Product product : products) {
			double randomPrice = (Math.random() * 700) + 300;
			int randomQuantity = (int) ( Math.random() * 15 );
			stores.get(1).createPosition(product, randomPrice, randomQuantity);
		}
		
		for(Store store : stores) {
			deliveryService.registerNewStore(store);
		}
		
		for (Client client : clients){
			deliveryService.registerNewClient(client);
		}
		
		deliveryService.showAllPositions();
		deliveryService.showAllClients();
		
		Client andrew = deliveryService.getClientByUsername("andrewsavich");
		Client some = deliveryService.getClientByUsername("someclient");
		
		deliveryService.addProductsToClientCart(andrew, 5, 2);
		deliveryService.addProductsToClientCart(andrew, 2, 1);
		
		deliveryService.addProductsToClientCart(some, 1, 1);
		deliveryService.addProductsToClientCart(some, 9, 1);
		
		deliveryService.showClientCart(andrew);
		deliveryService.showClientCart(some);
		
		deliveryService.deliverProductsToClient(andrew);
		deliveryService.deliverProductsToClient(some);
		
		deliveryService.showAllPositions();
		deliveryService.showAllOrders();
		

	}

}
