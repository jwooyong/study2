package net.study2.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.study2.db.Database;

@WebServlet("/users/save")
public class SaveUserServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		User user = new User(userId, password, name, email);
		Database.addUser(user);
		
		resp.sendRedirect("/");
	}
}
