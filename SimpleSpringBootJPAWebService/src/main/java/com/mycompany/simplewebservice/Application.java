/**
 * *************************************************************************
 *
 * Filename : Application.java 
 * Language : Java 2 v1.7 
 * Purpose : Spring Boot application for simple web service for 
 * Millar & Bryce i-Interface database. 
 * Based on this: http://spring.io/guides/gs/actuator-service/
 * Spring Boot includes a copy of Jetty to run the service in!
 *
 * (C) COPYRIGHT Decision Insight Information Group, 2014 All Rights Reserved
 *
 * Author   Date        Changes 
 * sparry  <Date>  Initial Implementation
 *
 ****************************************************************************
 */
package com.mycompany.simplewebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }

}
