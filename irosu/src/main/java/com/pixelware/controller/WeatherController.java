package com.pixelware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pixelware.model.City;
import com.pixelware.model.Weather;
import com.pixelware.service.WeatherService;

/**
 * Controlador para consumir el servicio Web REST con la temperatura
 * 
 * @author irsrg
 */
@Controller
@SessionAttributes("weather")
public class WeatherController{

	private WeatherService service;

	@Autowired
	public void setService(WeatherService service) {
		this.service = service;
	}
	
	@ModelAttribute("weather")
	public City setUpCity() {
		return new City();
	}
	
	@GetMapping("/")
	public String getTemp() {
		return "index";
	}
	
	@PostMapping("/weather")
	public String showTemp(@ModelAttribute("weather") City city, Model model) {
		
		Weather weather = service.getWeather(city.getName());
		
		if(weather != null) {
			model.addAttribute("temp", weather.getCurrent().getTemp_c());
			model.addAttribute("city", weather.getLocation().getName());
			model.addAttribute("region", weather.getLocation().getRegion());
			model.addAttribute("country", weather.getLocation().getCountry());
        }
        
        else {
        	model.addAttribute("error", "error");
        }		
		
		return "currentWeather";
	}
}