package com.feaching;

import java.io.IOException;
import java.util.List;

import com.restaurant.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reastaurants")
public class RestaurantServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ReastorentFeaching rf = new ReastorentFeaching();
		
		List<Restaurant> list = rf.getAllRestaurants();
		
		  req.setAttribute("reastaurants", list); //key and the object 
		  
		  req.getRequestDispatcher("/reastaurant.jsp").forward(req, resp);
		
		
	}

}
