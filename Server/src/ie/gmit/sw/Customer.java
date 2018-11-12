package ie.gmit.sw;

import java.io.Serializable;

public class Customer implements Serializable {
	private int customerID;
	private String firstName;
	private String lastName;
	
	public Customer(int customerID, String firstName, String lastName) {
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getCustomerID() {
		return customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String toString() {
		return "CustomerID: " + customerID + ", Forename: " + firstName + ", Surname: " + lastName;
	}
	
}
