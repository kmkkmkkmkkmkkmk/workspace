package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		
		int input = sc.nextInt();
		 
			
		
		//String result = input  > 0 ? "양수" : "양수아님";
		//System.out.println();
		//System.out.println(result);
		
		
		//위 세 줄을 한줄로(응용) - 실무에선 위 세줄로 알아보기 쉽게 씀
		System.out.println("\n" + (input > 0 ? "양수" : "양수 아님") );
		
				
			
				
	
	}
	
}
