package com.emirates.flight.info.repo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.emirates.flight.info.dao.FlightTariffRespository;
import com.emirates.flight.info.model.FlightTariffEntity;

@ExtendWith(SpringExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class FlightTariffRespositoryTest {
	@Autowired private FlightTariffRespository tariffRepo;;
	FlightTariffEntity tariff = null;

	@Before
	public void setUp() {
		tariff=tariffRepo.save(new FlightTariffEntity("EKU178",200,"2022-05-13","2022-06-13"));
	}

	@Test
	public void saveFlightTariffTest() {

		assertEquals("EKU178",tariff.getFlightNumber());
		assertEquals("2022-05-13",tariff.getEffective_date_from());
		assertEquals("2022-06-13",tariff.getEffective_date_to());

	}
	@Test
	public void getFlightTariffTest() {
		assertEquals(1,tariffRepo.getFlightTariff("EKU178", "2022-05-14").size());

	}

}
