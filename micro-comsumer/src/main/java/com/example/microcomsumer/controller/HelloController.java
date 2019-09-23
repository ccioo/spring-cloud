package com.example.microcomsumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.example.api.DubboService;
import com.example.microcomsumer.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 *
 */
@RestController
public class HelloController {

    @Autowired
    private IHelloService userService;
    @Autowired
    private RestTemplate restTemplate;

    @Reference
    private DubboService dubboService;


    /**
     * feign 远程调用
     */
    @GetMapping("/getProviderData")
    public List<String> getProviderData() {
        return userService.getProviderData();
    }

    /**
     * dubbo 远程掉用
     *
     * @return
     */
    @GetMapping("/testDubbo")
    public Object testDubbo() {
        String testAccess = null;
        testAccess = dubboService.testAccess();
        System.out.println(testAccess);
        return testAccess;
    }


    /**
     * restTemplate远程调用
     */
    @RequestMapping("/accessProvider")
    public String accessProvider() {
        String result
                = restTemplate.getForObject(
                "http://provider/provider/test", String.class);
        return result;
    }


}
