package edu.kmk.practice.et.db.cls;

import java.util.Scanner;

public class DoubleClass {
	
	
	
	/**
	 *  switch 연습들~
	 */
	public void kmk1() {
	

	
	// 키보드로 정수를 입력 받아
			// 1 : ㄹㅂㄹㄱㄴ
			// 2 : ㅍㄹㄹ
			// 3 : ㅍㄹㅅ
			// 4 : ㅇㅅㅌㅁㅌ
			// 5 : ㅁㄹㄹ
			// 6 : ㅍㄱㄴ
			// 7 : ㅂㄱㅌ
			// 1~5가 아니면 : 
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1~7 숫자를 입력하면 뭐라도 나옴!");
		
		String result;
		int sdsd = sc.nextInt();
		
		switch(sdsd) {
			case 1 : result = "ㄹㅂㄹㄱㄴ"; break;
			case 2 : result = "ㅍㄹㄹ"; break;
			case 3 : result = "ㅍㄹㅅ"; break;
			case 4 : result = "ㅇㅅㅌㅁㅌ"; break;
			case 5 : result = "ㅁㄹㄹ"; break;
			case 6 : result = "ㅍㄱㄴ"; break;
			case 7 : result = "ㅂㄱㅌ"; break;
			default : result = "잘못입력" ; break;
		}
	
		System.out.println(result);
	}
	
	
	public void kmk2() {
		int rd = (int)(Math.random()*5+1);
		String rt = null;
		
		switch(rd) {
		case 1 : rt = "바보"; break;
		case 2 : rt = "똥개"; break;
		case 3 : rt = "멍청이"; break;
		case 4 : rt = "버러지"; break;
		case 5 : rt = "신"; break;
		
		
		}
		System.out.printf("[오늘 넌 %s ㅇㅋ?]" , rt);
	}
	
	
	public void kmk3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 말해봐~ ");
		int n = sc.nextInt();
		String result;
		
		switch(n) {
		case 1 : result = "애쉬아일랜드" ; break;
		case 2 : result = "한요한" ; break;
		case 3 : result = "빈첸" ; break;
		case 4 : result = "그리오" ; break;
		case 5 : result = "키드와인" ; break;
		case 6 : result = "창모" ; break;
		case 7 : result = "릴러말즈" ; break;
		case 8 : result = "용용" ; break;
		case 9 : result = " 비와이" ; break;
		case 10 : result = "조광일" ; break;
		case 11 : result = "저스디스" ; break;
		default : result = "다시 입력해ㅡㅡ"; break;
			
		}
		System.out.printf("오늘 너가 들을 노래의 가수는 %s!" , result);
	}
	
	
	
	
	public void kmk4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가수이름 입력하면 노래 추천해줄게~");
		
		String nm = sc.next();
		String sg;
		
		switch(nm) {
		case "애쉬"   	: sg = "paranoid"; break;
		case "창모"   	: sg = "돈이 하게했어"; break;
		case "한요한" 	: sg = "주문"; break;
		case "릴러말즈" : sg = "Trip"; break;
		case "저스디스" : sg = "g+ jus Freestyle"; break;
		case "조광일"	: sg = "곡예사"; break;
		default 		: sg = "없어 짜샤" ; break;
 		}
		System.out.printf("너가 선택한 가수는 %s\n[내가 추천하는 노래는 %s]야", nm, sg);
	}
	
	/** for 문 연습
	 *  나는 반대로 하고싶어서 홀수를 감쌈! 
	 */
	public void mkmk1() {
		
		 // 1부터 10까지 모든 정수 출력
		 // 단,  짝수는 [] 감싸서 출력
		 
		 // 1 [2] 3 [4] 5 [6] 7 [8] 9 [10]
		
		for(int k = 1 ; k <= 10 ; k++) {
			
			if(k % 2 != 0) {
				System.out.printf(" [%d] ", k);
			} else {
				System.out.print(k);
			}
			
		}
	
	}
	
	
	/**
	 *  곱셈 계산기만들기
	 */
	public void mkmk2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("곱하기 계산기");
		System.out.print("단 입력 : ");
		
		int kmk = sc.nextInt();
		
		for(int i = 1 ; i < 10 ; i++) {
		 
			
			
			int result = kmk * i;
			System.out.printf("[%d단] * %d = %d	\n" , kmk, i, result);
//			System.out.printf("[%d단] * %d = %d	\n" , kmk, i, kmk*i);
		}
	}
	
	
	
	/**
	 *  2단부터 9단 출력연습
	 */
	public void mkmk3() {
		
	
		for(int kmk = 2 ; kmk <10 ; kmk++) {
			
			for(int mk = 1 ; mk <= 9 ; mk++) {
				
				System.out.printf("%d * %d = % d \n", kmk, mk, kmk*mk);
			}
			System.out.println("------------------");
			
		}
	}
	
	
	
	/**
	 *   for문 출력 시 2개씩 묶고 괄호 넣기   - 완 -
	 */ 
	public void mkmk4() {

		for(int kmk = 0 ; kmk <=2 ; kmk++) {
			for(int mk = 3; mk <=6 ; mk++) {
				System.out.printf("(%d, %d)", kmk, mk);
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
}
