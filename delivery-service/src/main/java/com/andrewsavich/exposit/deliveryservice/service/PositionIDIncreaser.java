package com.andrewsavich.exposit.deliveryservice.service;

public class PositionIDIncreaser {
	private static int currentPositionID = 0;
	
	private PositionIDIncreaser() {
	}
	
	public static int getPositionID() {
		return currentPositionID++;
	}
}
