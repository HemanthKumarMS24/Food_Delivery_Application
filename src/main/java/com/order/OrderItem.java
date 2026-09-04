package com.order;

import java.math.BigDecimal;

public class OrderItem {

	int orderitemid;
	int orderid;
	int menuid;
	int quantity;
	BigDecimal price;
	BigDecimal total;
	
	
	
	public OrderItem(){
		
	}
	
	public OrderItem(int orderitemid, int orderid, int menuid, int quantity, BigDecimal price, BigDecimal total) {
		super();
		this.orderitemid = orderitemid;
		this.orderid = orderid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
	}
	
	
	public OrderItem(int orderid, int menuid, int quantity, BigDecimal price, BigDecimal total) {
		super();
		this.orderid = orderid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
	}


	public int getOrderitemid() {
		return orderitemid;
	}



	public void setOrderitemid(int orderitemid) {
		this.orderitemid = orderitemid;
	}



	public int getOrderid() {
		return orderid;
	}



	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}



	public int getMenuid() {
		return menuid;
	}



	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}



	public BigDecimal getTotal() {
		return total;
	}



	public void setTotal(BigDecimal total) {
		this.total = total;
	}



	@Override
	public String toString() {
		return "OrderItem [orderitemid=" + orderitemid + ", orderid=" + orderid + ", menuid=" + menuid + ", quantity="
				+ quantity + ", price=" + price + ", total=" + total + "]";
	}
	
	
	
	
	
	
}
