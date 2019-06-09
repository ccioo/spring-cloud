package com.example.microprovider.controller;

import com.example.microcommon.intercepter.UserContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProviderController {
	
	@GetMapping("/provider/test")
	public String test(HttpServletRequest request) {
		return "success access provider service!";
	}

	@GetMapping("/getDashboard")
	public List<String> getProviderData(){
		List<String> provider = new ArrayList<>();
		provider.add("hystrix dashboard");
		return provider;
	}
}
