package edu.kh.control.loop.practice;

import java.util.Scanner;

public class LoopPractice {

	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요");
		int i = sc.nextInt();
		int count=1;
			
		if(i>=1 && i<=4) {
			
			count++;
			
			System.out.print(count + " ");
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}
		
//		for(int i = 1 ; i<=4 ; i++) {
//			count++;
//			
//			System.out.print(count + " ");
//		}
		
		
//		while( i<=4 ) {
//			
//			i++;
//			System.out.print(i + " ");
//		}
		
		
		
		
		
		
	}

	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요 : ");
		int num = sc.nextInt();
//		if(num <= 0) {
//			System.out.print("1 이상의 숫자를 입력하세요");}
		
		for( ;  num >= 1 ;  num-- ) {
			
			System.out.print(num + " ");
		} for( ; num<=0 ; ) {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}
		}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요 : ");
		int num = sc.nextInt();
		int sum = 0;
		for(int i=1 ; i<=num ; i++) {
			System.out.print(i);
			
			if(i < num) {
				System.out.print(" + ");
			}
		}
		
		System.out.print(sum);
	}

	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자 : ");
		int input1 = sc.nextInt();
		System.out.print("두번째 숫자 : ");
		int input2 = sc.nextInt();
		
		// 입력 받은 수가 1이상인가?
		/* 쉬운 방법
		if(input1 >= 1 && input2 >= 1) {
			
			// 작은 수부터 큰 수까지 1씩 증가하며 반복
			if(input1 <= input2) { // 먼저 입력한 수가 작거나 같을 때
				for(int i=input1 ; i <= input2 ; i++) {
					System.out.print(i + " ");
				}
				
			}else {// 나중에 입력한 수가 작을 때
				
				for(int i = input2 ; i <= input1 ; i++) {
					
				}
				System.out.print(i + " ");
			}
		} 
				*/
		
		// 생각을 좀 해봐야되는 방법 + 변수를 아는가?
		if(input1 > input2) {
			// 먼저 입력한 수가 더 큰 경우
			
			// 두 변수의 값 교환(임시 변수 필요) - 사람이 손이 두개라 동시 처리 가능하지만 컴퓨터는 하나만 처리가능	
			int temp = input1;
			
			input1 = input2;
			input2 = temp;
			
		}
		
		for(int i = input1 ; i <= input2 ; i++) {
			System.out.print(i + " ");
		}
		
	}
	
	public void practice5() {
	Scanner sc = new Scanner(System.in);
	
	System.out.print("단 입력 : ");
	int dan = sc.nextInt();
	
	System.out.printf("\n=====%d단=====\n", dan);
	
	for(int i=1 ; i<=9 ; i++) {
		System.out.printf("%d * %d = %d \n",dan, i, dan*i);
	}
	
	}
	
	
	public void practice6() {
    Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int input = sc.nextInt();
		
//		if(!(input >= 2 && input <= 9) { // 2 ~ 9 사이가 아닐 경우
		if(input < 2 || input > 9) { // 위와 동일
			
		} else {
			
			for(int dan = input ; dan<= 9 ; dan ++) {
				System.out.printf("===== %d ===== \n", dan);
				
				for(int i = 1 ; i <= 9 ; i++) {
					System.out.printf("%d x %d = %d \n", dan, i, dan*i);
				}
			}
		}
	}



}
	


