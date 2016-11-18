package ro.bydl.service;

import ro.bydl.domain.Vehicle;

public class Main {

	public static void main(String[] args) {
		VehicleService s=new VehicleService();
		
		Vehicle vehicle=new Vehicle();
		vehicle.setBrand("dacia");
		
		System.err.println("dd "+vehicle.getBrand());
		s.refineVehicleContent(vehicle);
		System.err.println("dd "+vehicle.getBrand());

	}

}
