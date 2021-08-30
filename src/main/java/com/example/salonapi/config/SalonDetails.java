package com.example.salonapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "salon.details")
public class SalonDetails {

    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
}
