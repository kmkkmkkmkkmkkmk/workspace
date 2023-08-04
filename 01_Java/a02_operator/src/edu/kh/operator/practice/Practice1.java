package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		System.out.print("인원 수 : ");
		int count = sc.nextInt();
		
		System.out.print("사탕 개수 : ");
		int candy = sc.nextInt();
		
		
		System.out.printf("1인당 사탕 개수 : %d \n", candy/count);
		System.out.printf("남는 사탕 개수 : %d \n", candy%count);
	
	}
	
}
