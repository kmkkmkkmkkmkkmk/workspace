package edu.kh.project.myPage.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.mapper.MyPageMapper;

@Transactional
@Service
public class MyPageServiceImpl implements MyPageService{
	
	@Autowired
	private MyPageMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Override
	public int info(Member updateMember, String[] memberAddress) {
		
		// 주소 가공
		if(updateMember.getMemberAddress().equals(",,")) {
			updateMember.setMemberAddress(null); // null로 변환
			
		} else { // 주소를 입력한 경우
			// 배열 -> 문자열로 합쳐서 inputMember에 추가
			String address = String.join("^^^", memberAddress);
			updateMember.setMemberAddress(address);
		}
		
		// mapper 호출 후 결과 반환
		return mapper.info(updateMember);
	}
	
	@Override
	public int changePw(String currentPw, String newPw, int memberNo) {
		
		// 1. 로그인한 회원의 비밀번호 조회
		String encPw = mapper.selectMemberPw(memberNo);
		
		// 2. 현재 비밀번호(currentPw), 조회한 비밀번호(encPw) 비교
		if(!bcrypt.matches(currentPw, encPw)) { // 같지 않다
			return 0;
		}
		
		// 3. 같으면 새 비밀번호 변경
		// (주의사항) 마이바티스 코드의 파라미터는 1개만 가능!
		// -> 지금 newPw, memberNo 두개가 필요
		// --> 하나로 묶어서 해결! (Map, DTO)
		
		Map<String, Object> map = new HashMap<>();
		map.put("newPw", bcrypt.encode(newPw));
		map.put("memberNo", memberNo);
		
		return mapper.changePw(map);
		
	}
	
	
	@Override
	public int secession(String memberPw, int memberNo) {
		
		// 로그인한 회원의 암호화된 비밀번호 조회
		String encPw = mapper.selectMemberPw(memberNo);
		
		if( !bcrypt.matches(memberPw, encPw) ) { // 같지 않으면
			return 0;
		}

		// 탈퇴 처리 SQL 수행
		return mapper.secession(memberNo);
		
		
	}
	
}
