package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserImplementation {

    static String URL = "jdbc:mysql://localhost:3306/users";
    static String USERNAME = "root";
    static String PASSWORD = "071421";


    static String insert_query =
            "INSERT INTO user(name,email,password,date_of_birth,phone_number)"
            + " VALUES(?,?,?,?,?)";



    // Database connection method
    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return con;
    }



    // Add user method
    public int adduser(User user) {

        try {

            Connection con = getConnection();

            PreparedStatement stm = con.prepareStatement(insert_query);


            stm.setString(1, user.getName());
            stm.setString(2, user.getEmail());
            stm.setString(3, user.getPassword());
            stm.setDate(4, user.getDate_of_birth());
            stm.setString(5, user.getPhone_number());


            stm.executeUpdate();


            return 1;


        } catch (SQLException e) {

            e.printStackTrace();

        }


        return 0;

    }

}