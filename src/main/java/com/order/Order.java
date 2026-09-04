package com.order;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {
	
	
	int orderid;
	int id;
	int restaurantid;
	BigDecimal totalamount;
	String status;
	String paymentmode;
	String address;
	Timestamp orderdate;
	
	public Order(){
		
	}

	public Order(int orderid, int id, int restaurantid, BigDecimal totalamount, String status, String paymentmode,
			String address, Timestamp orderdate) {
		super();
		this.orderid = orderid;
		this.id = id;
		this.restaurantid = restaurantid;
		this.totalamount = totalamount;
		this.status = status;
		this.paymentmode = paymentmode;
		this.address = address;
		this.orderdate = orderdate;
	}

	public Order(int id, int restaurantid, BigDecimal totalamount, String status, String paymentmode, String address,
			Timestamp orderdate) {
		super();
		this.id = id;
		this.restaurantid = restaurantid;
		this.totalamount = totalamount;
		this.status = status;
		this.paymentmode = paymentmode;
		this.address = address;
		this.orderdate = orderdate;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}

	public BigDecimal getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(BigDecimal totalamount) {
		this.totalamount = totalamount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", id=" + id + ", restaurantid=" + restaurantid + ", totalamount="
				+ totalamount + ", status=" + status + ", paymentmode=" + paymentmode + ", address=" + address
				+ ", orderdate=" + orderdate + "]";
	}
	
	
	
	

	
	
	
	

}
