package net.study2.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.Response;

@WebServlet("/users/updateForm")
public class UpdateFromUserServelt extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		
		Object object = session.getAttribute(LoginServlet.USER_ID);
		
		if ( object == null) {
			resp.sendRedirect("/");
			return;
		}
		
		String userId = (String)object;
		UserDAO userDao = new UserDAO();
		try {
			User user = userDao.findByUserID(userId);
			req.setAttribute("user", user);
			RequestDispatcher rd = req.getRequestDispatcher("/update_form.jsp");
			rd.forward(req,  resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
