package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServiceSetup {
	
	public static void main(String[] args) throws Exception {
		DatabaseServiceImpl dsm = new DatabaseServiceImpl();
		
		//Start the RMI registry on port 1099
		LocateRegistry.createRegistry(1099);
		
		//Bind our remote object to the registry with the human-readable name "databaseservice"
		Naming.rebind("databaseservice", dsm);
		
		//Print a nice message to standard output
		System.out.println("Server ready.");
	}
}