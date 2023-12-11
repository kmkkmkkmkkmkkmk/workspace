package com.kh.test.todo.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.test.todo.model.dto.Todo;

@Mapper
public interface TodoMapper {

	List<Todo> todoList();


}
