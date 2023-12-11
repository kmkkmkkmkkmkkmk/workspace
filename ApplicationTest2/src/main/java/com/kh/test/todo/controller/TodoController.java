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
	
	@GetMapping("/")
	public String todoList(Model model) {
		
		List<Todo> todoList = service.todoList();
		
		model.addAttribute("todoList", todoList);

		return "todoList";
	}
	
}
