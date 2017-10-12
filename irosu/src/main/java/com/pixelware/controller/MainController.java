package com.pixelware.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pixelware.model.City;
import com.pixelware.model.User;
import com.pixelware.model.Weather;
import com.pixelware.service.UserService;
import com.pixelware.service.WeatherService;

/**
 * Controlador para consumir el servicio Web REST con la temperatura
 * 
 * @author irsrg
 */
@Controller
public class MainController{

	@Autowired
	private UserService userService;

	@Autowired
	private WeatherService weatherService;
	
	@ModelAttribute("weather")
	public City setUpCity() {
		return new City();
	}
	
	@ModelAttribute("user")
	public User setUpUser() {
		return new User();
	}
	
	@GetMapping("/")
	public String getTemp() {
		return "login";
	}
	
	@PostMapping("/weather")
	public String showTemp(@ModelAttribute("weather") City city, Model model) {
		
		Weather weather = weatherService.getWeather(city.getName());
		
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
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user, Model model, HttpSession session) {
		
		User dbUser = null;

		try {
			
			dbUser = userService.getUserByName(user.getName());
			
			if(dbUser != null && user.getPassword().equals(dbUser.getPassword())) {
				session.setAttribute("currentUser", dbUser);
				return "checkWeather";
			}
			
			else {
				model.addAttribute("error", "Wrong user or password");
				return "login";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "login";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute("user") User user, Model model) {
				
		try {
			userService.addUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "login";
	}
	
	@PostMapping("/logout")
	public String logOut(HttpSession session) {
		session.setAttribute("currentUser", null);
		
		return "login";
	}
		
}