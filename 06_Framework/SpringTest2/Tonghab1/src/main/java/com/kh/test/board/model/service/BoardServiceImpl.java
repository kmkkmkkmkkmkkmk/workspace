package com.kh.test.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service // 서비스와 연결 어노테이션
@Transactional(rollbackFor = Exception.class) // 오류 방지 
@RequiredArgsConstructor // @Autowired를 안 쓰기위한 어노테이션
public class BoardServiceImpl implements BoardService {
	private final BoardMapper mapper; // 매퍼와 연결용 구문
	
	@Override
	public List<Board> boardCheck(String boardTitle) {
		// 전달 받을 값을 매퍼로 보내기 위한 구문 작성 및  가져온 값을 컨트롤러에 다시 반환
		return mapper.boardCheck(boardTitle);
	}
}
