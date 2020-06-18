package com.neyo.usermanagement.model;

public class User {
	
	private int id;
	private String email;
	private String name;
	private String country;
	
	public User(String email, String name, String country) {
		super();
		this.email = email;
		this.name = name;
		this.country = country;
	}
	public User(int id, String email, String name, String country) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	

}
