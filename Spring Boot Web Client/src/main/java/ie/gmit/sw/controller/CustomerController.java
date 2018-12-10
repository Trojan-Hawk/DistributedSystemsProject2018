package ie.gmit.sw.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component("customerController")
@Controller
public class CustomerController {
	String resourceBaseURL = "http://localhost:8080/REST_Lab/webapi/";
	URL url;
	HttpURLConnection con;
	String result = "";
	String table = "";
	
	IndexController ic = new IndexController();
	
	@RequestMapping(value = "/getCustomers", method = RequestMethod.GET)
	public String getCustomers(Model model) {
		// try to create a connection and request plain text format
		try {
			url = new URL(resourceBaseURL + "customer/all");
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
				table += "<tr><td>Customer ID</td><td>First Name</td><td>Last Name</td></tr>";
				for (int i = 0; i < results.length; i++) {
					// split each record
					String[] s = results[i].split("\\t");
					System.out.println(s);
					table += "<tr><td>" + s[0] + "</td><td>" + s[1] + "</td><td>" + s[2] + "</td></tr>";
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
		return "viewCustomers";
	}// getCustomers

	@RequestMapping(value = "/createCustomerEntry", method = RequestMethod.GET)
	public String createCustomerEntry(@RequestParam("customerId") String customerId, @RequestParam("firstName") String firstName, 
			@RequestParam("lastName") String lastName, Model model) {
		if (customerId.equals("")) {
			model.addAttribute("result", "Customer ID cannot be blank!");
			return "viewCustomerResult";
		}
		if (firstName.equals("")) {
			model.addAttribute("result", "First name cannot be blank!");
			return "viewCustomerResult";
		}
		if (lastName.equals("")) {
			model.addAttribute("result", "Last name cannot be blank!");
			return "viewCustomerResult";
		}
		// try to create a connection
		try {
			url = new URL(resourceBaseURL + "customer/" + customerId + "/" + firstName + "/" + lastName);
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
		return "viewCustomerResult";
	}// createCustomerEntry

	@RequestMapping(value = "/updateCustomerEntry", method = RequestMethod.GET)
	public String updateCustomer(@RequestParam("customerId") String customerId, @RequestParam("firstName") String firstName, 
			@RequestParam("lastName") String lastName, Model model) {
		if (customerId.equals("")) {
			model.addAttribute("result", "Customer ID cannot be blank!");
			return "viewCustomerResult";
		}
		if (firstName.equals("")) {
			model.addAttribute("result", "First name cannot be blank!");
			return "viewCustomerResult";
		}
		if (lastName.equals("")) {
			model.addAttribute("result", "Last name cannot be blank!");
			return "viewCustomerResult";
		}
		// try to create a connection
		try {
			url = new URL(resourceBaseURL + "customer/" + customerId + "/" + firstName + "/" + lastName);
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
		return "viewCustomerResult";
	}// updateCustomer

	@RequestMapping(value = "/deleteCustomerEntry", method = RequestMethod.GET)
	public String deleteCustomer(@RequestParam("customerId") String customerId, @RequestParam("firstName") String firstName, 
			@RequestParam("lastName") String lastName, Model model) {
		if (customerId.equals("")) {
			model.addAttribute("result", "Customer ID cannot be blank!");
			return "viewCustomerResult";
		}
		if (firstName.equals("")) {
			firstName = "null";
		}
		if (lastName.equals("")) {
			lastName = "null";
		}
		// try to create a connection
		try {
			url = new URL(resourceBaseURL + "customer/" + customerId + "/" + firstName + "/" + lastName);
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
		return "viewCustomerResult";
	}// deleteCustomer
	
}// CustomerController