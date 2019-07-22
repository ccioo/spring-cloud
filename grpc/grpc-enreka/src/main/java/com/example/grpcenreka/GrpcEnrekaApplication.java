package com.example.grpcenreka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GrpcEnrekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrpcEnrekaApplication.class, args);
    }

}
