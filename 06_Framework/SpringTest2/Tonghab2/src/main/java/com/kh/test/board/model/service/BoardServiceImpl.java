package com.kh.test.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BoardServiceImpl implements BoardService {
	
	private final BoardMapper mapper;

	@Override
		public List<Board> memberTitle(String memberSearch) {
			return mapper.memberTitle(memberSearch);
		}
}
