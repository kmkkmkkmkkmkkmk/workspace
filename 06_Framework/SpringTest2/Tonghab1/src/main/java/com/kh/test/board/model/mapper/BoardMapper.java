package com.kh.test.board.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.test.board.model.dto.Board;

@Mapper // 매퍼 연결용 어노테이션

public interface BoardMapper {

	List<Board> boardCheck(String boardTitle);
	// 값을 매퍼로 전달
	
}
