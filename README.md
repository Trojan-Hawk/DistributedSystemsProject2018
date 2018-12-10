# DistributedSystemsProject2018
RESTful car hire service that uses RMI (remote method invocation) to preform CRUD operations on a MySQL database.

### Executable Files

*web-client.war* 

This is the Spring Boot web application front-end of this project. 

*booking-server.war* 

This file is the RMI client of this project, the various methods of the remote objects are defined and processed in this application.

*database-service* 

This file is the RMI server, it accesses an SQL database which allows it to perform CRUD operations.

### SQL Database

To host the database I used WampServer 3.1.3 (32bit), during testing  and development the Wamp SQL console has to be kept open otherwise the database cannot be accessed. The SQL code is supplied in this repo, in the 'sqlbookingdb.txt' file. To use this file simple copy the contents of the file into the SQL console.

### RMI Server

This purpose of this project is to access the SQL database, it does so by using JDBC. This project also starts the RMI registry on port 1099 and binds it to the name 'databaseservice'. This allows it to be accessed remotely. The CRUD operation methods are contained in this project also, these are used to changed the state of the database when call upon by the RMI Client.

### RMI Client

The purpose of the RMI client is to access the RMI Server and call upon the various CRUD operations. This project makes a connection to the RMIServer by looking up the RMI registry for the 'databaseservice' name binding. The methods in this project are accessed by the Spring Boot web client.

### Web Client

The purpose of this web client is to provide a front-end which a user of the system can use to access the various applications outlined above. The web client is back-ended by Spring Boot, the version of Spring Tools 3 IDE I used was 3.9.6. 