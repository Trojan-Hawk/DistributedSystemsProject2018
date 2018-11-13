package ie.gmit.sw.REST_Lab;

import ie.gmit.sw.RMIClient;
import ie.gmit.sw.ds.Address;
import ie.gmit.sw.ds.Country;
import ie.gmit.sw.ds.Items;

import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.*;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBElement;
import javax.xml.transform.stream.StreamSource;

@Path("/booking")
public class BookingResource {
	// create an instance of the RMIClient object
	RMIClient rm = new RMIClient();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{bookingId}/{customerId}/{regNo}/{date}")
	public Response getOrder(@PathParam("bookingId") String bookingId, @PathParam("customerId") String customerId, @PathParam("regNo") String regNo, @PathParam("date") String date) throws RemoteException {
		String requested = rm.ReadBooking(Integer.parseInt(bookingId), regNo, Integer.parseInt(customerId), null);
		
		if(requested == null) {
			String msg = "The order does not exist.";
			return Response.status(404).entity(msg).build();
		}
		else {
			String msg = requested;// need to get this as xml
			return Response.status(200).entity(msg).build();
		}
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{bookingId}/{customerId}/{regNo}/{date}")
	public Response createOrder(@PathParam("bookingId") String bookingId, @PathParam("customerId") String customerId, @PathParam("regNo") String regNo, @PathParam("date") String date) throws RemoteException {
		String requested = rm.CreateBooking(Integer.parseInt(bookingId), regNo, Integer.parseInt(customerId), null);
		
		if(requested == null) {
			String msg = "The order was not created.";
			return Response.status(404).entity(msg).build();
		}
		else {
			String msg = requested;// need to get this as xml
			return Response.status(200).entity(msg).build();
		}
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{bookingId}/{customerId}/{regNo}/{date}")
	public Response deleteOrder(@PathParam("bookingId") String bookingId, @PathParam("customerId") String customerId, @PathParam("regNo") String regNo, @PathParam("date") String date) throws RemoteException {
		// check to see if the record exists first
		String requested = rm.DeleteBooking(Integer.parseInt(bookingId), regNo, Integer.parseInt(customerId), null);
		
		if(requested == null) {
			String msg = "The order was not deleted.";
			return Response.status(404).entity(msg).build();
		}
		else {
			String msg = requested;// need to get this as xml
			return Response.status(200).entity(msg).build();
		}
	}
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{bookingId}/{customerId}/{regNo}/{date}")
	public Response updateOrder(@PathParam("bookingId") String bookingId, @PathParam("customerId") String customerId, @PathParam("regNo") String regNo, @PathParam("date") String date) throws RemoteException {
		// check to see if the record exists first
		String requested = rm.UpdateBooking(Integer.parseInt(bookingId), regNo, Integer.parseInt(customerId), null);
		
		if(requested == null) {
			String msg = "The order was not updated.";
			return Response.status(404).entity(msg).build();
		}
		else {
			String msg = requested;// need to get this as xml
			return Response.status(200).entity(msg).build();
		}
	}
	
}
