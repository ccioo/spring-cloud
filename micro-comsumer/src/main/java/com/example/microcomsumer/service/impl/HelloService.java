package com.example.microcomsumer.service.impl;


import com.example.microcomsumer.service.IHelloService;
import com.example.microcomsumer.service.dataservice.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class HelloService implements IHelloService {

    @Autowired
    private ProviderService dataService;

    @Override
    public List<String> getProviderData() {
        return dataService.getProviderData();
    }

}
