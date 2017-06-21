package net.study2.db;

import java.util.HashMap;
import java.util.Map;

import net.study2.user.User;

public class Database {

	private static Map<String, User> users = new HashMap<String, User>();
	
	public static void addUser(User user) {
		System.out.println(user);
		users.put(user.getUserId(),  user);
	}

	public static User findUserId(String userId) {
		return users.get(userId);
	}
}
