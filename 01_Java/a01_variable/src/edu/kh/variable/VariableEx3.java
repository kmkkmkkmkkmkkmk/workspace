package edu.kh.variable;

// import : 수입하다, 가져오다
import java.util.Scanner;

public class VariableEx3 {

	
	// main method : 자바 프로그램 실행용 구문
	
	public static void main(String[] args) {
		
		// Scanner : 사용자 입력 시 필요
		
		// 스캐너 생성
		Scanner sc = new Scanner(System.in);
		
		//print    : 출력 후 줄바꿈 X
		//println  : 출력 후 줄바꿈 O
		System.out.print("입력 : ");
		
		int input = sc.nextInt(); // 키보드에서 정수 입력 받은 후
								  // int형 변수 input에 대입

		
		System.out.println("입력 받은 값 : " + input);
		
		
		
	}
}
