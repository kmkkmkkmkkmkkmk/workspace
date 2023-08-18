package edu.kmk.practice.everything;

import java.util.Scanner;

public class PracticeEverything2 {

	public static void main(String[] args) {
		
		
		// 정수 덧셈 뺄셈 계산기
		Scanner sc = new Scanner(System.in);
		
		System.out.println("------정수 덧셈 / 뺄셈 / 곱셈 / 나눗셈 계산기------");
		System.out.println(" 더하기 1 입력 / 빼기 2 / 곱하기 3 / 나누기 4 입력 ");
		
		
		
		int input1 = sc.nextInt();
		
		if(input1 >4 || input1 < 1) {
			System.out.println("잘못 입력했다 다시 해");
			return; //  break가 아니었음 ... return임 복습 ㄱㄱ
		}
		
		
		
		System.out.println("정수입력 1 : ");
		int num1 = sc.nextInt();
		System.out.println("정수입력 2 : ");
		int num2 = sc.nextInt();
		System.out.println("정수입력 3 : ");
		int num3 = sc.nextInt();
		
		int result1 = num1+num2+num3; 
		int result2 = num1-num2-num3; 
		int result3 = num1*num2*num3; 
		int result4 = num1/num2/num3; 
		
		
		if(input1 == 1) {
			System.out.printf(" [%d + %d + %d = %d]", num1, num2, num3, result1);
		} 
		
		if(input1 == 2) {
			System.out.printf(" [%d - %d - %d = %d]", num1, num2, num3, result2);
		} 
		
		if(input1 == 3) {
			System.out.printf(" [%d * %d * %d = %d]", num1, num2, num3, result3);
		} 
		
		if(input1 == 4) {
			System.out.printf(" [%d / %d / %d = %d]", num1, num2, num3, result4);
		} 
		
		
	}
}
