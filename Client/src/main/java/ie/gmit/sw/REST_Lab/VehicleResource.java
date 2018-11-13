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

@Path("/vehicle")
public class VehicleResource {
	// create an instance of the RMIClient object
	RMIClient rm = new RMIClient();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{regNo}/{brand}/{model}")
	public Response getOrder(@PathParam("regNo") String regNo, @PathParam("brand") String brand, @PathParam("model") String model) throws RemoteException {
		String requested = rm.ReadVehicle(regNo, brand, model);
		
		if(requested == null) {
			String msg = "The vehicle does not exist.";
			return Response.status(404).entity(msg).build();
		}
		else {
			String msg = requested;// need to get this as xml
			return Response.status(200).entity(msg).build();
		}
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{regNo}/{brand}/{model}")
	public Response createOrder(@PathParam("regNo") String regNo, @PathParam("brand") String brand, @PathParam("model") String model) throws RemoteException {
		String requested = rm.CreateVehicle(regNo, brand, model);
		
		if(requested == null) {
			String msg = "The vehicle was not created.";
			return Response.status(404).entity(msg).build();
		}
		else {
			String msg = requested;// need to get this as xml
			return Response.status(200).entity(msg).build();
		}
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{regNo}/{brand}/{model}")
	public Response deleteVehicle(@PathParam("regNo") String regNo, @PathParam("brand") String brand, @PathParam("model") String model) throws RemoteException {
		// check to see if the record exists first
		String requested = rm.DeleteVehicle(regNo, brand, model);
		
		if(requested == null) {
			String msg = "The vehicle was not deleted.";
			return Response.status(404).entity(msg).build();
		}
		else {
			String msg = requested;// need to get this as xml
			return Response.status(200).entity(msg).build();
		}
	}
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{regNo}/{brand}/{model}")
	public Response updateVehicle(@PathParam("regNo") String regNo, @PathParam("brand") String brand, @PathParam("model") String model) throws RemoteException {
		// check to see if the record exists first
		String requested = rm.UpdateVehicle(regNo, brand, model);
		
		if(requested == null) {
			String msg = "The vehicle was not updated.";
			return Response.status(404).entity(msg).build();
		}
		else {
			String msg = requested;// need to get this as xml
			return Response.status(200).entity(msg).build();
		}
	}
}
