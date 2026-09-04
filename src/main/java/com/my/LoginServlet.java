package com.my;

import java.io.IOException;

import com.user.LoginImplementation;
import com.user.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		LoginImplementation ui = new LoginImplementation();

        User user = ui.login(email, password);
        
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("register.html");
        } else {
            resp.sendRedirect("reastaurants");
        }
    }
}
