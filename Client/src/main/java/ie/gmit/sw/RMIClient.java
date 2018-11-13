package ie.gmit.sw;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

public class RMIClient {
		
	DatabaseService ds = null;
	private String values = null;
	private String result = null;

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
	
	// Booking CRUD operation method calls
	public String CreateBooking(int bookingID, String vehicleReg, int customerId, Date date) throws RemoteException{
		Booking b = new Booking(bookingID, customerId, vehicleReg, date);

		result = ds.CreateBooking(b);
		return result;
	}
	
	public String ReadBooking(int bookingID, String vehicleReg, int customerId, Date date) throws RemoteException {
		Booking b = new Booking(bookingID, customerId, vehicleReg, date);
		result = ds.ReadBooking(b);
		return result;
	}
	
	public String UpdateBooking(int bookingID, String vehicleReg, int customerId, Date date) throws RemoteException {
		Booking b = new Booking(bookingID, customerId, vehicleReg, date);
		
		result = ds.UpdateBooking(b);
		return result;
	}
	
	public String DeleteBooking(int bookingID, String vehicleReg, int customerId, Date date) throws RemoteException {
		Booking b = new Booking(bookingID, customerId, vehicleReg, date);
		
		result = ds.DeleteBooking(b);
		return result;
	}

	// Customer CRUD operation method calls
	public String CreateCustomer(int customerID, String firstName, String lastName) throws RemoteException {
		Customer c = new Customer(customerID, firstName, lastName);
		
		result = ds.CreateCustomer(c);
		return result;
	}
	
	public String ReadCustomer(int customerID, String firstName, String lastName) throws RemoteException {
		Customer c = new Customer(customerID, firstName, lastName);

		result = ds.ReadCustomer(c);
		return result;
	}
	
	public String UpdateCustomer(int customerID, String firstName, String lastName) throws RemoteException {
		Customer c = new Customer(customerID, firstName, lastName);

		result = ds.UpdateCustomer(c);
		return result;
	}
	
	public String DeleteCustomer(int customerID, String firstName, String lastName) throws RemoteException {
		Customer c = new Customer(customerID, firstName, lastName);
		
		result = ds.DeleteCustomer(c);
		return result;
	}

	// Vehicle CRUD operation calls
	public String CreateVehicle(String regNo, String brand, String model) throws RemoteException{
		Vehicle v = new Vehicle(regNo, brand, model);

		result = ds.CreateVehicle(v);
		return result;
	}

	public String ReadVehicle(String regNo, String brand, String model) throws RemoteException {
		Vehicle v = new Vehicle(regNo, brand, model);

		result = ds.ReadVehicle(v);
		return result;
	}

	public String UpdateVehicle(String regNo, String brand, String model) throws RemoteException {
		Vehicle v = new Vehicle(regNo, brand, model);
		
		result = ds.UpdateVehicle(v);
		return result;
	}	

	public String DeleteVehicle(String regNo, String brand, String model) throws RemoteException {
		Vehicle v = new Vehicle(regNo, brand, model);

		result = ds.DeleteVehicle(v);
		return result;
	}
}