package com.example.microcomsumer.service.impl;


import com.example.api.DubboService;
import com.example.api.DubboService1;
import com.example.microcomsumer.service.IHelloService;
import com.example.microcomsumer.service.dataservice.ProviderService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class HelloServiceImpl implements IHelloService {

    @Autowired
    private ProviderService dataService;
    @Autowired
    private DubboService1 dubboService1;

    @Override
    public List<String> getProviderData() {
        return dataService.getProviderData();
    }

}
