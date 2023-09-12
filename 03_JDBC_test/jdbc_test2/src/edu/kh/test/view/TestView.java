package edu.kh.test.view;

import java.util.Scanner;

import edu.kh.test.model.dto.ShopMember;
import edu.kh.test.model.service.ShopService;

public class TestView {
	
	private Scanner sc = new Scanner(System.in);
	private ShopService service = new ShopService();
	
	
	public void insertMember() {
		System.out.print("ID : ");
		String memberId = sc.next();
		
		System.out.print("PW : ");
		String memberPw = sc.next();
		
		System.out.print("PHONE : ");
		String phone = sc.next();
		
		System.out.print("GENDER : ");
		String gender = sc.next();
		
		ShopMember sm = new ShopMember(memberId, memberPw, phone, gender);
		
		
	}
	
	
}


