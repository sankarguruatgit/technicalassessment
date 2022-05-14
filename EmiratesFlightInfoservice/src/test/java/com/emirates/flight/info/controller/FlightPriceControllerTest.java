package com.emirates.flight.info.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.emirates.flight.info.EmiratesFlightInfoServiceApplicationTests;
import com.emirates.flight.info.dao.FlightTariffRespository;
import com.emirates.flight.info.model.FlightTariff;
import com.emirates.flight.info.model.FlightTariffEntity;
import com.emirates.flight.info.service.FlightPriceEngineService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FlightPriceControllerTest extends EmiratesFlightInfoServiceApplicationTests{

	protected MockMvc mockMvc;
	@Autowired
	  private ObjectMapper objectMapper;
	 @Autowired
	  WebApplicationContext webApplicationContext;
	 private String uri;
	   
	                                                 
	@Autowired                           
    private FlightPriceEngineService priceEngineService; 
    
    @Autowired private FlightTariffRespository flightTariffRepo;;
  
    @Before
	   public void setUp() {
		   mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		   uri = "/api/v1/price?date=2022-05-12&flightNumber=EKU178";
		   flightTariffRepo.save(new FlightTariffEntity("EKU178",200,"2022-05-13","2022-06-13"));
	   }
    
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
     }
     protected <T> T mapFromJson(String json, Class<T> clazz)
        throws JsonParseException, JsonMappingException, IOException {
        
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
     }
     @Test
 	public void getFligtPriceStatusOKTest() throws Exception {
 	   MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
 	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
 	   
 	   int status = mvcResult.getResponse().getStatus();
 	   
 	   System.out.println("mvcResult.getResponse() :"+mvcResult.getResponse().getContentAsString());
 	   assertEquals(200, status);
 	}
	@Test
 	public void getFligtPriceResponseContentTest() throws Exception {
 	   
 		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
 	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
 	   
 		String content = mvcResult.getResponse().getContentAsString();
 	  FlightTariff  response = mapFromJson(content, FlightTariff.class);
 	  assertEquals("EKU178", response.getFlightNumber());
	}
}
