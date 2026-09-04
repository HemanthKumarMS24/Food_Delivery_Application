package com.menufeching;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.menu.Menu;

public class menufeching {

    static String URL = "jdbc:mysql://localhost:3306/users";
    static String USERNAME = "root";
    static String PASSWORD = "071421";

    static String select_query = "SELECT * FROM menu WHERE restaurantid = ?";

    static String select_by_id = "SELECT * FROM menu WHERE menuid = ?";

    // Fetch all menu items of a restaurant
    public List<Menu> selectall(int restaurantId) {

        List<Menu> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement stm = con.prepareStatement(select_query);
            stm.setInt(1, restaurantId);

            ResultSet res = stm.executeQuery();

            while (res.next()) {

                int menuid = res.getInt("menuid");
                int restaurantid = res.getInt("restaurantid");
                String itemname = res.getString("itemname");
                String description = res.getString("description");
                BigDecimal price = res.getBigDecimal("price");
                String category = res.getString("category");
                InputStream image = res.getBinaryStream("image");
                Boolean isavailable = res.getBoolean("isavailable");
                Timestamp created_at = res.getTimestamp("created_at");

                Menu menu = new Menu(
                        menuid,
                        restaurantid,
                        itemname,
                        description,
                        price,
                        category,
                        image,
                        isavailable,
                        created_at
                );

                list.add(menu);
            }

           

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Fetch a single menu item by Menu ID
    public Menu selectById(int menuid) {

        Menu menu = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement stm = con.prepareStatement(select_by_id);
            stm.setInt(1, menuid);

            ResultSet res = stm.executeQuery();

            if (res.next()) {

                int restaurantid = res.getInt("restaurantid");
                String itemname = res.getString("itemname");
                String description = res.getString("description");
                BigDecimal price = res.getBigDecimal("price");
                String category = res.getString("category");
                InputStream image = res.getBinaryStream("image");
                Boolean isavailable = res.getBoolean("isavailable");
                Timestamp created_at = res.getTimestamp("created_at");

                menu = new Menu(
                        menuid,
                        restaurantid,
                        itemname,
                        description,
                        price,
                        category,
                        image,
                        isavailable,
                        created_at
                );
            }

          

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return menu;
    }
}