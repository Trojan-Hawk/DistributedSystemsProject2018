package ie.gmit.sw.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ie.gmit.sw.service.BookingService;

@Component("bookingController")
@Controller
public class BookingController {
	IndexController ic = new IndexController();

	String resourceBaseURL = "http://localhost:8080/REST_Lab/webapi/";
	URL url;
	HttpURLConnection con;
	String result = "";
	String table = "";
	// --------------------------------------unused---------------------------------------------------------------------
	@Autowired
	private BookingService bookingService;

	@RequestMapping(value = "/getBookingData", method = RequestMethod.GET)
	public BookingService getBookingData() {

		bookingService.setBookingId("3");
		bookingService.setCustomerId("4");
		bookingService.setRegNo("12-G-256");
		bookingService.setDate("05-12-2018");

		return bookingService;
	}

	// -----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/getBookings", method = RequestMethod.GET)
	public String getBookings(Model model) {
		// try to create a connection and request plain text format
		try {
			url = new URL(resourceBaseURL + "booking/all");
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "text/plain");
			InputStream in = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			result = br.lines().collect(Collectors.joining());
			con.disconnect();

			String[] results = result.split("\\|");
			// the array has values create a table and populate
			if (results.length > 0 && results != null) {
				table = "<table border=1>";
				table += "<tr><td>Booking ID</td><td>Customer ID</td><td>Registration Number</td><td>Date</td></tr>";
				for (int i = 0; i < results.length; i++) {
					// split each record
					String[] s = results[i].split("\\t");
					table += "<tr><td>" + s[0] + "</td><td>" + s[1] + "</td><td>" + s[2] + "</td><td>" + s[3]
							+ "</td></tr>";
				} // for
				table += "</table>";
			} // if
			// split the result up if possible and add to list array
			// List<String> results = Arrays.asList(result.split("\\|"));
			// add the table to the model
			model.addAttribute("table", table);
			// model.addAttribute("results", results);
		} catch (IOException e) {
			model.addAttribute("table", "Value input error! please enter correct values!");
			e.printStackTrace();
		}
		return "viewBookings";
	}// getBookings

	@RequestMapping(value = "/createBookingEntry", method = RequestMethod.GET)
	public String createBookingEntry(@RequestParam("bookingId") String bookingId,
			@RequestParam("customerId") String customerId, @RequestParam("regNo") String regNo,
			@RequestParam("date") String date, Model model) {
		if (bookingId.equals("")) {
			model.addAttribute("result", "Booking ID cannot be blank!");
			return "viewBookingResult";
		}
		if (customerId.equals("")) {
			model.addAttribute("result", "Customer ID cannot be blank!");
			return "viewBookingResult";
		}
		if (regNo.equals("")) {
			model.addAttribute("result", "Registration number cannot be blank!");
			return "viewBookingResult";
		}
		if (date.equals("")) {
			model.addAttribute("result", "Date cannot be blank!");
			return "viewBookingResult";
		}
		// try to create a connection
		try {
			url = new URL(resourceBaseURL + "booking/" + bookingId + "/" + customerId + "/" + regNo + "/" + date);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept", "text/plain");
			InputStream in = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			result = br.lines().collect(Collectors.joining());
			con.disconnect();
			// add the result to the model
			model.addAttribute("result", result);
		} catch (IOException e) {
			model.addAttribute("result", "Value input error! please enter correct values!");
			e.printStackTrace();
		}
		return "viewBookingResult";
	}// createBookingEntry

	@RequestMapping(value = "/updateBookingEntry", method = RequestMethod.GET)
	public String updateBooking(@RequestParam("bookingId") String bookingId,
			@RequestParam("customerId") String customerId, @RequestParam("regNo") String regNo,
			@RequestParam("date") String date, Model model) {
		if (bookingId.equals("")) {
			model.addAttribute("result", "Booking ID cannot be blank!");
			return "viewBookingResult";
		}
		if (customerId.equals("")) {
			model.addAttribute("result", "Customer ID cannot be blank!");
			return "viewBookingResult";
		}
		if (regNo.equals("")) {
			model.addAttribute("result", "Registration number cannot be blank!");
			return "viewBookingResult";
		}
		if (date.equals("")) {
			model.addAttribute("result", "Date cannot be blank!");
			return "viewBookingResult";
		}
		// try to create a connection
		try {
			url = new URL(resourceBaseURL + "booking/" + bookingId + "/" + customerId + "/" + regNo + "/" + date);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Accept", "text/plain");
			InputStream in = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			result = br.lines().collect(Collectors.joining());
			con.disconnect();
			// add the result to the model
			model.addAttribute("result", result);
		} catch (IOException e) {
			model.addAttribute("result", "Value input error! please enter correct values!");
			e.printStackTrace();
		}
		return "viewBookingResult";
	}// updateBooking

	@RequestMapping(value = "/deleteBookingEntry", method = RequestMethod.GET)
	public String deleteBooking(@RequestParam("bookingId") String bookingId,
			@RequestParam("customerId") String customerId, @RequestParam("regNo") String regNo,
			@RequestParam("date") String date, Model model) {
		if (bookingId.equals("")) {
			model.addAttribute("result", "Booking ID cannot be blank!");
			return "viewBookingResult";
		}
		if (customerId.equals("")) {
			customerId = "0";
		}
		if (regNo.equals("")) {
			regNo = "null";
		}
		if (date.equals("")) {
			date = "null";
		}
		// try to create a connection
		try {
			url = new URL(resourceBaseURL + "booking/" + bookingId + "/" + customerId + "/" + regNo + "/" + date);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("DELETE");
			con.setRequestProperty("Accept", "text/plain");
			InputStream in = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			result = br.lines().collect(Collectors.joining());
			con.disconnect();
			// add the result to the model
			model.addAttribute("result", result);
		} catch (IOException e) {
			model.addAttribute("result", "Value input error! please enter correct values!");
			e.printStackTrace();
		}
		return "viewBookingResult";
	}// deleteBooking
	
}// Booking Controller