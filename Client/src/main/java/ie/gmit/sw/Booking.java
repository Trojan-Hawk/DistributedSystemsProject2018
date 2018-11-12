package ie.gmit.sw;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {

	private int bookingID;
	private String vehicleReg;
	private int customerId;
	private Date date;
	
	public Booking(int bookingID, int customerId, String vehicleReg, Date date) {
		this.bookingID = bookingID;
		this.customerId = customerId;
		this.vehicleReg = vehicleReg;
		this.date = date;
	}

	public int getBookingID() {
		return bookingID;
	}

	public String getVehicleReg() {
		return vehicleReg;
	}

	public int getCustomerId() {
		return customerId;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Booking [bookingID=" + bookingID + ", vehicleReg=" + vehicleReg + ", customerId=" + customerId
				+ ", date=" + date + "]";
	}
	
}
