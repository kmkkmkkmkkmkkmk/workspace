package edu.kh.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supplement1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

//		List<Fruit> fruitList = new ArrayList<String>();
							// -> new ArrayList<Fruit>();
		List<Fruit> fruitList = new ArrayList<Fruit>();

		Fruit f1 = new Fruit();
		
		f1.setName("딸기");
		f1.setPrice(3000);
		f1.setAmount(3);
		
		
		fruitList.add(f1);
		
		
//		fruitList.add("바나나");
		
		fruitList.add(new Fruit("바나나", 6000, 10));
		// Fruit만 저장하는 List에 String이 추가되어 문제 발생
		// "바나나" -> new Fruit("바나나", 6000, 10)
		//		    -> 해당 구문 삭제
		
		fruitList.add(new Fruit("사과", 5000, 5));
		fruitList.add(new Fruit("오렌지", 2000, 10));
		fruitList.add(new Fruit("포도", 3500, 0));
		
		
		System.out.print("과일 이름 입력 :");
		String input = sc.next();
		
		for(int i=0 ; i<fruitList.size(); i++) {
			
			Fruit f = fruitList.get(i);
			
			// String 비교시 equals() 사용 해야되는데
			// 지금은 비교 연산자 사용해서 비교 제대로 되지 않음
//			if(f.getName() == input)
			if(f.getName().equals(input)) { // 현재 요소 과일명 
									   // 입력 받은 과일명 같은지 비교

				if(f.getAmount() == 0) {
					System.out.println(input + "는 품절 되었습니다.");
				} else {
					System.out.printf("%d원 / %d개 남음 / 전체 구매 금액 : %d원 \n",
							f.getPrice(), f.getAmount(), f.getPrice() * f.getAmount());
				}
				
				// 일치하는 과일이 리스트에 있지만
				// if문 종료 시 프로그램이 종료되지 않고
				// 반복문만 종료되서
				// 반복문 이후 코드 "존재하지 않습니다." 출력 구문이 수행된다
//				break;
				return;
			}
		}
		
		System.out.println(input + "은 리스트에 존재하지 않습니다.");
	}
}


