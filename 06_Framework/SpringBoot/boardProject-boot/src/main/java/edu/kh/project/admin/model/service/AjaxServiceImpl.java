package edu.kh.project.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.admin.model.mapper.AjaxMapper;
import edu.kh.project.member.model.dto.Member;


@Transactional
@Service
public class AjaxServiceImpl implements AjaxService{

	@Autowired
	private AjaxMapper mapper;
	
	@Override
	public String selectMemberNo(int memberNo) {
		return mapper.selectMemberNo(memberNo);
	}

	@Override
	public String selectEmail(String inputEmail) {
		return mapper.selectEmail(inputEmail);
	}
	
	@Override
	public Member selectMember(int no) {
		return mapper.selectMember(no);
	}
	
	@Override
	public List<String> selectEmailList(String keyword) {
		return mapper.selectEmailList(keyword);
	}
	
}
