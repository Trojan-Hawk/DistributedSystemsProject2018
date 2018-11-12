package ie.gmit.sw;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;
import java.util.Date;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService{
	
	private BookingsDatabase bd;
	private String sqlStatement = "";
	
	protected DatabaseServiceImpl() throws RemoteException {
		super();
		this.bd = new BookingsDatabase();
	}

	@Override
	public String CreateBooking(Booking b) throws RemoteException {
		/* DATE ISSUE NEEDS TO BE FIXED HERE****************************************************************************************************
		// convert java.util.date object to a java.sql.date object
		// java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		// java.sql.Date sDate = java.sql.Date.valueOf(df.format(date));
		// String sDate = df.format(date);
		java.sql.Date sDate = new java.sql.Date(System.currentTimeMillis());
		System.out.println(sDate.toString());
		System.out.println(df.format(sDate));
		*/
		sqlStatement = "insert into booking values(" + b.getBookingID() + ", " + b.getCustomerId() + ", '" + b.getVehicleReg() + "', " + b.getDate() + ")";
		String result = bd.ExecuteInsertStatement(sqlStatement);
		/*
		// sqlInsert = "insert into booking values(" + bookingId + ", " + customerId + ", '" + regNo + "', DATE_FORMAT(" + sDate.toString() + ", '%Y/%m/%d'))";
		sqlInsert = "insert into booking values(" + bookingId + ", " + customerId + ", '" + regNo + "', " + "1970/10/2" + ")";
		bd.ExecuteStatement(sqlInsert);
		*/
		return result;
	}

	@Override
	public String CreateVehicle(Vehicle v) throws RemoteException {
		sqlStatement = "insert into vehicle values('" + v.getRegNo() + "', '" + v.getBrand() + "', '" + v.getModel() + "')";
		bd.ExecuteInsertStatement(sqlStatement);
		return "Vehicle " + v.getBrand() + " " + v.getModel() + " added sucessfuly!";
	}

	@Override
	public String CreateCustomer(Customer c) throws RemoteException {
		sqlStatement = "insert into customer values(" + c.getCustomerID() + ", '" + c.getFirstName() + "', '" + c.getLastName() + "')";
		bd.ExecuteInsertStatement(sqlStatement);
		return "Customer " + c.getFirstName() + " " + c.getLastName() + " added sucessfuly!";
	}

	@Override
	public String ReadBooking(Booking b) throws RemoteException {
		// sqlStatement = "SELECT * FROM booking WHERE bookingId = " + bookingID;
		String str = bd.ExecuteReadStatement(sqlStatement, "Booking");
		return str;
	}

	@Override
	public String ReadVehicle(Vehicle v) throws RemoteException {
		sqlStatement = "SELECT * FROM vehicle WHERE regNo LIKE '" + v.getRegNo() + "' OR regNo LIKE \"" + v.getRegNo() + "\"";
		String str = bd.ExecuteReadStatement(sqlStatement, "Vehicle");
		return str;
	}

	@Override
	public String ReadCustomer(Customer c) throws RemoteException {
		sqlStatement = "SELECT * FROM customer WHERE customerId = " + c.getCustomerID();
		String str = bd.ExecuteReadStatement(sqlStatement, "Customer");
		return str;
	}

	@Override
	public String UpdateBooking(Booking b) throws RemoteException {
		sqlStatement = "Update booking SET bookingId=" + b.getBookingID() + ", customerId=" + b.getCustomerId() + ", regNo='" + b.getVehicleReg() + "', bookingdate=" + b.getDate() + " WHERE bookingId = " + b.getBookingID();
		String result = bd.ExecuteUpdateStatement(sqlStatement);
		return result;
	}

	@Override
	public String UpdateVehicle(Vehicle v) throws RemoteException {

		return null;
	}

	@Override
	public String UpdateCustomer(Customer c) throws RemoteException {

		return null;
	}

	@Override
	public String DeleteBooking(Booking b) throws RemoteException {
		sqlStatement = "DELETE FROM booking WHERE bookingId = " + b.getBookingID();
		String result = bd.ExecuteDeleteStatement(sqlStatement);
		return result;
	}

	@Override
	public String DeleteVehicle(Vehicle v) throws RemoteException {

		return null;
	}

	@Override
	public String DeleteCustomer(Customer c) throws RemoteException {

		return null;
	}

}
