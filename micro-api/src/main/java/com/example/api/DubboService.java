package com.example.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author wen.yang
 */

@FeignClient("provider")
public interface DubboService {

   @GetMapping(value = "/testAccess")
    String testAccess();
}
