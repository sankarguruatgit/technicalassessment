package com.emirates.flight.info.model;

import java.util.List;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@PropertySource(name = "myProperties", value = "values.properties")
public class FlightinfoRequest {

  @Getter @Setter private Date date;
  @Value("#{'${com.airport.code.departure}'.split(',')}")
  @Getter @Setter private List<String> airPortCodeDept;
  @Value("#{'${com.airport.code.arrival}'.split(',')}")
  @Getter @Setter private List<String> airPortCodeArrival;

  }
