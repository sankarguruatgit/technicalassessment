Emirates technical assessment:
 This sample project contains two Rest API end points, the project is developed by using Java88, Spring Boot Rest, Spring Boot Web, spring @Scheduled
 
Building a Project : 
To build a project to run command mvn clean install in the project directory

Running a Spring Boot Project
	To run a Spring Boot, run the command: mvn spring-boot:run in the project directory.

Working with the IDE
 you can simply import the project in either Eclipse or IntelliJ.
 

Running Tests
	The command mvn clean install from within a project will run the unit tests 


Swagger Details :
          To validate the end point, please use the swagger UI page.
          
		http://localhost:9090/swagger-ui/index.html

To Retrieve Flight Number:
	
	Rest API endpoint : 	http://localhost:9090/api/v1/flight?date=2022-05-18&airPortCodeDept=DXB&airPortCodeArrival=DUB'
	
To Get Flight Price :

	Rest API endpoint : http://localhost:9090/api/v1/flight?date=2022-05-18&airPortCodeDept=DXB&airPortCodeArrival=DUB'
	

System health Check :

 	Actuator end point To verify the system check 

		http://localhost:9090/actuator/health


 Memory Database:
  
In Memory H2 data base is used for data persistent, The following table will be created while application startup

		H2 Console endpoint : http://localhost:9090/h2
			Table names:
				FLIGHT_TARIFF
				FLIGHT_NUMBER_INVENTORY	

