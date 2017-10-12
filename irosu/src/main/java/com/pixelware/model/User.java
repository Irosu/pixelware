package com.pixelware.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * POJO para trabajo con usuarios
 * 
 * @author irsrg
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String email;
	private String country;
	private String date;
	private String password;
	
	public User(int id, String name, String email, String country, String date, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.date = date;
		this.password = password;
	}

	public User() {}

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}