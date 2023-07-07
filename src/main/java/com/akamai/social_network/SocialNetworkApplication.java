package com.akamai.social_network;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialNetworkApplication {
	/*
	TO DO
	add validation for request parameters in controller
	add jacoco to measure unit tests coverage
	create integration tests
	create documentation
	convert properties to .yaml format
	 */

	public static void main(String[] args) {
		SpringApplication.run(SocialNetworkApplication.class, args);
	}

}
