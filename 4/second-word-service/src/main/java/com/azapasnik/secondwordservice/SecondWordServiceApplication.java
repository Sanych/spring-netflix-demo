package com.azapasnik.secondwordservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SecondWordServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondWordServiceApplication.class, args);
	}
}
