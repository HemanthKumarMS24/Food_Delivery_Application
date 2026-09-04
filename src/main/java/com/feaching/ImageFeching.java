package com.feaching;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/restaurantImage")
public class ImageFeching extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "071421";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement ps = con.prepareStatement(
                    "SELECT image FROM restaurant WHERE restaurantid=?");

            ps.setInt(1, Integer.parseInt(id));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                byte[] image = rs.getBytes("image");

                if (image != null) {
                    resp.setContentType("image/jpeg");
                    resp.getOutputStream().write(image);
                } else {
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                }

            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }

            rs.close();
            ps.close();
            
            
            
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}