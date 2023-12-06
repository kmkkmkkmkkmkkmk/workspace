package com.kh.test.todo.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.todo.model.dto.Todo;
import com.kh.test.todo.model.mapper.TodoMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

	private final TodoMapper mapper;
	
	@Override
	public List<Todo> todoList() {
		return mapper.todoList();
	}
	
}
