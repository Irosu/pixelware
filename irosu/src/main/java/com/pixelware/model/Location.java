package com.pixelware.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Clase para trabajar con el JSON del tiempo
 * 
 * @author irsrg
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String region;
	private String country;

	public Location() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}