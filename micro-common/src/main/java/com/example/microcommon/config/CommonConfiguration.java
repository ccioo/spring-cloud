package com.example.microcommon.config;

import com.example.microcommon.intercepter.FeignRequestInterceptor;
import com.example.microcommon.intercepter.RestTemplateUserContextInterceptor;
import com.example.microcommon.intercepter.UserContextInterceptor;
import feign.RequestInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.*;

import java.time.LocalDate;

@Configuration
@EnableWebMvc
public class CommonConfiguration implements WebMvcConfigurer {
	
	/**
	 * 请求拦截器
	 */
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserContextInterceptor());
    }

	/**
	 * 跨域支持
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowCredentials(true)
				.allowedMethods("GET", "POST", "DELETE", "PUT")
				.maxAge(3600 * 24);
	}

	@Bean
	public RequestInterceptor requestInterceptor(){
		return new FeignRequestInterceptor();
	}
	
	/***
	 * RestTemplate 拦截器，在发送请求前设置鉴权的用户上下文信息
	 * @return
	 */
    @Bean
	@LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors()
				.add(new RestTemplateUserContextInterceptor());
        return restTemplate;
    }
   
}
