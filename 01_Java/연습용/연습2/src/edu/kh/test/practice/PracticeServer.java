package edu.kh.test.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PracticeServer {

	public void start() {
		
		int mkport = 1253; // 내가 정한 포트번호
		
		ServerSocket serverSocket = null; // 내가 정한 포트번호가 클라랑 연결되는 걸 기다리는 객체
		
		
		Socket mkclientSocket = null; // 클라랑 연결되는 객체
		
		
		InputStream mkis = null;  
		OutputStream mkos = null;
		
		BufferedReader mkbr = null;
		PrintWriter mkpw = null;   // 위에 인아웃 스트림 업글해주는 보조 스트림
		
		try {
			
			serverSocket = new ServerSocket(mkport); // 클라 연결 기다림
			mkclientSocket =  serverSocket.accept(); // 클라 접속 허용 객체
			
			mkis = mkclientSocket.getInputStream(); //  연결 후 입출력 스트림
			mkos = mkclientSocket.getOutputStream();
			
			mkbr = new BufferedReader( new InputStreamReader(mkis)); 
			// 인풋스트림에 문자열 바이트를 받은다음 버퍼드리더에 데이터를 모아둔 후 한번에 처리(개빠름)
			mkpw = new PrintWriter(mkos); // 문자 스트림이랑 바이트 스트림 같이 처리 가능printwriter

			
			
			//  서버에서 클라로 연결 됐다고 알려주는 거!
			Date mknow = new Date(); // 현재 시간을 객체에 저장
			
			SimpleDateFormat mksdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			
			String message = mksdf.format(mknow) + "[ㅎㅇ?]";
			
			mkpw.println(message); //위에 입력한 구문 출력 (클라에서)
			mkpw.flush(); //버퍼에서 모아둔 거 밀어내서 처리!
			
			String mkclientMessage = mkbr.readLine(); // 한줄로 읽기
			
			
			
			
		
		} catch (Exception e) {
			e.printStackTrace(); // 틀린 곳 위치랑 왜 틀렸는지 설명
		} finally {
			
			try {
				if(mkbr != null) mkbr.close();  // 사용한 소켓을 닫아줌 메모리 누수관리용
				if(mkpw != null) mkpw.close();  // is/os를 안닫는 이유는 보조만 닫아도 같이 닫힘
				
				if(serverSocket != null)  serverSocket.close();
				if(mkclientSocket != null) mkclientSocket.close();    // 위와 같이 누수방지로 닫아줌
				
				
				
			} catch (IOException e) {
				e.printStackTrace();
			
			
			}
		}
		
	}

}
