package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;

@Transactional // 예외 발생 시 롤백
@Slf4j // 로그
@Service // Service 역할(비즈니스 로직) + bean 등록
public class MemberServiceImpl implements MemberService{

	// 암호화 객체 의존성 주입(DI)
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	// DB 연결 역할 수행 객체 의존성 주입
	@Autowired
	private MemberMapper mapper;
	
	
	@Override
	public Member login(Member inputMember) {
		
		// 1. 이메일이 일치하는 탈퇴하지 않은 회원 정보 조회(pw 포함)
		Member loginMember = mapper.login(inputMember);
		
		
		// 2. 조회 결과가 없을 경우 return null;
		//log.debug("DB 조회 결과 : " + loginMember);
		if(loginMember == null) return null;
		
		// 3. 입력 받은 비밀번호(평문)와 
		// 조회한 비밀번호(암호문)가 같지 않으면 return null;
		if(!bcrypt.matches(inputMember.getMemberPw(),
							loginMember.getMemberPw())) {
			return null;
		}
		
		// 4. 비밀번호가 일치하면 비밀번호 제거 후 return
		loginMember.setMemberPw(null);
		
		return loginMember;
	}
	
	
	
}
