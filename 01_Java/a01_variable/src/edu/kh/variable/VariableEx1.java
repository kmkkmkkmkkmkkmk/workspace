package edu.kh.variable;

public class VariableEx1 {

	// main method : 자바 프로그램을 실행시키기 위해 반드시 필요한 구문
	public static void main(String[] args) {
		
		System.out.println("[변수 사용 X]");
		// - 값의 의미 알 수 없음
		// - 같은 값을 반복해서 작성 (체력, 메모리 소비)
		// - 가독성이 떨어짐
		// - 유지보수가 불편함
		
		System.out.println(2 * 3.14159265389793 * 5);
		System.out.println(3.14159265389793 * 5 * 5);
		System.out.println(3.14159265389793 * 5 * 5 * 20);
		System.out.println(4 * 3.14159265389793 * 5 * 5);
		
		// 실행 : (ctrl + f11)
		
		
		System.out.println("-----------------------");
		
		System.out.println("[변수 사용 0]");
		
		// 변수 선언 및 초기화
		double pi = 3.14159265389793; // 원주율
		int r = 5; // 반지름
		int h = 20; // 높이
		
		
		System.out.println(2 * pi * r); // 원의 둘레
		System.out.println(pi * r * r); // 원의 넓이
		System.out.println(pi * r * r * h); // 원기둥의 부피
		System.out.println(4 * pi * r * r); // 구의 겉넓이
		
		// 변수란?
		// - 메모리(RAM)에 값을 기록하는 공간
		// - 공간에 기록되는 값이 변할 수 있어서 변수라고 한다.
		
		// 변수 장점
		// 1. 값의 의미를 파악 할 수 있음
		// 2. 같은 값을 한 번만 작성 -> 재사용성의 증가
		// 3. 가독성 증가(읽기 편함)
		// 4. 유지보수 용이(수정이 쉽다)
		
				
				
				
	}
}
