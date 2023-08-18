package edu.kh.test.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class PracticeClient {

	public void start() {
		
		String ip = "127.0.0.1";  // 전세계 약속 현재 컴터 아이피라는 뜻
		int mkport = 1253; // 내가 정한 포트
		
		Socket mkSocket = null; // 서버랑 연결되는 객체
		
		
		InputStream mkis = null;  // 스트림!
		OutputStream mkos = null;
		
		BufferedReader mkbr = null; // 모아서 처리하는 버퍼드리더
		PrintWriter mkpw = null; // 문자/바이트 처리할 수 있는 프린트라이터
		
		try {
			
			mkSocket = new Socket(ip, mkport); // 서버프로그램과 ip연결하는 소켓 
			
			if(mkSocket != null) {   // 연결성공
				
				mkis = mkSocket.getInputStream();
				mkos = mkSocket.getOutputStream(); //서버와 입출력 스트림
				
				
				mkbr = new BufferedReader( new InputStreamReader(mkis));// 보조 스트림 성능개선용
				mkpw = new PrintWriter(mkos);
				
				String mkServerMessage = mkbr.readLine(); // 서버 >> 클라로 전달된 메세지 출력
				
				
				Scanner sc = new Scanner(System.in); // 클라로 메세지 전달 용
				
				String mkclientMessage = mkbr.readLine(); // 한줄로 읽기
				
				mkpw.println(mkclientMessage); // 서버로 메세지 출력
				mkpw.flush(); // 버퍼드로 인해 스트림에 모여있는 메세지 밀어내기
				
			}
		} catch (Exception e) {
			e.printStackTrace();  // 오류 위치랑 왜 틀렸는지 설명
		} finally {
			
			try { // 다 썼으면 닫기 ( 메모리 차지하는 걸 방지)
			if(mkbr != null) mkbr.close(); 
			if(mkpw != null) mkpw.close();
			if(mkSocket != null) mkSocket.close();
			
			} catch(IOException e){
				e.printStackTrace();
			}
			
			
			
		}
		
		
	}

}
