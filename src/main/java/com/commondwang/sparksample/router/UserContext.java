package com.commondwang.sparksample.router;

import com.commondwang.sparksample.data.User;

public class UserContext {
	
	private static final ThreadLocal<User> currentUser = new ThreadLocal<User>();
	

	public static User getCurrentUser() {
		return currentUser.get();
	}
	public static void setCurrentUser(User user) {
		currentUser.set(user);
	}
	public static boolean userSignedIn() {
		return currentUser.get() != null;
	}

	public static void removeCurrentUser() {
		currentUser.remove();
	}
}
