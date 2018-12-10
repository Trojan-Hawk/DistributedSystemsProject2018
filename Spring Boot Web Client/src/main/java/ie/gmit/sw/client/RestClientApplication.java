package ie.gmit.sw.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

import ie.gmit.sw.controller.IndexController;

@ComponentScan(basePackages = {
		"ie.gmit.sw.controller",
		"ie.gmit.sw.service",
		"ie.gmit.sw.resources"
})
@SpringBootApplication
public class RestClientApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RestClientApplication.class, args);
		// check to see if the components have been found
		System.out.println("Contains Booking Controller: " + context.containsBeanDefinition("bookingController"));
		// System.out.println("Contains Booking Service: " + context.containsBeanDefinition("bookingService"));
		System.out.println("Contains Index Controller: " + context.containsBeanDefinition("indexController"));
		IndexController ic = new IndexController();
		ic.index();
	}
}
