package edu.kh.variable;

public class VariableEx6 {

	//main method : 자바 프로그램 실행용 구문
	public static void main(String[] args) {
		
		/* 자바의 기본 자료형 8가지
		 * boolean(1byte)
		 * 
		 * byte(1byte)
		 * short(2byte)
		 * int(4byte, 정수 기본형)
		 * long(8byte)
		 * 
		 * float(4byte)
		 * double(8byte, 실수 기본형)
		 * 
		 * char(2byte, 유니코드(UTF-16))
		 * */
		
		
		// String (문자열)
		// - 문자열을 저장하고 다루기 위해 Java에서 제공하는 자료형
		// - 기본 자료형 X
		//  -> Java에서는 기본 자료형 아닌 것들을
		//     모두 참조형이라고 지칭함
		
		// - String의 리터럴 표기법 : "" (쌍따옴표)
		
		int number1;
		// int 자료형(정수, 4byte)변수 선언
		
		number1 = 1000000000; // 10억
//		number1 = 10000000000; // 100억
		
		
		String str1;
		// String 자료형(문자열) 변수 선언
		// * String은 어떤 값이 저장될지 모르기 때문에
		//	 기본 자료형처럼 크기가 지정되어 있지 않음
		//	 -> 저장되는 값에 따라서 달라짐
		
		str1 = "Hello";
		
		String str2 = "World";
		//String 변수 선언과 동시에 초기화
		
		//HelloWorld 출력
		System.out.println(str1 + str2);
		// 문자열끼리 더하면 이어쓰기
		
		
		System.out.println(1+0.2);
		
		
		
		
		
		
	}
}
