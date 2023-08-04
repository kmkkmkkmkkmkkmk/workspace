package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice5 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
	
		
		// 합계
		int sum = kor + eng + math;
		
		// 평균
		double avg = sum / 3.0;
		// int / double
		// double(자동형변환) / double == double
		 
		
		
		
		String result = kor >= 40 && eng >= 40 && math >= 40 && avg >= 60 ? "합격" : "불합격";
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println(result);
		
		
		
		
		
		
	}
	
}
