package com.emirates.flight.info.repo;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.emirates.flight.info.dao.FlightNumberRespository;
import com.emirates.flight.info.model.FlightNumberEntity;

@ExtendWith(SpringExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class FlightNumberRespositoryTest {

		@Autowired private FlightNumberRespository flightNumberRepo;;
	    
	   @Test
	     public void saveFlightNumberObject() {
	    	 FlightNumberEntity numberEntity = flightNumberRepo.save(new FlightNumberEntity("EKU178","2022-05-13","2022-06-13","DXB"));
		     
	    	 assertEquals("EKU178",numberEntity.getFlightNumber());
	    	 assertEquals("2022-05-13",numberEntity.getAvialable_date_from());
	    	 assertEquals("2022-06-13",numberEntity.getAvialable_date_to());
	    	 assertEquals("DXB",numberEntity.getAirport_code());
		    }
	     @Test
	     public void findFlightNumberTest() {
		     	 assertEquals("EKU178",flightNumberRepo.findFlightNumber("DXB","2022-05-14").get(0).toString());
	     }
	     @Test
	     public void addFlightNumberInventoryTest() {
	    	 flightNumberRepo.addFlightNumberInventory("EKU555","YRT","2022-05-13","2022-06-13");
		     	 assertEquals("EKU555",flightNumberRepo.findFlightNumber("YRT","2022-05-14").get(0).toString());
	     }
	     @Test
	     public void updateFlightNumberTest() {
	    	 	flightNumberRepo.changeFlightNumber("EKU181", "DXB");
		     	 assertEquals("EKU181",flightNumberRepo.findFlightNumber("DXB","2022-05-14").get(0).toString());
	     }
	   
	     
}
