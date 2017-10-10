package com.pixelware.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pixelware.model.Weather;

@Service
public class WeatherService {

	private static final String APIXU_API_KEY = "ab6851fb5c724e3f8d2105815170610";
	private static final String URL = "http://api.apixu.com/v1/current.json?key=" + APIXU_API_KEY + "&q=";
	
	public Weather getWeather(String city) {
		RestTemplate restTemplate = new RestTemplate();
        Weather weather = restTemplate.getForObject(URL + city, Weather.class);
        
        return weather;
	}
}