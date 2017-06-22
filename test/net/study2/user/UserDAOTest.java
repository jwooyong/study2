package net.study2.user;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

public class UserDAOTest {

	private UserDAO userDAO;

	@Before
	public void setup() {
		userDAO = new UserDAO();
	}
	
	@Test
	public void connection() {
		Connection con = userDAO.getConnection();		
		assertNotNull(con);		
	}
	
	
	@Test
	public void insert() throws Exception {
		userDAO.insert(UserTest.TEST_USER);
	}
	
	@Test
	public void findByUserId() throws Exception {		
		User user = userDAO.findByUserID(UserTest.TEST_USER.getUserId());
		assertEquals(UserTest.TEST_USER, user);
	}
	
	@Test
	public void update() throws Exception {
		
		User user = UserTest.TEST_USER;
		userDAO.removeUser(UserTest.TEST_USER.getUserId());
		userDAO.insert(user);
		User dbUser = userDAO.findByUserID(UserTest.TEST_USER.getUserId());
		assertEquals(UserTest.TEST_USER, dbUser);
		
		//User updateUser = new User(UserTest.TEST_USER.getUserId(),"upassword","uname","u@email.com" );
		//userDAO.updateUser(updateUser);
		//dbUser = userDAO.findByUserID(UserTest.TEST_USER.getUserId());
		//assertEquals(updateUser, dbUser);
		
		
	}

}
