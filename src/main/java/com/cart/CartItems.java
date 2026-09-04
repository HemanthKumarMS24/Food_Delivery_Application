package com.cart;

import java.math.BigDecimal;

public class CartItems {
	
	int menuid;
	int restaurantid;
	String name;
	BigDecimal price;
	int quanity;
	
	public CartItems(){
		
	}

	public CartItems(int menuid, int restaurantid, String name, BigDecimal price, int quanity) {
		super();
		this.menuid = menuid;
		this.restaurantid = restaurantid;
		this.name = name;
		this.price = price;
		this.quanity = quanity;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public int getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}
	
	

	@Override
	public String toString() {
		return "CartItems [menuid=" + menuid + ", restaurantid=" + restaurantid + ", name=" + name + ", price=" + price
				+ ", quanity=" + quanity + "]";
	}
	
	

}
