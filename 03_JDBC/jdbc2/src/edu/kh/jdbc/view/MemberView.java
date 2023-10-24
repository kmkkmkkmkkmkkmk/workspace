package edu.kh.jdbc.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Member;
import edu.kh.jdbc.model.service.MemberService;

public class MemberView {
	
	// 필드
	private Scanner sc = new Scanner(System.in);
	private MemberService service = new MemberService();
	
	// alt + shift + j : 툴팁 주석
	
	/**
	 *  메뉴 출력용 메서드
	 */
	public void displayMenu() {
		
		int input = -1;
		
		do {
			try {
				System.out.println("\n--- Member 테이블로 JDBC 연습하기 ---\n");
				
				System.out.println("1. 회원 가입(INSERT)");
				System.out.println("2. 회원 정보 수정(UPDATE)");
				System.out.println("3. 회원 탈퇴 (DELETE)");
				System.out.println("4. 비밀번호 변경(UPDATE)");
				// 이메일, 비밀번호, 새 비밀번호를 입력 받아 
				
				// 이메일, 비밀번호가 일치하는 회원의 비밀번호를 
				
				// 새 비밀번호로 변경
				// 메서드 이름 : updatePw()
				// hint : Member 객체 하나라 안된다
				//		(비밀번호가 두개임)
				
				
				System.out.println("0. 종료");
				
				System.out.print("메뉴 선택 >> ");
				
				input = sc.nextInt();
				
				switch(input) {
				case 1 : insertMember(); break;
				case 2 : updateMember(); break;
				case 3 : deleteMember(); break;
				case 4 : updatePw(); break;
				
				case 0 : System.out.println("\n프로그램 종료\n"); break;
				default : System.out.println("\n메뉴에 작성된 번호만 입력하세요\n");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("\n[잘못된 입력 입니다]\n");
				sc.nextLine(); // 입력 버퍼에 잘못 입력된 문자열 제거
			}
			
		} while(input != 0);
	}

	
	/**
	 *  회원 가입 화면
	 */
	private void insertMember() {
		System.out.println("\n***** 회원가입 *****\n"); 
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		System.out.print("닉네임 : ");
		String nickname = sc.next();
		
		System.out.print("휴대폰 번호(-제외) : ");
		String tel = sc.next();
		sc.nextLine(); //  입력 버퍼 개행문자 제거
		
		System.out.print("주소 : ");
		String address = sc.nextLine(); // 주소는 띄어쓰기가 있어서 nextLine 쓴거임
		
		// 입력 받은 값을 Member 객체에 저장하기
		Member Member = new Member(email, pw, nickname, tel, address);
		
		// 서비스로 member를 전달한 후 수행 결과 반환 받기
		// -> DML(INSERT,UPDATE,DELETE) 결과는 성공한 행의 수(int)로 반환
		
		int result = service.insertMember(Member); // 1 또는 0
		
		if(result > 0) {
			System.out.println("회원 가입 성공!!!");
		} else {
			System.out.println("회원 가입 실패......");
		}
	}
	
	
	/**
	 *  회원 정보 수정 화면
	 */
	private void updateMember() {
		
		// 아이디, 비밀번호가 일치하는 회원의
		// 닉네임, 전화번호, 주소를 수정
		// (아이디 중복 없다고 가정)
		
		System.out.println("\n***** 회원 정보 수정 *****\n");
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		System.out.print("수정할 닉네임 : ");
		String nickname = sc.next();
		
		System.out.print("수정할 휴대폰 번호(-제외) : ");
		String tel = sc.next();
		sc.nextLine(); //  입력 버퍼 개행문자 제거
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		
		// Member 객체를 생성하여 입력 받은 값을 대입
		Member member = new Member(email, pw, nickname, tel, address);
		
		// 회원 정보 수정 서비스 호출(member 전달) 후 
		// 결과(수정된 행의 개수(int)) 반환 받기
		int result = service.updateMember(member);
		
		// result == 1 : 수정 성공(이메일, 비밀번호 모두 일치)
		// result == 0 : 수정 실패(이메일 또는 비밀번호 불일치)
		
		if(result > 0) System.out.println("회원 정보 수정 성공!!");
		else		   System.out.println("아이디 또는 비밀번호 불일치");
	}
	
	
	
	/**
	 *  회원 탈퇴 화면
	 */
	private void deleteMember() {
		
		// 이메일, 비밀번호가 일치하는 회원 탈퇴(DELETE)
		// 이메일, 비밀번호 일치 -> 탈퇴 성공
		// 불일치 -> 이메일 또는 비밀번호 불일치 출력
		
		System.out.println("\n***** 회원 탈퇴 *****\n");
		
		System.out.println("회원 탈퇴하실 이메일 입력해주세요 : ");
		String email = sc.next();
		
		System.out.println("비밀번호를 입력하세요 : ");
		String pw = sc.next();
		
		// 1) 기본 생성자로 객체 생성 후 seter로 값 세팅
//		Member member = new Member();
//		member.setMemberEmail(email);
//		member.setMemberPw(pw);
		
		
		// 2) 이메일, 비밀번호를 매개변수로 갖는 생성자 만들기
		Member member = new Member(email, pw);
		
		
		// 삭제 서비스 호출 (성공 1, 실패 0 반환)
		int result = service.deleteMember(member);
		
		if(result > 0 ) System.out.println("탈퇴 성공");
		else 			System.out.println("이메일 또는 비밀번호 불일치");
		
	}
	
	
	
	/**
	 *  회원 비밀번호 변경
	 */
	private void updatePw() {
		System.out.println("\n***** 비밀번호 변경 *****\n");
		
		System.out.println("비밀번호 변경 확인 절차");
		System.out.print("이메일을 입력해주세요 : ");
		String email = sc.next();
		
		System.out.print("변경 전 비밀번호를 입력해주세요 : ");
		String pw = sc.next();
		
		System.out.print("변경 할 비밀번호를 입력해주세요 : ");
		String otherPw = sc.next();
		
		Member member = new Member(email, pw, otherPw);
		
		int result = service.newPw(member);
		
		if (result > 0) System.out.println("탈퇴 성공");
		else			System.out.println("잘못된 비밀번호를 입력하셨습니다.");
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

