package edu.kh.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.project.admin.model.service.AdminService;
import edu.kh.project.member.model.dto.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {
	
	// AdminService 의존성 주입
	@Autowired
	private AdminService service;
	
	
	/** 관리자 메인 페이지
	 * @return "admin/admin-main"
	 */
	@GetMapping("main")
	public String adminMain( ) {
		// forward : 요청 위임
		// Thymeleaf 
		// - prefix : classpath:/templates/
		// - suffix : .html
		return "admin/admin-main";
	}
	
	
	/**
	 * @param inputEmail
	 * @param model
	 * @return
	 */
	@GetMapping("selectMember")
	public String selectMember(String inputEmail, Model model) {
		
		
		
		Member searchMember = service.selectMember(inputEmail);
		
		// 이메일이 일치하는 회원이 존재하는 경우
		// model.addAttribute("searchMember", value);
		// return "admin/success"; // forward
		if(searchMember != null) {
			model.addAttribute( "searchMember", searchMember);
			return "admin/success";
		}
		return "admin/fail";
		
		// 이메일이 일치하는 회원이 존재하지 않는 경우
		// return "admin/fail"; // forward
		
		
		
	}
	
	
	
	
	
}
