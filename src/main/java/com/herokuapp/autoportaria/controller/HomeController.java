/**
 * 
 */
package com.herokuapp.autoportaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Tiago Ferezin
 * Data: 17/12/2018
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	public HomeController() {
		// TODO Auto-generated constructor stub
		System.out.println("Iniciou-se o HomeController!!!");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model){
		return "home/index";
	}
	
}
