package com.emirates.flight.info.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import com.emirates.flight.info.dao.FlightNumberRespository;
import com.emirates.flight.info.model.FlightInfoResponse;
import com.emirates.flight.info.model.FlightNumberEntity;
import com.emirates.flight.info.service.FlightInfoService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FlightInfoControllerTest extends EmiratesFlightInfoServiceApplicationTests{
	protected MockMvc mockMvc;
	@Autowired
	  private ObjectMapper objectMapper;
	 @Autowired
	  WebApplicationContext webApplicationContext;
	 private String uri;
	   
	   
                                              
	@Autowired                           
    private FlightInfoService flightInfoService; 
    
    @Autowired private FlightNumberRespository flightNumberRepo;;
  
    @Before
	   public void setUp() {
		   mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		   uri = "/api/v1/flight?date=2022-05-19&airPortCodeDept=DXB&airPortCodeArrival=DUB";
		   flightNumberRepo.save(new FlightNumberEntity("EKU178","2022-05-13","2022-06-13","DXB"));
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
	public void getFligtInfoStatusOKTest() throws Exception {
	   //String uri = "/api/v1/flight?date=2022-05-19&airPortCodeDept=DXB&airPortCodeArrival=DUB";
	   MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   
	   System.out.println("mvcResult.getResponse() :"+mvcResult.getResponse().getContentAsString());
	   assertEquals(200, status);
	}
	@Test
	public void getFligtInfoResponseContentTest() throws Exception {
	   
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   
	  // System.out.println("mvcResult.getResponse() :"+mvcResult.getResponse().getContentAsString());
	   assertEquals(200, status);
	   
	   String content = mvcResult.getResponse().getContentAsString();
	   FlightInfoResponse  response = mapFromJson(content, FlightInfoResponse.class);
	   assertNotNull(response.getFlightNumberArrival());
	   assertNotNull(response.getFlightNumberArrival());
	   
	}
	
	@Test
	public void getFligtInfoNotFoundTest() throws Exception {
	   
		String uri = "/api/v1/flight?date=2022-05-19&airPortCodeDept=YYY&airPortCodeArrival=RRR";
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(404, status);
	   
	}
	
	
	
	 
}
