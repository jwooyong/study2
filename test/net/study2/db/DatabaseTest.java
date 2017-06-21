package net.study2.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import net.study2.user.User;
import net.study2.user.UserTest;

public class DatabaseTest {

	@Test
	public void crudAndFindWhenExisted() {
		
		User user = UserTest.TEST_USER;
		Database.addUser(user);
		
		User dbUser = Database.findUserId(user.getUserId());
		
		assertEquals(user, dbUser);
	}
	
	
	@Test
	public void crudAndFindWhenNotExisted() {
		
		User dbUser = Database.findUserId("user2");
		
		assertNull(dbUser);
	}
}
