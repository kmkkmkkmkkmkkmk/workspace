package edu.kh.jdbc.model.dto;

// DTO (Data Transfer Object) : 데이터 전달용 객체
/**
 * 
 */
public class Member {

	/* DTO의 필드는 DB 컬럼과 비슷하게 작성되는 경우가 많음! */
	/* -> 상황에 따라서 필드가 추가 또는 삭제 될 수 있음! (개발자 재량) */
	
	private int memberNo;
	private String memberEmail;
	private String memberPw;
	private String memberNickname;
	private String otherPw;
	
	// java(한단어 문자열), DB(고정 길이 문자열)의 char구분하기!  -- 결국 둘이 다르다는 뜻
	private String memberTel;  // 위와 같은 관계로 String 사용해줌
	
	private String memberAddress;
	
	// Date -> String으로 변환해서 사용할 예정
	private String enrollDate;
	private String memberDelFl;
	
	// 기본 생성자 - 객체가 생성될 때 필드를 초기화
	public Member() {}
	
	// 매개 변수 생성자 (alt + shift + s --> o)
	public Member(String memberEmail, String memberPw, String memberNickname, String memberTel, String memberAddress) {
		super();
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
		this.memberNickname = memberNickname;
		this.memberTel = memberTel;
		this.memberAddress = memberAddress;
	}
	
	
	
	// 회원 탈퇴용 매개변수
	public Member(String memberEmail, String memberPw) {
		super();
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
	}
	

	// 비밀번호 변경 매개변수
	public Member(String memberEmail, String memberPw, String otherPw) {
		super();
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
		this.otherPw = otherPw;
	}
	
	
	public Member(int memberNo, String memberEmail, String memberPw, String memberNickname,
			String memberTel, String memberAddress, String enrollDate, String memberDelFl) {
		this.memberNo = memberNo;
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
		this.memberNickname = memberNickname;
		this.memberTel = memberTel;
		this.memberAddress = memberAddress;
		this.enrollDate = enrollDate;
		this.memberDelFl = memberDelFl;
	}
	
	
	// getter/setter (alt + shift + s + r)
	public int getMemberNo() {
		return memberNo; 
	}
	


	public String getOtherPw() {
		return otherPw;
	}

	public void setOtherPw(String otherPw) {
		this.otherPw = otherPw;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getMemberDelFl() {
		return memberDelFl;
	}

	public void setMemberDelFl(String memberDelFl) {
		this.memberDelFl = memberDelFl;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	
	// Object.toString() 오버라이딩(alt + shift + s --> s)
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberEmail=" + memberEmail + ", memberPw=" + memberPw
				+ ", memberNickname=" + memberNickname + ", otherPw=" + otherPw + ", memberTel=" + memberTel
				+ ", memberAddress=" + memberAddress + ", enrollDate=" + enrollDate + ", memberDelFl=" + memberDelFl
				+ "]";
	}

	
}
