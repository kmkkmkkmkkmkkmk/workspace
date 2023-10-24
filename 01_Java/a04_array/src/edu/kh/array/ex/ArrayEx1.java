package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx1 {

	/* 배열(자료구조)
	 * - 같은 자료형의 변수를 하나의 묶음으로 다루는 것
	 * 
	 * - 묶여진 변수들은 하나의 이름(배열명)
	 *	 각 변수들은 index를 이용해서 구분하게 된다.
	 *
	 *	 (index : 색인, 자료의 위치)
	 *
	 * - index의 번호는 0부터 시작
	 */
	
	
	
	// 배열 할당, 선언, 초기화 (0)
	public void ex1() {
		
		// 변수 선언
		int a; // int 자료형을 저장할 변수 a 선언(메모리 공간 할당)
		
		// 배열 선언
		int[] arr;
		// int 자료형 변수를 묶어서 다루는 배열 arr을 선언
		// int[]은 참조형
		
		
		
		// 변수 대입 (== 값 자체를 대입)
		a = 10;
		
		// 배열 대입 (== 할당)
		arr = new int[3];
		// new : 연산자 : Heap 영역에 새로운 메모리를 할당
		// (메모리 할당 : 메모리 공간을 차지한다)
		
		// int[3] : int 변수 3칸짜리 배열
		
		// new int[3]
		// Heap 영역에 int 변수 3칸짜리 배열 새롭게 할당
		// -> 할당된 배열에 시작 주소가 생김
		
		
		// arr = new int[3]
		// - new int[3]으로 생성된 배열의 시작 주소를
		// 	 arr에 대입
		
		// -> arr 호출 시 
		//	  arr에 저장된 주소를 참조해 
		// 	  Heap 영역에 할당된 배열을 찾아감
		//    --> 이래서 int[]을 "참조형"이라고 한다.
		
		
		
		
		// * 배열 다루기 *
		System.out.println("arr : " + arr); // [I@7c30a502 -> 주소 값 출력
		
		System.out.println("arr[0] : " + arr[0]); // 0 -> 기본 값
		System.out.println("arr[1] : " + arr[1]); // 0
		System.out.println("arr[2] : " + arr[2]); // 0
		
		
		
	}
	
	// 배열 선언 및 할당 + 직접 초기화
	public void ex2() {
		
		// int 자료형 4개를 묶음으로 다루는 배열 numbers를
		// 선언 및 할당해라
		
		//int[] numbers; // 선언
		//numbers = new int[4]; // 할당
		
		int[] numbers = new int[4]; // 선언 및 할당
				
		// new 연산자 : Heap 영역에 메모리를 새롭게 할당		
			
		
		//* 배열 직접 초기화 *//
		
		numbers[0] = 10;
		numbers[1] = 100;
		numbers[2] = 1000;
		numbers[3] = 10000;
		
		// * 인덱스는 0부터 시작해서
		// 	 배열의 크기(길이) -1까지 이다.
		
		System.out.println(numbers[0]);
		System.out.println(numbers[1]);
		System.out.println(numbers[2]);
		System.out.println(numbers[3]);
		
//		// * 배열 + 반복문(for)
//		for(int i = 0 ; i <= 3 ; i++) {
//			System.out.printf("numbers{%d] = %d \n", i, numbers[i]);
//		}
//		System.out.println("------------------------------------");
		
		// 10000
		// 1000
		// 100
		// 10
		
		
		numbers[0] = 10;
		numbers[1] = 100;
		numbers[2] = 1000;
		numbers[3] = 10000;
		
		for(int i = 3 ; i >= 0 ; i--) {
//			System.out.printf("numbers[%d] = %d \n", i, numbers[i]);
			System.out.println(numbers[i]);
			
		}
		
	}
	
	
	
	// 3명의 키를 입력받아
	// 입력받은 키 + 평균 키 출력  (배열 이용)
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		// double형 배열을 참조할 변수 heightArray 선언(주소 저장) 후
		// Heap 영역에 double 3칸짜리 배열을 할당하여 
		// 그 주소를 heightArray 저장한다.
		double[] heightArray = new double[3];
		
		
		// 3명의 키를 입력
		for(int i = 0 ; i<3 ; i++) {
		
			System.out.print(i + "번 키 입력 : ");
			heightArray[i] = sc.nextDouble();
		}
		
		System.out.println("-------------------");
		
		// * 배열명.length : 배열의 길이(크기)를 반환 *
							// 3
		
		double sum = 0.0;
		
		for(int i = 0 ; i<heightArray.length ; i++) {
			System.out.printf("[%d번째의 키} = %.1f \n", i , heightArray[i]);
			
			sum+= heightArray[i]; // 합계
		}
		
		System.out.println("평균 : " + sum/3.0);
		
		
	}
	
	
	
	// 점심 메뉴 뽑기 프로그램
	// (배열 선언과 동시에 초기화)
	public void ex4() {
		
		// 문자열 배열 선언 및 할당
//		String[] menuArray = new String[5];
//		menuArray[0] = "햄버거";
//		menuArray[1] = "돈까스";
//		menuArray[2] = "제육볶음";
//		menuArray[3] = "샐러드";
//		menuArray[4] = "닭갈비";
		
		
		// 배열 선언과 동시에 초기화
		String[] menuArray = {"햄버거", "돈까스", "제육볶음"
								,"샐러드", "닭갈비", "순대국밥"
								, "평양냉면", "삼각김밥+컵라면"
								,"도시락", "육회비빔밥" };
		
		
		
		
		
		// 배열 index범위 내 난수를 발생
		int index = (int)(Math.random() * menuArray.length);
				//  (int)(0.0 <= x < 5.0)	
				//  (0.0 <= x < 5.0) --> 0 1 2 3 4
		
		System.out.println("오늘의 메뉴 : " + menuArray[index]);
	}
	
	
	
	
	// 분식집 주문 프로그램 - 업그레이드 버전
	public void ex5() {
		
		// 배열 두개를 생성 후 
		// 같은 인덱스 번호에 메뉴명, 가격을 작성
		
		String[] menus = {"원조김밥", "참치김밥", "치즈김밥", "라면", "떡볶이"};
		
		int[] prices = {3000, 4000, 4000, 3500, 5000};
		
		
		Scanner sc = new Scanner(System.in); 
		
		
		String orderMenu = ""; // 주문한 메뉴를 저장할 변수
		int sum = 0; // 주문한 메뉴의 가격을 저장할 변수
		
		while(true) {
			System.out.println("$$$$ 우리 가게 메뉴 $$$$");
			
			// 메뉴 출력
			for(int i = 0 ; i<menus.length ; i++) { 
				System.out.printf("<%d> %s [%d원] \n" , i , menus[i], prices[i]);
			}
			System.out.println("<9> 주문 완료");
			
			System.out.print("((메뉴 선택)) =>> ");
			int input = sc.nextInt();
			
			// 만약에 9를  입력한 경우 반복문을 멈춰라
			if(input == 9) {
				break;
			}
			
			// 메뉴 인덱스 범위를 초과할 때 "잘못 입력" 출력
			else if(input <0 || input >= menus.length ) {
				System.out.println("**잘못 입력**");
			}
			else { // 정상 입력 -> 누적
				orderMenu += menus[input] + " ";
				sum += prices[input];
			} 
			
		} // while 종료
		
		System.out.println("주문한 메뉴 : " + orderMenu);
		System.out.println("합계 " + sum + "원");
	}
	
	
	
	
	// 입력받은 양의정수 만큼의 크기를 가지는 배열 만들기
	public void ex6() {
		
		// [평균 점수 구하기]
		// 입력 받을 인원 수 : 4       ---> int 4칸짜리 배열 생성
		// 1번 점수 입력 : 100
		// 2번 점수 입력 : 20
		// 3번 점수 입력 : 50
		// 4번 점수 입력 : 90
		
		// 합계 : 260 점
		// 평균 : 65 점
		
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 받을 인원 수 : ");
		int num = sc.nextInt();
		
		int[] scores = new int[num]; // 입력 받은 수 만큼의 길이를 가지는 배열 할당
		
		
		
		
		
		int sum = 0;
		
					  // == num
		for(int i = 0 ; i <scores.length ; i++) {
			System.out.print( (i+1) + "번 점수 입력 : ");
			
			//(int)
			scores[i] = sc.nextInt(); // 입력 받은 정수를 배열 요소 저장 
			
			// scores : 배열명
						// i : 인덱스
						// scores[i] : scores의 i번째 요소
					
						sum += scores[i]; // 합계 누적
		}
			
		System.out.println("합계 : " + sum + " 점");
		System.out.println("평균 : " + sum/scores.length  + " 점");
	}
	
	/* 생성할 배열의 길이 : 3     <- 입력
	 * 
	 * 0번 인덱스 요소 : 40		  <- 입력
	 * 1번 인덱스 요소 : 60		  <- 입력
	 * 2번 인덱스 요소 : 80		  <- 입력
	 * 
	 * 
	 * 저장된 값을 확인하려는 인덱스(-1 종료) : 0		  <- 입력
	 * 0번 인덱스 : 40
	 * 
	 * 저장된 값을 확인하려는 인덱스(-1 종료) : 2		  <- 입력
	 * 2번 인덱스 : 80
	 * 
	 * 저장된 값을 확인하려는 인덱스(-1 종료) : 99		  <- 입력
	 * 존재하지 않는 인덱스 번호 입니다.
	 * 
	 * 저장된 값을 확인하려는 인덱스(-1 종료) : -1		  <- 입력
	 * 프로그램 종료
	 * 
	 */
	
	public void ex7() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("생성할 배열의 길이 : ");
		
		int input = sc.nextInt();
		
		// 입력 받은 input 만큼 길이를 가지는 배열 생성
		int[] arr = new int[input]; 
		
		// 생성된 배열의 모든 요소에 입력 값을 대입
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.printf(i + "번 인덱스 요소 : ");
			arr[i] = sc.nextInt();
		}
		
		
		while(true) {
			System.out.print("저장된 값을 확인하려는 인덱스(-1 종료) : ");
			int index = sc.nextInt();
			
			// 무엇을 입력했는가(index 값에) 따라서 동작을 구분
			if(index == -1) {
				System.out.println("프로그램 종료");
				break; // 반복 종료
			}
			
			
			
			// 배열 인덱스 범위를 초과하는 경우
			if(index < 0 || index > arr.length) {
				System.out.println("존재하지 않는 인덱스 번호 입니다.");
				continue; // 다음 반복으로 이동 (반복문 처음으로 이동)
			}
			
			
			// 정상 인덱스 입력
			System.out.printf("%d번 인덱스 : %d \n", index, arr[index]);
			
			// 요즘 개발 트렌드는 if문만 사용한다!
			// 왜? 유지보수가 편해서
		} 
	}
	
	
	
	
	public void ex8() {
		
		// 얕은 복사
		// - 참조하는 주소만을 복사하여 
		// 서로 다른 참조 변수가 하나의 배열을 참조하게 만드는 것
		
		// 특징 : 하나의 배열을 참조하기 때문에 값을 공유함
		
		int[] arr = {10,20,30,40,50};
		
		// 얕은 복사
		int[] copyArr = arr;
		// arr에 저장된 주소를 copyArr에 저장
		
		System.out.println(arr); // arr에 저장된 주소 값(해시코드)
		System.out.println(copyArr); // copyArr에 저장된 주소 값(해시코드)
		System.out.println(arr == copyArr);
		
		// arr을 이용해서 배열에 저장된 값 변경
		arr[0] = 99;
		arr[1] = 1234;
		
		
		
		// Arrays 클래스 : 배열 관련 기능을 모아둔 클래스(자바에서 제공)
		
		// Arrays.toString(배열명) : 배열에 저장된 값을 하나의 문자열로 반환
		
		System.out.println( Arrays.toString(arr) );
		System.out.println( Arrays.toString(copyArr) );
	}
	
	
	
	public void ex9() {
		
		
		// 깊은 복사
		// - 원본과 같은 참조형 변수와
		//	 원본과 같거나 더 큰배열을 만들어
		//	 원본의 데이터를 모두 복사하여 참조하는 방법
		
		
		int[] arr = {10, 20, 30, 40, 50};
		
		// 1. for문을 이용한 깊은 복사
		int[] copyArr1 = new int[arr.length]; // 5칸 
		
		for(int i=0 ; i<arr.length ; i++) {
			copyArr1[1] = arr[i]; // 원본 값을 복사본에 대입(복제)
			
		}
		
		
		
		
		
		// 2. System.arraycopy(원본배열명(ex. arr), 원본 복사 시작 인덱스 : ex. 0, 
//			복사 배열(ex. copy copyArr2) , 복사 배열의 삽입 시작 인덱스 (5칸짜리에 2라고 대입하면 2번부터 시작하면서 복사)
//		  , 복사 길이: ex. 5를 쓰면 5칸 복사)
		
		
		int[] copyArr2 = new int[arr.length];
		
		System.arraycopy(arr, 0, copyArr2, 0, arr.length);
//						  1   3     2      5      4 
		
		System.out.println("변경 전");
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(copyArr1));
		System.out.println(Arrays.toString(copyArr2));
		
		arr[0] = 1;
		copyArr1[0] = 999;
		copyArr2[0] = 6789;
		
		System.out.println("변경 후");
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(copyArr1));
		System.out.println(Arrays.toString(copyArr2));
	}
	
	
	
	
	
	
	
	
	
}
