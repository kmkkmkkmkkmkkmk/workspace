package edu.kh.operator.ex;

import java.util.Scanner;

public class OperatorEx6 {
	public static void main(String[] args) {
	
		// Scanner 작성 후 ctrl + spacebar -> Scanner - java.util 선택
		// --> import 구문 자동 추가
		Scanner sc = new Scanner(System.in); // 외워
		
		System.out.println("[홀짝 검사기]");
		
		System.out.print("정수를 입력하세요 : ");
		int input = sc.nextInt(); // sc.nextInt<< 스캐너에 정수를 입력하는 구문(걍 외워)
		
		
		// 삼항 연산자
		
		// 조건식(true/false) ? true인 경우 : false인 경우;   // :콜론 | ;세미콜론
		
		
		String result = input % 2 == 0 ? "짝수" : "홀수"; //문자라서 String 이용
		// 조건식이 true이면 "짝수"
		// 조건식이 false이면 "홀수"
		// 를 result 변수에 저장
		
		System.out.println(result);
	
		
		
		
	}
}
