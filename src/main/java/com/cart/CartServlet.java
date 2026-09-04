package com.cart;

import java.io.IOException;
import java.util.List;

import com.menu.Menu;
import com.menu.MenuImplementation;
import com.menufeching.menufeching;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		Integer restaurantid =(Integer)session.getAttribute("restaurantid");

		int newrestaurantId = Integer.parseInt(req.getParameter("restaurantId"));


		if (cart == null || restaurantid == null || restaurantid != newrestaurantId) {

			cart = new Cart();
			session.setAttribute("cart", cart);
			session.setAttribute("restaurantid", newrestaurantId);
		}

		String action = req.getParameter("action");

		if (action.equals("add")) {
			addItemToCart(req, cart);
		}
		else if (action.equals("update")) {
			updateItemToCart(req, cart);
		}
		else if (action.equals("delete")) {
			deleteItemFromCart(req, cart);
		}

		resp.sendRedirect("cart.jsp");

	}


	private void deleteItemFromCart(HttpServletRequest req, Cart cart) {

		int menuid = Integer.parseInt(req.getParameter("menuid"));
		cart.removeItem(menuid);

	}

	private void addItemToCart(HttpServletRequest req, Cart cart) {

		int menuid = Integer.parseInt(req.getParameter("menuid"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));

		menufeching mf = new menufeching();
		Menu menu = mf.selectById(menuid);

		HttpSession session = req.getSession();
		session.setAttribute("restaurantid", menu.getRestaurantid());

		if(menu != null) {

			CartItems cartitem = new CartItems(menu.getMenuid(),menu.getRestaurantid(),menu.getItemname(),menu.getPrice(),quantity);

			cart.addItem(cartitem);
		}

	}

	private void updateItemToCart(HttpServletRequest req, Cart cart) {

		int menuid = Integer.parseInt(req.getParameter("menuid"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));


		cart.updateItem(menuid,quantity);

	}
}
