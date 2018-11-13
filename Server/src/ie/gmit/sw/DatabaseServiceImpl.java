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
	private String result = null;
	
	protected DatabaseServiceImpl() throws RemoteException {
		super();
		this.bd = new BookingsDatabase();
	}

	// Booking SQL statement builders
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
		sqlStatement = "INSERT INTO customer VALUES(" + b.getBookingID() + ", " + b.getCustomerId() + ", '" + b.getVehicleReg() + "', " + b.getDate() + ")";
		result = bd.ExecuteInsertStatement(sqlStatement);
		/*
		// sqlInsert = "insert into booking values(" + bookingId + ", " + customerId + ", '" + regNo + "', DATE_FORMAT(" + sDate.toString() + ", '%Y/%m/%d'))";
		sqlInsert = "insert into booking values(" + bookingId + ", " + customerId + ", '" + regNo + "', " + "1970/10/2" + ")";
		bd.ExecuteStatement(sqlInsert);
		*/
		return result;
	}

	@Override
	public String ReadBooking(Booking b) throws RemoteException {
		int count = 0;
		sqlStatement = "SELECT * FROM booking";
		if(b.getBookingID() != 0) {
			sqlStatement += " WHERE bookingId = " + b.getBookingID();
			count++;
		}
		if(b.getCustomerId() != 0) {
			sqlStatement += StatementBuilderHelper(count);
			sqlStatement += "customerId = " + b.getCustomerId();
		}
		if(b.getVehicleReg() != null) {
			sqlStatement += StatementBuilderHelper(count);
			sqlStatement += "regNo = " + b.getVehicleReg();
		}
		if(b.getDate() != null) {
			sqlStatement += StatementBuilderHelper(count);
			sqlStatement += "regNo = " + b.getVehicleReg();
		}
		sqlStatement += ";";
		
		result = bd.ExecuteReadStatement(sqlStatement, "Booking");
		return result;
	}
	
	@Override
	public String UpdateBooking(Booking b) throws RemoteException {
		sqlStatement = "UPDATE booking SET bookingId=" + b.getBookingID() + ", customerId=" + b.getCustomerId() + ", regNo='" + b.getVehicleReg() + "', bookingdate=" + b.getDate() + " WHERE bookingId = " + b.getBookingID();
		result = bd.ExecuteUpdateStatement(sqlStatement);
		return result;
	}
	
	@Override
	public String DeleteBooking(Booking b) throws RemoteException {
		sqlStatement = "DELETE FROM booking WHERE bookingId = " + b.getBookingID();
		result = bd.ExecuteDeleteStatement(sqlStatement);
		return result;
	}
	
	// Customer SQL statement builders
	@Override
	public String CreateCustomer(Customer c) throws RemoteException {
		sqlStatement = "INSERT INTO customer VALUES(" + c.getCustomerID() + ", '" + c.getFirstName() + "', '" + c.getLastName() + "')";
		result = bd.ExecuteInsertStatement(sqlStatement);
		return result;
	}
	
	@Override
	public String ReadCustomer(Customer c) throws RemoteException {
		int count = 0;
		sqlStatement = "SELECT * FROM customer";
		if(c.getCustomerID() != 0) {
			sqlStatement += " WHERE customerId = " + c.getCustomerID();
			count++;
		}
		if(c.getFirstName() != null) {
			sqlStatement += StatementBuilderHelper(count);
			sqlStatement += "firstname LIKE '" + c.getFirstName() + "'";
		}
		if(c.getLastName() != null) {
			sqlStatement += StatementBuilderHelper(count);
			sqlStatement += "lastname LIKE '" + c.getLastName() + "'";
		}
		sqlStatement += ";";
		
		String str = bd.ExecuteReadStatement(sqlStatement, "Customer");
		return str;
	}
	
	@Override
	public String UpdateCustomer(Customer c) throws RemoteException {
		sqlStatement = "UPDATE customer SET firstname='" + c.getFirstName() + "', lastname='" + c.getLastName() + "'" + " WHERE customerId = " + c.getCustomerID();
		result = bd.ExecuteUpdateStatement(sqlStatement);
		return result;
	}
	
	@Override
	public String DeleteCustomer(Customer c) throws RemoteException {
		sqlStatement = "DELETE FROM customer WHERE customerId = " + c.getCustomerID();
		result = bd.ExecuteDeleteStatement(sqlStatement);
		return result;
	}

	// Vehicle SQL statement builders
	@Override
	public String CreateVehicle(Vehicle v) throws RemoteException {
		sqlStatement = "INSERT INTO vehicle VALUES('" + v.getRegNo() + "', '" + v.getBrand() + "', '" + v.getModel() + "')";
		result = bd.ExecuteInsertStatement(sqlStatement);
		return result;
	}
	
	@Override
	public String ReadVehicle(Vehicle v) throws RemoteException {
		int count = 0;
		sqlStatement = "SELECT * FROM customer";
		if(v.getRegNo() != null) {
			sqlStatement += " WHERE regNo LIKE '" + v.getRegNo() + "'";
			count++;
		}
		if(v.getBrand() != null) {
			sqlStatement += StatementBuilderHelper(count);
			sqlStatement += "brand LIKE '" + v.getBrand() + "'";
		}
		if(v.getModel() != null) {
			sqlStatement += StatementBuilderHelper(count);
			sqlStatement += "model LIKE '" + v.getModel() + "'";
		}
		sqlStatement += ";";
		
		String str = bd.ExecuteReadStatement(sqlStatement, "Vehicle");
		return str;
	}
	
	@Override
	public String UpdateVehicle(Vehicle v) throws RemoteException {
		sqlStatement = "UPDATE vehicle SET brand='" + v.getBrand() + "', model='" + v.getModel() + "' WHERE regNo LIKE '" + v.getRegNo() + "'";
		result = bd.ExecuteUpdateStatement(sqlStatement);
		return result;
	}
	
	@Override
	public String DeleteVehicle(Vehicle v) throws RemoteException {
		sqlStatement = "DELETE FROM vehicle WHERE regNo LIKE " + v.getRegNo();
		result = bd.ExecuteDeleteStatement(sqlStatement);
		return result;
	}

	public String StatementBuilderHelper(int i) {
		if(i > 0) {
			return " AND ";
		}
		else {
			return " WHERE ";
		}
	}

}
