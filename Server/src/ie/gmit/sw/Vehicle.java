package ie.gmit.sw;

import java.io.Serializable;

public class Vehicle implements Serializable {
	
	private String regNo;
	private String brand;
	private String model;
	
	public Vehicle(String regNo, String brand, String model) {
		this.regNo = regNo;
		this.brand = brand;
		this.model = model;
	}

	public String toString() {
		return "RegNo: " + regNo + ", Brand: " + brand + ", Model: " + model;
	}

	public String getRegNo() {
		return regNo;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}
}
