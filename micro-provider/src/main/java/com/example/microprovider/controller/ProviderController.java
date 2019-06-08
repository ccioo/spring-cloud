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
		System.out.println("auth success, the user is : " + UserContextHolder.currentUser().getUserName());
		System.out.println("----------------success access provider service----------------");
		return "success access provider service!";
	}
	@GetMapping("/getDashboard")
	public List<String> getProviderData(){
		List<String> provider = new ArrayList<String>();
		provider.add("hystrix dashboard");
		return provider;
	}
}
