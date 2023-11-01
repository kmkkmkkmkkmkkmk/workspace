package edu.kh.project.board.model.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.mapper.EditBoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class EditBoardServiceImpl implements EditBoardService {

	private final EditBoardMapper mapper;
	
	
	// 게시글 삭제
	@Override
	public int deleteBoard(Map<String, Integer> paramMap) {
		return mapper.deleteBoard(paramMap);
	}
}
