package com.pixelware.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Clase para trabajar con el JSON del tiempo
 * 
 * @author irsrg
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Current implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int temp_c;
	
	public Current() {}

	public int getTemp_c() {
		return temp_c;
	}

	public void setTemp_c(int temp_c) {
		this.temp_c = temp_c;
	}
}