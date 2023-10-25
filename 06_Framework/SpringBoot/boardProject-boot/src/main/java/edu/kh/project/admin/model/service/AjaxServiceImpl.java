package edu.kh.project.admin.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.admin.model.mapper.AjaxMapper;
import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.mapper.MemberMapper;


@Transactional
@Service
public class AjaxServiceImpl implements AjaxService{

	@Autowired
	private AjaxMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt; // 암호화
	
	@Autowired
	private MemberMapper memberMapper; // 회원 Mapper
	
	
	
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
	
	@Override
	public List<Member> selectAll() {
		return mapper.selectAll();
	}
	
	// 샘플 계정 가입
	@Override
	public int insertMember(Member member) {
		// 비밀번호 "1234"를 암호화해서 member에 추가
		member.setMemberPw( bcrypt.encode("1234"));
		
		return memberMapper.signup(member);
	}
	
	
	
	@Override
	public int updateFlag(Map<String, Object> paramMap) {
		return mapper.updateFlag(paramMap);
	}
	
	
	
}

















