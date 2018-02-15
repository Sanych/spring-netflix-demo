package com.azapasnik.thirdwordservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ThirdWordServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdWordServiceApplication.class, args);
	}
}
