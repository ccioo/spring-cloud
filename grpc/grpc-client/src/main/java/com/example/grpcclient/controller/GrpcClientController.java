package com.example.grpcclient.controller;

import com.example.grpcclient.service.RemoteCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GrpcClientController {

    @Autowired
    private RemoteCallService grpcClientService;

    @RequestMapping("/")
    public String printMessage(@RequestParam(defaultValue = "Spring Cloud") String name) {
        return grpcClientService.sendMessage(name);
    }
}
