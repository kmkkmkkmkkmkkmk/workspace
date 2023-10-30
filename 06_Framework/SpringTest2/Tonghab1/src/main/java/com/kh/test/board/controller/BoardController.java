package com.kh.test.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService service;
	
	@GetMapping("boardCheck") 
		public String boardCheck(String boardTitle,Model model) {
			
			List<Board> boardList = service.boardCheck(boardTitle);
				
			if(boardList.size() != 0) {
				
				model.addAttribute("boardList", boardList);
				
				
				return "searchSuccess";
			}
			return "searchFail";
		}
	}
	
	
	
	

