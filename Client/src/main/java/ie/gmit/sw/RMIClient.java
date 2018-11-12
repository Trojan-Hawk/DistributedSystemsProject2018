package ie.gmit.sw;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

public class RMIClient {
		
	DatabaseService ds = null;
	private String values = null;

	public RMIClient() {
		try {
			this.ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/databaseservice");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String CreateBooking(int bookingID, String vehicleReg, int customerId, Date date) throws RemoteException{
		Booking b = new Booking(bookingID, customerId, vehicleReg, date);

		String result = ds.CreateBooking(b);
		return result;
	}

	public String CreateVehicle(String regNo, String brand, String model){
		Vehicle v = new Vehicle(regNo, brand, model);
		try {
			ds.CreateVehicle(v);
			return "Vehicle created!";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Vehicle NOT created!";
		}
	}

	public String CreateCustomer(int customerID, String firstName, String lastName) throws RemoteException {
		Customer c = new Customer(customerID, firstName, lastName);
		try {
			ds.CreateCustomer(c);
			return "Customer created!";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Customer NOT created!";
		}
	}

	public String ReadBooking(int bookingID, String vehicleReg, int customerId, Date date) throws RemoteException {
		Booking b = new Booking(bookingID, customerId, vehicleReg, date);
		try {
			values = ds.ReadBooking(b);
			return values;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String ReadVehicle(String regNo, String brand, String model) throws RemoteException {
		Vehicle v = new Vehicle(regNo, brand, model);
		try {
			values = ds.ReadVehicle(v);
			return values;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String ReadCustomer(int customerID, String firstName, String lastName) throws RemoteException {
		Customer c = new Customer(customerID, firstName, lastName);
		try {
			values = ds.ReadCustomer(c);
			return values;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String UpdateBooking(int bookingID, String vehicleReg, int customerId, Date date) throws RemoteException {
		Booking b = new Booking(bookingID, customerId, vehicleReg, date);
		
		String result = ds.UpdateBooking(b);
		
		return result;
	}

	public String UpdateVehicle(String regNo, String brand, String model) throws RemoteException {
		Vehicle v = new Vehicle(regNo, brand, model);
		
		return null;
	}

	public String UpdateCustomer(int customerID, String firstName, String lastName) throws RemoteException {
		Customer c = new Customer(customerID, firstName, lastName);
		try {
			ds.UpdateCustomer(c);
			return "Customer updated!";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "Customer NOT updated!";
		}
	}

	public String DeleteBooking(int bookingID, String vehicleReg, int customerId, Date date) throws RemoteException {
		Booking b = new Booking(bookingID, customerId, vehicleReg, date);
		
		String result = ds.DeleteBooking(b);
		
		return result;
	}

	public String DeleteVehicle(String regNo, String brand, String model) throws RemoteException {
		Vehicle v = new Vehicle(regNo, brand, model);
		
		return null;
	}

	public String DeleteCustomer(int customerID, String firstName, String lastName) throws RemoteException {
		Customer c = new Customer(customerID, firstName, lastName);
		
		return null;
	}
}