package edu.kmk.practice.everything;

import java.util.Scanner;

public class PracticeEverything {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		
		// final 상수 및 if문 연습해봄
		
		System.out.println("1 또는 2를 입력하시오 : ");
		
		final int A  = 500;
		final int B  = 2100;
		final int C  = 3700;
		
		int kmk = sc.nextInt();
		
		
		
		int result1 = A + B - C;
		int result2 = A - B + C;
		
		
		if(kmk <1 || kmk >=3) {
			System.out.println("꺼져");
		} if(kmk > 1 && kmk < 3) {
			System.out.printf("%d - %d + %d = %d ", A, B, C, result2);
		} if(kmk==1) {
			System.out.printf("%d + %d - %d = %d ", A, B, C, result1);
			
		}
		
		
		
	
				
		
		
		
		
		
		
	}
}
