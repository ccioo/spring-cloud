package com.example.microprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
public class MicroProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroProviderApplication.class, args);
	}

}
