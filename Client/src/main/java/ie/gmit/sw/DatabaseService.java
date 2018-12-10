package ie.gmit.sw;

import java.rmi.*;

public interface DatabaseService extends Remote {
	public String ReadBookings() throws RemoteException;
	public String ReadCustomers() throws RemoteException;
	public String ReadVehicles() throws RemoteException;
	
	public String CreateBooking(Booking b) throws RemoteException;
	public String CreateVehicle(Vehicle v) throws RemoteException;
	public String CreateCustomer(Customer c) throws RemoteException;
	
	public String ReadBooking(Booking b) throws RemoteException;
	public String ReadVehicle(Vehicle v) throws RemoteException;
	public String ReadCustomer(Customer c) throws RemoteException;
	
	public String UpdateBooking(Booking b) throws RemoteException;
	public String UpdateVehicle(Vehicle v) throws RemoteException;
	public String UpdateCustomer(Customer c) throws RemoteException;
	
	public String DeleteBooking(Booking b) throws RemoteException;
	public String DeleteVehicle(Vehicle v) throws RemoteException;
	public String DeleteCustomer(Customer c) throws RemoteException;
}
