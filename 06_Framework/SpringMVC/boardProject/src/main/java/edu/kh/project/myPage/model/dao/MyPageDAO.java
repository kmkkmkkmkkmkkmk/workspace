package edu.kh.project.myPage.model.dao;

import java.util.Map;

import edu.kh.project.member.model.dto.Member;

//인터페이스 사용 이유 : 규칙성 부여, 결합도 약화

public interface MyPageDAO {

	/** 회원 정보 수정
	 * @param updateMember
	 * @return result
	 */
	int info(Member updateMember);

	/** 회원 비밀번호 조회
	 * @param memberNo
	 * @return encPw
	 */
	String selectMemberPw(int memberNo);

	/** 비밀번호 변경
	 * @param map
	 * @return result
	 */
	int changePw(Map<String, Object> map);

	int secession(int memberNo);
	
	
	
	
	
	
	
	
}
