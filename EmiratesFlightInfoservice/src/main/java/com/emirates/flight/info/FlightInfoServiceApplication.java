package com.emirates.flight.info;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
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
    	logger.info("this is a FlightInfoServiceApplication service");
    	ConfigurableApplicationContext context = SpringApplication.run(FlightInfoServiceApplication.class, args);
    	
    
    	// initialize a Random object somewhere; you should only need one
    	Random random = new Random();

    	// generate a random integer from 0 to 899, then add 100
    	int x = random.nextInt(900) + 100;
    	
    	 
    	logger.info("Random Number"+ x);
    	//context.getBean(FlightNumberChangeScheduler.class).fillWithFlightNumber(); // load flight number information into in-memory 
    	
    }

}
