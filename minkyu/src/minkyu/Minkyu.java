package minkyu;

import java.util.Scanner;

public class Minkyu {

	public void ex1() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
			
		
		if(input > 0) {
			
			System.out.println("양수입니다.");
			
		} if(input == 0) {
			System.out.println("양수가 아닙니다.");
		} if(input < 0 ) {
			System.out.println("음수입니다");
		}
		
	}
	
	public void ex2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input>0) {
			System.out.println("양수입니다.");
			
			
		} else if(input == 0) {
			System.out.println("양수가 아닙니다.");
		} else 
			System.out.println("음수입니다.");
		
	}
	
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		int input = sc.nextInt();
		
		if (input > 0) {
			System.out.println("양수입니다.");
		} else {
		} if (input == 0) {
			System.out.println("양수가 아닙니다.");
		} else {
			System.out.println("음수입니다.");
		}
		
	}
	
	
	public void ex4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("달을 입력해주세요 : ");
	
		int month = sc.nextInt();
		
		String season;
		
		if(month <= 3 && month <= 5 ) {
			season = "봄";
		} if(month <=6 && month <= 8 ) {
			season = "여름";
		} if(month <= 9 && month <= 11) {
			season = "가을";
		} if(month <= 12 || month == 1 || month == 2) {
			season = "겨울";
		} else {
			season = "잘못 입력함";
		}
			
	
		System.out.println(season);
	}
	
	
	public void ex5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		String dap;
		
//		if(age <= 13) {
//			dap = "어린이";
//		} else if(age < 13 && age <=19) {
//			dap = "청소년";
//		} else if (age < 0 || age > 100) {
//			dap = "잘못 입력";
//		} else {
//			dap = "성인";
//		}
//		System.out.println(dap);
			
//		if(age <= 13) {
//			dap = "어린이";
//		} else if(age < 13 && age <=19) {
//			dap = "청소년";
//		} if (age < 0 || age > 100) {
//			dap = "잘못 입력";
//		} else {
//			dap = "성인";
//		}
//		System.out.println(dap);
		
		if(age <= 13) {
			dap = "어린이";
		} if(age < 13 && age <=19) {
			dap = "청소년";
		} if (age < 0 || age > 100) {
			dap = "잘못 입력";
		} else {
			dap = "성인";
		}
		System.out.println(dap);
		
		
	}
	
	public void ex6() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("나이 입력 : ");
		int age = sc.nextInt();
		
		System.out.println("키 입력 : ");
		double tall = sc.nextDouble();
		
		if (age < 0 || age >100) {
			System.out.println("잘못 입력하셨습니다.");
		} if (age <= 12 && tall >= 140) {
			
			
		}
				
	} 
	
	
	
	
	
	
}

