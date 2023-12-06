package com.kh.test.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.todo.model.dto.Todo;
import com.kh.test.todo.model.service.TodoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TodoController {

	private final TodoService service;
	
	
	@GetMapping("/") // 경로 리턴이랑 반대로 씀
	public String todoList(Model model) {
		
		List<Todo> todoList = service.todoList(); // 여러 줄과 여러 항목이라 리스트를 받아야함 List 타입으로!
		
		model.addAttribute("todoList", todoList);
		
		return "todoList";
	}
	
	
	
}
