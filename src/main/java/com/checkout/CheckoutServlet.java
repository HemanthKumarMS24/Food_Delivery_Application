package com.checkout;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.order.OrderItem;
import com.cart.Cart;
import com.cart.CartItems;
import com.order.Order;
import com.order.OrderImplementation;

import com.order.orderitemsimplementation;
import com.user.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/OrderServlet")
public class CheckoutServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("login.html");
            return;
        }

        Integer restaurantid = (Integer) session.getAttribute("restaurantid");
        String paymentmode = req.getParameter("paymentmode");
        String address = req.getParameter("address");
        String totalAmountParam = req.getParameter("totalamount");
        BigDecimal grandTotal = null;

        System.out.println("CheckoutServlet.doPost entered");
        System.out.println(" cart=" + cart + ", cartSize=" + (cart == null ? 0 : cart.getItems().size()) +
                ", user=" + user + ", restaurantid=" + restaurantid + ", totalAmountParam=" + totalAmountParam);

        if (totalAmountParam != null && !totalAmountParam.isEmpty()) {
            grandTotal = new BigDecimal(totalAmountParam);
        } else {
            grandTotal = (BigDecimal) session.getAttribute("grandTotal");
        }

        if (cart != null && !cart.getItems().isEmpty()) {
            Order order = new Order();
            order.setId(user != null ? user.getId() : 0);
            order.setRestaurantid(restaurantid != null ? restaurantid : 0);
            order.setOrderdate(new Timestamp(System.currentTimeMillis()));
            order.setPaymentmode(paymentmode);
            order.setAddress(address);
            order.setStatus("pending");
            order.setTotalamount(grandTotal != null ? grandTotal : BigDecimal.ZERO);

            OrderImplementation orderImpl = new OrderImplementation();
            int orderid = orderImpl.addOrder(order);

            System.out.println("Generated Order ID = " + orderid);

            if (orderid > 0) {
                orderitemsimplementation orderitemimp = new orderitemsimplementation();

                for (CartItems items : cart.getItems().values()) {
                    OrderItem orderItem = new OrderItem();

                    orderItem.setOrderid(orderid);
                    orderItem.setMenuid(items.getMenuid());
                    orderItem.setQuantity(items.getQuanity());
                    orderItem.setPrice(items.getPrice());
                    orderItem.setTotal(
                            items.getPrice().multiply(BigDecimal.valueOf(items.getQuanity()))
                    );

                    orderitemimp.addOrderItem(orderItem);
                }
            }

            session.removeAttribute("cart");
            session.removeAttribute("restaurantid");
            session.removeAttribute("grandTotal");

            resp.sendRedirect("orderconfirmation.jsp");
        } else {
            resp.sendRedirect("cart");
        }




    }

}