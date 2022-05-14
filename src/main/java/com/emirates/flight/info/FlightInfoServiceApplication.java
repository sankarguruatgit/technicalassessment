package com.emirates.flight.info;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@ComponentScan("com.emirates.flight.info")
@PropertySource("classpath:application.properties")
@EnableScheduling
@EnableCaching
public class FlightInfoServiceApplication extends SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(FlightInfoServiceApplication.class);
	
    public static void main(String[] args) {
    	logger.info("FlightInfoServiceApplication service is started");
    		SpringApplication.run(FlightInfoServiceApplication.class, args);
  }

}
