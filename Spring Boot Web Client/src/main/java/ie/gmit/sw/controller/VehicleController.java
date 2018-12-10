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

@Component("vehicleController")
@Controller
public class VehicleController {
	String resourceBaseURL = "http://localhost:8080/REST_Lab/webapi/";
	URL url;
	HttpURLConnection con;
	String result = "";
	String table = "";
	
	IndexController ic = new IndexController();
	
	@RequestMapping(value = "/getVehicles", method = RequestMethod.GET)
	public String getVehicles(Model model) {
		// try to create a connection and request plain text format
		try {
			url = new URL(resourceBaseURL + "vehicle/all");
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
				table += "<tr><td>Registration Number</td><td>Brand</td><td>Model</td></tr>";
				for (int i = 0; i < results.length; i++) {
					// split each record
					String[] s = results[i].split("\\t");
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
		return "viewVehicles";
	}// getCustomers

	@RequestMapping(value = "/createVehicleEntry", method = RequestMethod.GET)
	public String createVehicleEntry(@RequestParam("regNo") String regNo, @RequestParam("brand") String brand, 
			@RequestParam("modelName") String modelName, Model model) {
		if (regNo.equals("")) {
			model.addAttribute("result", "Registration cannot be blank!");
			return "viewVehicleResult";
		}
		if (brand.equals("")) {
			model.addAttribute("result", "Brand cannot be blank!");
			return "viewVehicleResult";
		}
		if (modelName.equals("")) {
			model.addAttribute("result", "Model cannot be blank!");
			return "viewVehicleResult";
		}
		// try to create a connection
		try {
			url = new URL(resourceBaseURL + "vehicle/" + regNo + "/" + brand + "/" + modelName);
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
		return "viewVehicleResult";
	}// createVehicleEntry

	@RequestMapping(value = "/updateVehicleEntry", method = RequestMethod.GET)
	public String updateVehicle(@RequestParam("regNo") String regNo, @RequestParam("brand") String brand, 
			@RequestParam("modelName") String modelName, Model model) {
		if (regNo.equals("")) {
			model.addAttribute("result", "Registration cannot be blank!");
			return "viewVehicleResult";
		}
		if (brand.equals("")) {
			model.addAttribute("result", "Brand cannot be blank!");
			return "viewVehicleResult";
		}
		if (modelName.equals("")) {
			model.addAttribute("result", "Model cannot be blank!");
			return "viewVehicleResult";
		}
		// try to create a connection
		try {
			url = new URL(resourceBaseURL + "vehicle/" + regNo + "/" + brand + "/" + modelName);
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
		return "viewVehicleResult";
	}// updateVehicle

	@RequestMapping(value = "/deleteVehicleEntry", method = RequestMethod.GET)
	public String deleteVehicle(@RequestParam("regNo") String regNo, @RequestParam("brand") String brand, 
			@RequestParam("modelName") String modelName, Model model) {
		if (regNo.equals("")) {
			model.addAttribute("result", "Registration cannot be blank!");
			return "viewVehicleResult";
		}
		if (brand.equals("")) {
			brand = "null";
		}
		if (modelName.equals("")) {
			modelName =  "null";
		}
		// try to create a connection
		try {
			url = new URL(resourceBaseURL + "vehicle/" + regNo + "/" + brand + "/" + model);
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
		return "viewVehicleResult";
	}// deleteVehicle
	
}// VehicleController