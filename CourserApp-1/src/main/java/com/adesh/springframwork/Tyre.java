package com.adesh.springframwork;

public class Tyre {

	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	// to print the data of the tyre
	@Override
	public String toString() {
		return "Tyre [brand=" + brand + "]";
	}

	public Tyre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
