package com.example.microcomsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroComsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroComsumerApplication.class, args);
	}

}
