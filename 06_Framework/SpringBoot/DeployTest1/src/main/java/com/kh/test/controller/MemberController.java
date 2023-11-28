package com.kh.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	@PostMapping("loginTest")
	public String loginTest(Model model, 
		@RequestParam("id") String id,
		@RequestParam("pw") String pw) {
			
		
		String message = null;
		
		if(id.equals("user01") && pw.equals("pass01")) {
			message = "성공";
			model.addAttribute("message", message);
		} else {
			message = "실패";
			model.addAttribute("message", message);
		}
		return "loginResult";
	}
	
}
