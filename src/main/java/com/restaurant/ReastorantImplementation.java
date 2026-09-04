package com.restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ReastorantImplementation {
	static String URL = "jdbc:mysql://localhost:3306/users";
	static String USERNAME ="root";
	static String PASSWORD = "071421";
	
	static String insert_query ="INSERT INTO restaurant(name,cuisine_type,address,phone_number,email,delivery_time,rating,image,is_active)"
			+"values(?,?,?,?,?,?,?,?,?)";
	
	
	public void add(Restaurant restaurant ) {
		
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		
		PreparedStatement stm = con.prepareStatement(insert_query);
		
		stm.setString(1,restaurant.getName());
		stm.setString(2, restaurant.getCuisine_type());
		stm.setString(3, restaurant.getAddress());
		stm.setString(4, restaurant.getPhone_number());
		stm.setString(5,restaurant. getEmail());
		stm.setInt(6,restaurant.getDelivery_time());
		stm.setBigDecimal(7, restaurant.getRating());
		stm.setBinaryStream(8, restaurant.getImage());
		stm.setBoolean(9, restaurant.getIs_active());
		//stm.setTimestamp(10, new Timestamp (System.currentTimeMillis()));
		
		stm.executeUpdate();
			
	}
	
	catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	catch(SQLException e) {
		e.printStackTrace();
	}
	
	
	}
	

}
