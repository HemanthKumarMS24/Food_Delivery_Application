package com.feaching;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.Restaurant;

public class ReastorentFeaching {
	static String URL = "jdbc:mysql://localhost:3306/users";
	static String USERNAME ="root";
	static String PASSWORD = "071421";
	
	static String selectAll_query = "SELECT * FROM restaurant";
	
	public List<Restaurant> getAllRestaurants() {
		
		Connection con;
		Statement stm;
		ResultSet res;
		
	
		
	    List<Restaurant> list = new ArrayList<>();
	    
	    try {
	    
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	 con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
	    	 stm = con.createStatement();
	    	
	    	 res = stm.executeQuery(selectAll_query);
    	
	    	while(res.next()) {
	    		int restaurantid = res.getInt("restaurantid");
	    		String name = res.getString("name");
	    		String cuisine_type = res.getString("cuisine_type");
	    		String address = res.getString("address");
	    		String  phone_number = res.getString("phone_number");
	    		String email = res.getString("email");
	    		int delivery_time = res.getInt("delivery_time");
	    		BigDecimal rating = res.getBigDecimal("rating");
	    	    InputStream image = res.getBinaryStream("image");
	    	   Boolean  is_active =  res.getBoolean("is_active");
	    	  Timestamp created_at = res.getTimestamp("created_at");
	    		
	    		
	 Restaurant allres = new Restaurant(restaurantid,name,cuisine_type,address,phone_number,email,delivery_time,rating,image,is_active,created_at);
	    		list.add(allres);
	 
	 
	    	}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    }
	    
	    catch(ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	    
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
	    
	   
	    
	    return list;
	}

}
