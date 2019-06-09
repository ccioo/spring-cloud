package com.example.microcommon.intercepter;

import com.example.microcommon.vo.User;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        /*ServletRequestAttributes attributes
                = (ServletRequestAttributes) RequestContextHolder .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String values = request.getHeader(name);
                requestTemplate.header(name, values);
            }
        }*/
        User user = UserContextHolder.currentUser();
        requestTemplate.header("x-user-id",user.getUserId());
        requestTemplate.header("x-user-name",user.getUserName());
        requestTemplate.header("x-user-serviceName", user.getAllowPermissionService());
        UserContextHolder.shutdown();
    }
}
