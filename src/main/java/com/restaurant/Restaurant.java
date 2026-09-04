package com.restaurant;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Restaurant {
	
	private int restaurantid;
	private String name;
	private String cuisine_type;
	private String address;
	private String phone_number;
	private String email;
	private int delivery_time;
	private BigDecimal rating;
	private InputStream image;
	private Boolean is_active;
	private Timestamp created_at;
	
	
	public Restaurant(){
		
	}
	
	public Restaurant(int restaurantid, String name, String cuisine_type, String address, String phone_number,
			String email, int delivery_time, BigDecimal rating, InputStream image, Boolean is_active,
			Timestamp created_at) {
		super();
		this.restaurantid = restaurantid;
		this.name = name;
		this.cuisine_type = cuisine_type;
		this.address = address;
		this.phone_number = phone_number;
		this.email = email;
		this.delivery_time = delivery_time;
		this.rating = rating;
		this.image = image;
		this.is_active = is_active;
		this.created_at = created_at;
	}

	public Restaurant(String name, String cuisine_type, String address, String phone_number, String email,
			int delivery_time, BigDecimal rating, InputStream image, Boolean is_active, Timestamp created_at) {
		super();
		this.name = name;
		this.cuisine_type = cuisine_type;
		this.address = address;
		this.phone_number = phone_number;
		this.email = email;
		this.delivery_time = delivery_time;
		this.rating = rating;
		this.image = image;
		this.is_active = is_active;
		this.created_at = created_at;
	}
	
	

	public Restaurant(String name, String cuisine_type, String address, String phone_number, String email,
			int delivery_time, BigDecimal rating, InputStream image, Boolean is_active) {
		super();
		this.name = name;
		this.cuisine_type = cuisine_type;
		this.address = address;
		this.phone_number = phone_number;
		this.email = email;
		this.delivery_time = delivery_time;
		this.rating = rating;
		this.image = image;
		this.is_active = is_active;
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

	public String getCuisine_type() {
		return cuisine_type;
	}

	public void setCuisine_type(String cuisine_type) {
		this.cuisine_type = cuisine_type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDelivery_time() {
		return delivery_time;
	}

	public void setDelivery_time(int delivery_time) {
		this.delivery_time = delivery_time;
	}

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantid=" + restaurantid + ", name=" + name + ", cuisine_type=" + cuisine_type
				+ ", address=" + address + ", phone_number=" + phone_number + ", email=" + email + ", delivery_time="
				+ delivery_time + ", rating=" + rating + ", image=" + image + ", is_active=" + is_active
				+ ", created_at=" + created_at + "]";
	}
	

}
