package com.veerendra.biradar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
//@SpringBootApplication()
public class VeerendraApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeerendraApplication.class, args);

		System.out.println("Veerendra Application started successfully");
	}

}
