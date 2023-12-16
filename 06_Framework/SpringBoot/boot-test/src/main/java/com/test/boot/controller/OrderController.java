package com.test.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderController {
	

	@PostMapping("/mainPage")
	public String todal(Model model) {
		
		int todal = 0;
		
		if(todal > 0) {
			return "resultPage";
		}
		return "errorPage";
	}
}
