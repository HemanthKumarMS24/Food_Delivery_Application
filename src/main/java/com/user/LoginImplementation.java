package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

public class LoginImplementation {

    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "071421";

    public User login(String email, String password) {

        User user = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM user WHERE email=?");

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String hashedPassword = rs.getString("password");

                if (BCrypt.checkpw(password, hashedPassword)) {

                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(hashedPassword);

                    return user;
                }
            }
  
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}