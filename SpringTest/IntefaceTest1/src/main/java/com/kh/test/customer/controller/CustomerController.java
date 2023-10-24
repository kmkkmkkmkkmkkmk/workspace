package com.kh.test.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping("/static/index")
	public String signup(Customer inputCustomer, Model model) {
		
		int result = service.signup(inputCustomer);
		
		if(result > 0) {
			
			model.addAttribute("abc1", inputCustomer.getCustomerName());
			model.addAttribute("abc2", inputCustomer);
			return "result";
		} 
		
		
		return "redirect:/";
	}
	
	
}
