package com.commondwang.sparksample.store;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.commondwang.sparksample.data.User;
import com.commondwang.sparksample.util.UUID;

@Component
public class UserStore {
	/**
	 * the sample memory user storage
	 */
	private static Map<String, User> storage = new ConcurrentHashMap<String, User>();
	
	private static Map<String, String> name_storage = new ConcurrentHashMap<String, String>();

	public UserStore(){
		//hard code the admin user 
		User admin = new User();
		admin.setUserId(UUID.random());
		admin.setUserName("admin");
		admin.setPassword("pass");
		storage.put(admin.getUserId(), admin);
		name_storage.put(admin.getUserName(), admin.getUserId());
	}
	
	public User get(String uid){
		 return storage.get(uid);
	}
	
	public User getByName(String name){
		 String userId = name_storage.get(name);
		 if(null != userId){
			 return storage.get(userId);
		 }
		 return null;
	}
}
