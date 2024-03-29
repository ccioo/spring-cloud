package com.example.microcommon.intercepter;

import com.alibaba.fastjson.JSON;
import com.example.microcommon.util.UserPermissionUtil;
import com.example.microcommon.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserContextInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse respone, Object arg2) throws Exception {
		User user = getUser(request);
//		UserPermissionUtil.permission(user);
//		if(!UserPermissionUtil.verify(user,request)) {
//			respone.setHeader("Content-Type", "application/json");
//			String jsonstr = JSON.toJSONString("无访问权限");
//			respone.getWriter().write(jsonstr);
//			respone.getWriter().flush();
//			respone.getWriter().close();
//			throw new PermissionException("无访问权限");
//		}
		UserContextHolder.set(user);
		ServletRequestAttributes servletRequestAttributes = new ServletRequestAttributes(request,respone);
		servletRequestAttributes.setAttribute("user", user, 1);
		RequestContextHolder.setRequestAttributes(servletRequestAttributes, false);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse respone, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse respone, Object arg2, Exception arg3)
			throws Exception {
//		UserContextHolder.shutdown();
	}
	
	private User getUser(HttpServletRequest request){
		String userid = request.getHeader("x-user-id");
		String username = request.getHeader("x-user-name");
		User user = new User();
		user.setUserId(userid);
		user.setUserName(username);
		return user;
	}
	
	static class PermissionException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public PermissionException(String msg) {
	        super(msg);
	    }
	}
}
