package edu.kh.network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public void start() {
		
		int port = 8500;
		String ip = "127.0.0.1";
		
		// 클라이언트 -> 참조변수 5개 준비
		
		// 서버와 연결된 소켓
		Socket clientSocket = null;
		
		// 데이터 송수신용 스트림
		InputStream is = null;
		OutputStream os = null;
		
		// 스트림 성능 개선
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			// Server Socket을 찾아가 연결해달라고 부탁
			clientSocket = new Socket(ip, port);
			
			// 연결이 되었을 때만
			if(clientSocket != null) {
				
				is = clientSocket.getInputStream();
				os = clientSocket.getOutputStream();
				
				br = new BufferedReader( new InputStreamReader(is) );
				pw = new PrintWriter(os);
				
				// 서버 메시지 읽어오기
				String serverMessage = br.readLine();
				
				// 화면 출력
				System.out.println(serverMessage);
				
				Scanner sc = new Scanner(System.in); 
				System.out.print("전달할 메시지 : ");          
				String message = sc.nextLine();
				
				pw.println(message);
				pw.flush(); // 밀어내기!!
				
				
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			
			// 메모리 누수 관리
			try {
				if(br != null) br.close();
				if(pw != null) pw.close();
				if(clientSocket != null) clientSocket.close(); 
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	
}
