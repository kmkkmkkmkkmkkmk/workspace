package com.kh.test.board.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.test.board.model.dto.Board;

@Mapper

public interface BoardMapper {

	List<Board> boardCheck(String boardTitle);
	
	
}
