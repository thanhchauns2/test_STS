package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	
	@RequestMapping("/hello")
	public String home() {
		System.out.println("Hello");
		return "home";
	}
	
	@RequestMapping("/")
	public String index() {
		System.out.println("Hello");
		return "/main/index";
	}
}
