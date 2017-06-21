package net.study2.user;

import static org.junit.Assert.*;

import org.junit.Test;

import net.study2.db.Database;

public class UserTest {
	
	public static User TEST_USER = new User("userId", "password", "name", "email");

	@Test
	public void matchPassword() {
		
		assertTrue(TEST_USER.matchPassword("password"));
	}

	@Test
	public void notMatchPassword() {
		
		assertFalse(TEST_USER.matchPassword("password2"));
	}
	
	@Test
	public void login() throws Exception {
		
		User user = UserTest.TEST_USER;
		Database.addUser(user);
		
		assertTrue(User.login(TEST_USER.getUserId(), TEST_USER.getPassword()));
	}
	
	@Test(expected=UserNotFoundException.class)
	public void loginWhenNotExistUser() throws Exception {		
		User.login("userId2", TEST_USER.getPassword());
	}
	
	@Test(expected=PasswordMismatchException.class)
	public void loginWhenPassword() throws Exception {
		
		User user = UserTest.TEST_USER;
		Database.addUser(user);
		
		User.login(TEST_USER.getUserId(), "password2");		
	}
}
