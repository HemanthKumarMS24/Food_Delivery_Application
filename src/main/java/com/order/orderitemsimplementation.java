package com.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class orderitemsimplementation {
	
	
	static String URL = "jdbc:mysql://localhost:3306/users";
    static String USERNAME = "root";
    static String PASSWORD = "071421";
	
	static String insert_query = "INSERT INTO `order_items` "
            + "(orderid, menuid, quantity, price, total) "
            + "VALUES(?,?,?,?,?)";

	
    public int addOrderItem(OrderItem item) {
    	
    
        int result = 0;
        
        System.out.println("Rows inserted = " + result);
        
        try {
			
        	
        	Class.forName("com.mysql.cj.jdbc.Driver");
			
	 Connection con  =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
	 
	 PreparedStatement stm = con.prepareStatement(insert_query);
	 

	 stm.setInt(1, item.getOrderid());
	 stm.setInt(2, item.getMenuid());
	 stm.setInt(3, item.getQuantity());
	 stm.setBigDecimal(4, item.getPrice());
	 stm.setBigDecimal(5, item.getTotal());
			
			
			
	 result = stm.executeUpdate();

			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        
        catch(Exception e) {

            e.printStackTrace();
        
        }

        

        return result;
    }

}