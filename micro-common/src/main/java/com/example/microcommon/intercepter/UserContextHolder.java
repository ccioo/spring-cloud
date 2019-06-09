package com.example.microcommon.intercepter;

import com.example.microcommon.vo.User;

public class UserContextHolder {
	public static InheritableThreadLocal<User> context = new InheritableThreadLocal<>();
	public static User currentUser() {
		return context.get();
	}
	public static void set(User user) {
		context.set(user);
	}
	public static void shutdown() {
		context.remove();
	}
}
