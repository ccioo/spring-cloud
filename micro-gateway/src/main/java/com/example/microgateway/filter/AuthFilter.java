package com.example.microgateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 所有的请求都会经过这里
 */
@Component
public class AuthFilter implements GlobalFilter {
	private static List<String> successList = new ArrayList<>();

	public AuthFilter() {
		successList.add("spring");
		successList.add("admin");
		successList.add("cloud");
	}

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    	Route gatewayUrl = exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
    	URI uri = gatewayUrl.getUri();
    	ServerHttpRequest request = (ServerHttpRequest)exchange.getRequest();
    	HttpHeaders header = request.getHeaders();
    	String token = header.getFirst(JwtUtil.HEADER_AUTH);
    	Map<String,String> userMap = JwtUtil.validateToken(token);
    	ServerHttpRequest.Builder mutate = request.mutate();
    	if(successList.contains(userMap.get("user"))) {
    		mutate.header("x-user-id", userMap.get("id"));
        	mutate.header("x-user-name", userMap.get("user"));
        	mutate.header("x-user-serviceName", uri.getHost());
    	}else {
    		throw new PermissionException("user not exist, please check");
    	}
    	ServerHttpRequest buildReuqest =  mutate.build();
         return chain.filter(exchange.mutate().request(buildReuqest).build());
    }
}
