package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class UesrController {

	@Autowired
	private UserService service;
	
	
	
	@GetMapping("userSearch")
	public String userSearch(String userId, Model model) {
		
		User searchMember = service.userSearch(userId);
		
		if(searchMember != null) {
			model.addAttribute("searchMember", searchMember);
			return "searchSuccess";
		} 
		return "searchFail";
		
		
	}
	
	
}
