package com.my;

import java.io.IOException;
import java.sql.Date;

import com.user.UserImplementation;
import com.user.User;

import org.mindrot.jbcrypt.BCrypt;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class Servlet1 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		String password = req.getParameter("password");
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		
		Date  date_of_birth = Date.valueOf(req.getParameter("date_of_birth"));
		String phone_number = req.getParameter("phone_number");
		
		
		
		
		User user = new User(name,email,hashedPassword,date_of_birth,phone_number);
		UserImplementation dao = new UserImplementation();
		int res = dao.adduser(user);
		
		
		if(res == 1) {
			resp.sendRedirect("login.html");
		}
		
		else {
			resp.sendRedirect("ragister.html");
		}
		
	}

}
