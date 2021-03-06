package ie.gmit.sw;

import java.sql.*;   // Use 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import java.util.Date;

public class BookingsDatabase {	
	private Connection conn;
	private int count;
	
	public BookingsDatabase() {
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookings?useSSL=false&serverTimezone=GMT", "root", "");)
		{
			System.out.println("Connection OK!");
		} catch(SQLException ex) {
	        ex.printStackTrace();
	        System.out.println("Connection FAIL!");
	    }
	}
	
	public String ExecuteInsertStatement(String statement) {
		try(
		// Step 1: Allocate a database 'Connection' object
	    Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/bookings?useSSL=false&serverTimezone=GMT", "root", "");
        // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        // Step 2: Allocate a 'Statement' object in the Connection
        Statement stmt = conn.createStatement();) 
		{
			count = stmt.executeUpdate(statement);
			System.out.println(count + " records inserted.");
			return count + " records inserted.\n";
		} catch (SQLException e) {
			System.out.println("Insert failed!\nStatement: " + statement);
			e.printStackTrace();
			return null;
		}
	}
	
	public String ExecuteDeleteStatement(String statement) {
		try(
		// Step 1: Allocate a database 'Connection' object
	    Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/bookings?useSSL=false&serverTimezone=GMT", "root", "");
        // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        // Step 2: Allocate a 'Statement' object in the Connection
        Statement stmt = conn.createStatement();) 
		{
			count = stmt.executeUpdate(statement);
			System.out.println(count + " records deleted.\n");
			return count + " records deleted.\n";
		} catch (SQLException e) {
			System.out.println("Delete failed!\nStatement: " + statement);
			e.printStackTrace();
			return null;
		}
	}
	
	public String ExecuteUpdateStatement(String statement) {
		try(
		// Step 1: Allocate a database 'Connection' object
	    Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/bookings?useSSL=false&serverTimezone=GMT", "root", "");
        // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        // Step 2: Allocate a 'Statement' object in the Connection
        Statement stmt = conn.createStatement();) 
		{
			count = stmt.executeUpdate(statement);
			System.out.println(count + " records updated.");
			return count + " records updated.\n";
		} catch (SQLException e) {
			System.out.println("Update failed!\nStatement: " + statement);
			e.printStackTrace();
			return null;
		}
	}
	
	public String ExecuteReadStatement(String statement, String table) {
		try(
		// Step 1: Allocate a database 'Connection' object
	    Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/bookings?useSSL=false&serverTimezone=GMT", "root", "");
        // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        // Step 2: Allocate a 'Statement' object in the Connection
        Statement stmt = conn.createStatement();) 
		{
			ResultSet rs = stmt.executeQuery(statement);
			String str = "";
			
			if(table.equalsIgnoreCase("Booking")) {
				while (rs.next()) {
				    int id = rs.getInt("bookingId");
				    String firstName = rs.getString("customerId");
				    String lastName = rs.getString("regNo");	
				    String date = rs.getString("bookingdate");
				    str += id + "\t" + firstName + "\t" + lastName + "\t" + date + "|";
				}
			}
			else if(table.equalsIgnoreCase("Customer")) {
				while (rs.next()) {
				    int id = rs.getInt("customerId");
				    String firstName = rs.getString("firstname");
				    String lastName = rs.getString("lastname");	        
				    str += id + "\t " + firstName + "\t " + lastName + "|";
				}
			}
			else if(table.equalsIgnoreCase("Vehicle")) {
				while (rs.next()) {
				    int reg = rs.getInt("regNo");
				    String brand = rs.getString("brand");
				    String model = rs.getString("model");	        
				    str += reg + "\t " + brand + "\t " + model + "|";
				}
			}
			System.out.println("Read OK!");
			return str;
		} catch (SQLException e) {
			System.out.println("Read failed!\nStatement: " + statement);
			e.printStackTrace();
			return null;
		}
	}
}
