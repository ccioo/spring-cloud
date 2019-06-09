package com.example.microcommon.intercepter;

import com.example.microcommon.vo.User;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RestTemplateUserContextInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		User user = UserContextHolder.currentUser();
		request.getHeaders().add("x-user-id",user.getUserId());
		request.getHeaders().add("x-user-name",user.getUserName());
		request.getHeaders().add("x-user-serviceName",request.getURI().getHost());
		return execution.execute(request, body);
	}
}
