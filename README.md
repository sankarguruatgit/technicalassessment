Technical assessment:

This project is developed by using Java 8, Spring boot Rest, Spring boot Web, Spring boot JPA, Spring boot Cache , Spring boot scheduler, in- memory H2 database 
 
Building a Project 
		
	mvn clean install

Running a Spring Boot Project
	
	mvn spring-boot:run

Working with the IDE :  

	you can simply import the project in either Eclipse or IntelliJ.
 
Running Tests :

	 The command mvn clean install from within a project will run the unit tests 


Swagger Details :
          To validate the end point, please use the swagger UI page.
          
		http://localhost:9090/swagger-ui/index.html

To Get Flight Number Rest API Endoint:
	
	     http://localhost:9090/api/v1/flight?date=2022-05-18&airPortCodeDept=DXB&airPortCodeArrival=DUB'
	
To Get Flight Price Rest API Endoint:

	     http://localhost:9090/api/v1/flight?date=2022-05-18&airPortCodeDept=DXB&airPortCodeArrival=DUB'
	

System health Check :

 	Actuator end point to verify the service health check 

		http://localhost:9090/actuator/health


 Memory Database:
  
In Memory H2 data base is used for temporary data persistent. 

		H2 Console endpoint : http://localhost:9090/h2
			Table names:
				FLIGHT_TARIFF
				FLIGHT_NUMBER_INVENTORY	

