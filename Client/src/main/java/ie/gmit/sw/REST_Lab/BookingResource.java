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

// @Singleton
@Path("/booking")
public class BookingResource {

	RMIClient rm = new RMIClient();
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{bookingId}/{customerId}/{regNo}/{date}")
	public Response createOrder(@PathParam("bookingId") String bookingId, @PathParam("customerId") String customerId, @PathParam("regNo") String regNo, @PathParam("date") String date) throws RemoteException {
		// will automatically marshal/unmarcsall
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
	/*
	ArrayList<PurchaseOrder> orders = new ArrayList<PurchaseOrder>();
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/testpost")
	public Response testPost(String body) {
		String msg = "The request body: " + body;
		return Response.status(200).entity(msg).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/{value}")
	public Response createOrder(@PathParam("value") String value, PurchaseOrder po) {
		// will automatically marshal/unmarcsall
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{value}")
	public Response getOrder(@PathParam("value") String value, PurchaseOrder po) {
		// will automatically marshal/unmarcsall
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{value}")
	public Response getOrder(@PathParam("value") String value) {
		PurchaseOrder requested = null;
		for(PurchaseOrder p : orders) {
			if(p.getOrderNumber().equals(value)) {
				requested = p;
			}
		}
		
		if(requested == null) {
			String msg = "The requested order does not exist";
			return Response.status(404).entity(msg).build();
		}
		else {
			String msg = getOrderAsXML(requested);
			return Response.status(200).entity(msg).build();
		}
		
	}
	
	@DELETE
	// @Produces(MediaType.APPLICATION_XML)
	@Path("/{value}")
	public Response deleteOrder(@PathParam("value") String value) {
		PurchaseOrder requested = null;
		for(PurchaseOrder p : orders) {
			if(p.getOrderNumber().equals(value)) {
				requested = p;
			}
		}
		
		if(requested == null) {
			String msg = "The requested order does not exist";
			return Response.status(404).entity(msg).build();
		}
		else {
			orders.remove(requested);
			String msg = "Order '" + value + "' has been deleted!";
			return Response.status(200).entity(msg).build();
		}
		
	}
	
	public OrderResource() {		
		init();
	}
	
	private String getOrderAsXML(PurchaseOrder po) {
		// Marshal the PurchaseOrder into XML
		StringWriter sw = new StringWriter();
		Marshaller m;
		try {
			JAXBContext jc = JAXBContext.newInstance("ie.gmit.sw.ds");
			m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(po, sw);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return sw.toString();
	}
	
	private PurchaseOrder getPoFromXml(String input) {
		// Unmarshal the PurchaseOrder from XML
		StringReader sr1 = new StringReader(input);
		Unmarshaller um1;
		PurchaseOrder poFromXml = null;
		try {
			JAXBContext jc = JAXBContext.newInstance("ie.gmit.sw.ds");
			um1 = jc.createUnmarshaller();
			StreamSource source1 = new StreamSource(sr1);
			JAXBElement<PurchaseOrder> poElement1 = um1.unmarshal(source1, PurchaseOrder.class);
			poFromXml = (PurchaseOrder) poElement1.getValue();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return poFromXml;
		
	}
	
	private void init() {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date(System.nanoTime()));
		XMLGregorianCalendar date = null;
		try {
			date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		ObjectFactory objFactory = new ObjectFactory();

		PurchaseOrder po = objFactory.createPurchaseOrder();
		po.setOrderNumber("55522-BABA");
		po.setOrderDate(date);

		Address shipTo = new Address();
		shipTo.setName("John Doe");
		shipTo.setStreet("123 Castle Road");
		shipTo.setCity("Oranmore");
		shipTo.setCounty("Galway");
		shipTo.setCountry(Country.IRELAND);
		po.setShipTo(shipTo);
		po.setBillTo(shipTo);

		Items items = new Items();
		po.setItems(items);
		List<Items.Item> col = items.getItem();
		Items.Item i1 = new Items.Item();
		i1.setPartNumber("123ABC");
		i1.setProductName("11ft Trout Fly Road");
		i1.setQuantity(1);
		i1.setPrice(new BigDecimal("250.00"));
		i1.setShipDate(date);
		col.add(i1);

		Items.Item i2 = new Items.Item();
		i2.setPartNumber("177AAA");
		i2.setProductName("14ft Salmon Fly Road");
		i2.setQuantity(1);
		i2.setPrice(new BigDecimal("450.00"));
		i2.setShipDate(date);
		col.add(i2);
		
		orders.add(po);
	}
	*/
}
