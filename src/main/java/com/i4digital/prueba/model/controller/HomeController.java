package com.i4digital.prueba.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String inicio() {
		return "home";
	}
	
	@RequestMapping("/employees")
	public String employees() {
		return "employees";
	}
}
