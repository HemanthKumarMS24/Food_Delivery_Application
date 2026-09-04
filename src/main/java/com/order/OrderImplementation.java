package com.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class OrderImplementation {
	
	static String URL = "jdbc:mysql://localhost:3306/users";
    static String USERNAME = "root";
    static String PASSWORD = "071421";

	static String insert_query = "INSERT INTO `order`"
            + "(id, restaurantid, totalamount, status, paymentmode, address, orderdate) "
            + "VALUES(?,?,?,?,?,?,?)";


    public int addOrder(Order order)  {
    	
    	int orderid =0;
    	  
     
   try { 
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   
	   Connection con  =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
	   
	   
	   PreparedStatement stm = con.prepareStatement(insert_query,Statement.RETURN_GENERATED_KEYS);

            stm.setInt(1, order.getId());
            stm.setInt(2, order.getRestaurantid());
            stm.setBigDecimal(3, order.getTotalamount());
            stm.setString(4, order.getStatus());
            stm.setString(5, order.getPaymentmode());
            stm.setString(6, order.getAddress());
            stm.setTimestamp(7, order.getOrderdate());


          int  effectedrows = stm.executeUpdate();
          System.out.println("OrderImplementation.addOrder: affectedRows=" + effectedrows +
                  ", userId=" + order.getId() + ", restaurantId=" + order.getRestaurantid() +
                  ", total=" + order.getTotalamount());
          
          if(effectedrows == 0) {
         	  throw new SQLException("Creating order failed, no rows affected ");
          }
          
          
       ResultSet  res = stm.getGeneratedKeys();
          
          while(res.next()) {
         	  orderid = res.getInt(1);
          }
          System.out.println("OrderImplementation.addOrder: generated orderid=" + orderid);
   }
   
   catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
   catch(SQLException e) {
	   e.printStackTrace();
   }


        return orderid;
    }

}