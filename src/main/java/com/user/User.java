package com.user;

import java.sql.Date;

public class User {
	
	private int id;
	private String name;
	private String email;
	private String password;
	private Date date_of_birth;
	private String phone_number;
	
	
	public User(){
		
	}
	
	public User(int id, String name, String email, String password, Date date_of_birth, String phone_number) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.date_of_birth = date_of_birth;
		this.phone_number = phone_number;
	}


	public User(String name, String email, String password, Date date_of_birth, String phone_number) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.date_of_birth = date_of_birth;
		this.phone_number = phone_number;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", date_of_birth="
				+ date_of_birth + ", phone_number=" + phone_number + "]";
	}
	
	

}
