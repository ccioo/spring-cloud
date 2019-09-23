package com.example.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author wen.yang
 */

@FeignClient("provider")
public interface DubboService1 {

    @RequestMapping(value = "/getDashboard", method = RequestMethod.GET)
    String testAccess1();
}
