package net.study2.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	public Connection getConnection() {
		
		
		String url = "jdbc:mysql://13.124.148.36:3306/dev_java";
		String id = "dev_java";
		String pw = "dev_java";
		
		try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			return DriverManager.getConnection(url,id,pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void insert(User user) throws SQLException {
		
		String sql = "insert into users values(?,?,?,?)";
		
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		
		pstmt.executeUpdate();
	}

	public User findByUserID(String string) throws SQLException {
		
		String sql = "select * from users where userId = ?";
		
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		
		pstmt.setString(1, string);		
		
		ResultSet rs = pstmt.executeQuery();
		
		if (!rs.next()) {
			return null;
		}
		
		return new User(
					rs.getString("userId"), 
					rs.getString("password"), 
					rs.getString("name"), 
					rs.getString("email"));			
	}

	public void updateUser(User user) throws SQLException {
		
		String sql = "update USERS set password = ?, name = ?, email = ? where userId = ?";
		
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getUserId());
		
		pstmt.executeUpdate();
	}

	public void removeUser(String userId) throws SQLException {

		String sql = "delete from USERS where userId = ?";
		
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		
		pstmt.setString(1, userId);
		
		pstmt.executeUpdate();		
	}

}
