package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.*;
import com.example.demo.service.EmployeeService;

@RequestMapping("/employees")
@Controller
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;
	
	@GetMapping
	public String home() {
		return "/employees/employees.html";
	}
	
	@GetMapping("/new")
	public String add_new(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/add-new.html";
	}
	
	@PostMapping("/save")
	public String save(Model model, @Valid Employee employee, Errors errors) {
		if(errors.hasErrors())
			return "employees/new-employee";
		employeeService.save(employee);
		return "redirect:/employees";
	}
	
}
