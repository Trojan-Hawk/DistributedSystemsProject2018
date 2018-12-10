package ie.gmit.sw.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component("indexController")
@Controller
public class IndexController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/booking")
	public String booking() {
		return "booking";
	}
	@RequestMapping("/createBooking")
	public String createBooking() {
		return "createBooking";
	}
	@RequestMapping("/deleteBooking")
	public String deleteBooking() {
		return "deleteBooking";
	}
	@RequestMapping("/updateBooking")
	public String updateBooking() {
		return "updateBooking";
	}
	@RequestMapping("/customer")
	public String customer() {
		return "customer";
	}
	@RequestMapping("/createCustomer")
	public String createCustomer() {
		return "createCustomer";
	}
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer() {
		return "deleteCustomer";
	}
	@RequestMapping("/updateCustomer")
	public String updateCustomer() {
		return "updateCustomer";
	}
	@RequestMapping("/vehicle")
	public String vehicle() {
		return "vehicle";
	}
	@RequestMapping("/createVehicle")
	public String createVehicle() {
		return "createVehicle";
	}
	@RequestMapping("/deleteVehicle")
	public String deleteVehicle() {
		return "deleteVehicle";
	}
	@RequestMapping("/updateVehicle")
	public String updateVehicle() {
		return "updateVehicle";
	}
	@RequestMapping("/viewResult")
	public String viewResult() {
		return "viewResult";
	}
}