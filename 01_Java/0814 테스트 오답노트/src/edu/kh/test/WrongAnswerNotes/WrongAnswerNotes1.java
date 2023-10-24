package edu.kh.test.WrongAnswerNotes;

import java.util.Scanner;

public class WrongAnswerNotes1 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	while(true) {
		System.out.print("2~9 사이 정수 입력 : ");
		
		int input = sc.nextInt();
		
		if(input>=2 && input <=9) {
			for(int num = 1; num <=9; num++) {
				System.out.printf("%d * %d = %d\n", input, num, input*num);
			}
			
		} else { 
			System.out.println("2이상 9이하의 정수만 입력해주세요.");
			
			}
			
		}
	
	}
}


/*  오답노트
 *  나머지는 잘 풀었으나
 *  원하는 구구단 입력 후 코드가 멈춰야하는 문제였고
 *  
 *  멈추는 값의 break;를 작성하지않아 무한 반복하는 구구단이 되었다!
 *  
 *  18번째 줄에 break를 넣어 원하는 값을 출력 후 멈추게 했어야했고
 *  넣지않아 아래까지 쭉 실행 및 반복되게 하는 실수를 했다!
 *  
 *  break;를 넣자~
 *  
 */


