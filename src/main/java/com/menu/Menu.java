package com.menu;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Menu {
	int menuid;
	int restaurantid;
	String itemname;
	String description;
	BigDecimal price;
	String category;
	InputStream image;
	Boolean isavailable;
	Timestamp created_at;
	
	public Menu(){
		
	}

	public Menu(int menuid, int restaurantid, String itemname, String description, BigDecimal price, String category,
			InputStream image, Boolean isavailable, Timestamp created_at) {
		super();
		this.menuid = menuid;
		this.restaurantid = restaurantid;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.category = category;
		this.image = image;
		this.isavailable = isavailable;
		this.created_at = created_at;
	}

	
	
	

	public Menu(int menuid, int restaurantid, String itemname, String description, BigDecimal price, String category,
			InputStream image, Boolean isavailable) {
		super();
		this.menuid = menuid;
		this.restaurantid = restaurantid;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.category = category;
		this.image = image;
		this.isavailable = isavailable;
	}
	
	

	public Menu(int restaurantid, String itemname, String description, BigDecimal price, String category,
			InputStream image, Boolean isavailable) {
		super();
		this.restaurantid = restaurantid;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.category = category;
		this.image = image;
		this.isavailable = isavailable;
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

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}

	public Boolean getIsavailable() {
		return isavailable;
	}

	public void setIsavailable(Boolean isavailable) {
		this.isavailable = isavailable;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", restaurantid=" + restaurantid + ", itemname=" + itemname + ", description="
				+ description + ", price=" + price + ", category=" + category + ", image=" + image + ", isavailable="
				+ isavailable + ", created_at=" + created_at + "]";
	}
	
	

}
