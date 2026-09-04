package com.menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MenuImplementation {
	static String URL = "jdbc:mysql://localhost:3306/users";
	static String USERNAME ="root";
	static String PASSWORD = "071421"; 
	
	static String insert_query ="INSERT INTO menu(restaurantid,itemname,description,price,category,image,isavailable)"
			+"Values(?,?,?,?,?,?,?)";
	
	public void addmenu(Menu menu ){
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			PreparedStatement stm = con.prepareStatement(insert_query);
			stm.setInt(1,menu.getRestaurantid() );
			stm.setString(2, menu.getItemname());
			stm.setString(3, menu.getDescription());
			stm.setBigDecimal(4, menu.getPrice());
			stm.setString(5,menu.getCategory());
			stm.setBinaryStream(6,menu.getImage());
			stm.setBoolean(7,menu.getIsavailable());
			
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
