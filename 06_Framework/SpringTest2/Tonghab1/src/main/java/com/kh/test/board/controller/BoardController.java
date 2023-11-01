package com.kh.test.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller // 컨트롤러 속성 객체 추가
@RequiredArgsConstructor // 를 이용해 @Autowired 안썼다
public class BoardController {

	private final BoardService service; 
	// @RequiredArgsConstructor을 이용해 final을 써서 서비스 객체와 연결
	
	@GetMapping("boardCheck") // SELECT로 조회를 해야하니 GET방식
		public String boardCheck(String boardTitle,Model model) { 
		// "처음" 값을 담아 올 boardTitle 객체 생성, "처음"값을 전달 할 Model 객체 생성
			
			List<Board> boardList = service.boardCheck(boardTitle);
			// 여러 개의 값을 전달해야하기때문에 List와 Board 변수를 이용해
			// boardList 값을 담아와서 전달한다
				
			if(boardList.size() != 0) {
				
				
				// boardList에 값이 담겨있으면 model 변수를 이용해 boardList 담겨진 값을 전달
				model.addAttribute("boardList", boardList);
				
				// 정상적으로 boardList값이 담겨져있어서 searchSuccess로 리턴한다
				return "searchSuccess";
			}
			// 값이 없으면 Fail로 리턴
			return "searchFail";
		}
	}
