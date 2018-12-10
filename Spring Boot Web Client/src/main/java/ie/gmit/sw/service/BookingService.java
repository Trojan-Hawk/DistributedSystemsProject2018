package ie.gmit.sw.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("bookingService")
@Service
public class BookingService {

	private String bookingId;
	private String customerId;
	private String regNo;
	private String date;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
