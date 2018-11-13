package ie.gmit.sw.REST_Lab;

import java.rmi.RemoteException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.RMIClient;

@Path("/customer")
public class CustomerResource {
	// create an instance of the RMIClient object
	RMIClient rm = new RMIClient();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{customerId}/{firstName}/{lastName}")
	public Response getCustomer(@PathParam("customerId") String customerId, @PathParam("firstName") String firstName, @PathParam("lastName") String lastName) throws RemoteException {
		String requested = rm.ReadCustomer(Integer.parseInt(customerId), firstName, lastName);
		
		if(requested == null) {
			String msg = "This customer does not exist.";
			return Response.status(404).entity(msg).build();
		}
		else {
			String msg = requested;// need to get this as xml
			return Response.status(200).entity(msg).build();
		}
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{customerId}/{firstName}/{lastName}")
	public Response createCustomer(@PathParam("customerId") String customerId, @PathParam("firstName") String firstName, @PathParam("lastName") String lastName) throws RemoteException {
		String requested = rm.CreateCustomer(Integer.parseInt(customerId), firstName, lastName);
		
		if(requested == null) {
			String msg = "The customer was not created.";
			return Response.status(404).entity(msg).build();
		}
		else {
			String msg = requested;// need to get this as xml
			return Response.status(200).entity(msg).build();
		}
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{customerId}/{firstName}/{lastName}")
	public Response deleteCustomer(@PathParam("customerId") String customerId, @PathParam("firstName") String firstName, @PathParam("lastName") String lastName) throws RemoteException {
		// check to see if the record exists first
		String requested = rm.DeleteCustomer(Integer.parseInt(customerId), firstName, lastName);
		
		if(requested == null) {
			String msg = "The customer was not deleted.";
			return Response.status(404).entity(msg).build();
		}
		else {
			String msg = requested;// need to get this as xml
			return Response.status(200).entity(msg).build();
		}
	}
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{customerId}/{firstName}/{lastName}")
	public Response updateCustomer(@PathParam("customerId") String customerId, @PathParam("firstName") String firstName, @PathParam("lastName") String lastName) throws RemoteException {
		// check to see if the record exists first
		String requested = rm.UpdateCustomer(Integer.parseInt(customerId), firstName, lastName);
		
		if(requested == null) {
			String msg = "The customer was not updated.";
			return Response.status(404).entity(msg).build();
		}
		else {
			String msg = requested;// need to get this as xml
			return Response.status(200).entity(msg).build();
		}
	}

}
