package edu.kh.test.WrongAnswerNotes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class WrongAnswerNotes0818_Practice {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<String> nameList = new ArrayList<String>()	;
		
		while(true) {
			System.out.print("추가할 이름 입력하세요 : ");
			String name = sc.next();
			
			if (name.equals("clear")) { // name 은 스트링변수라서 ==으로 하면 안되고 이퀄스 이용
				// continue; 여기 컨티뉴를
				System.out.println("이름 목록을 초기화 합니다.");
				nameList.clear();
				continue; // 여기 컨티뉴를 여기로 이동시켜줌
			}
			
			if (name.equals("exit")) { // name 은 스트링변수라서 ==으로 하면 안되고 이퀄스 이용
				System.out.println("<<입력 종료>>");
				break; //return;
			}
			
			if(nameList.contains(name)) {
				System.out.println("<이미 존재하는 이름입니다>");
				
			} else {
				System.out.println(name + " 추가 완료.");
				// 추가하는 구문 넣어줘야함
				nameList.add(name);
			}
		}
		
		for(String name : nameList) {
			System.out.println(name);
		}
	}
}
