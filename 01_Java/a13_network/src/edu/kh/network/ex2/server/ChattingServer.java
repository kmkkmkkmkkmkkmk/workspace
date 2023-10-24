package edu.kh.network.ex2.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import edu.kh.network.ex2.thread.Receiver;
import edu.kh.network.ex2.thread.Sender;

// 서버
public class ChattingServer {

	public void start() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("서버 이름 입력 : ");
		String serverName = sc.nextLine();
		
		// 1. 포트 번호 지정
		int port = 12345;
		
		ServerSocket serverSocket = null;
		
		Socket clientSocket = null;
		
		
		try {
			// 2. 클라이언트가 접속 할 수 있는 서버소켓을 생성하고 접속 대기
			serverSocket = new ServerSocket(port);
			System.out.println("<<Server Start>>");
			System.out.println("<<클라이언트 접속 대기중...>>");
			
			// 3. 클라이언트 접속 요청 시 접속을 허용하고,
			//	  클라이언트와 연결된 소켓 반환 받기
			clientSocket = serverSocket.accept();
			
			
			// 스레드를 이용해서 코드 작성 예정
			// ------------------------------------------------	
			
			// 서버 -> 클라이언트 출력 역할 객체 생성
			Sender sender = new Sender(clientSocket, serverName);
			
			// 서버 <- 클라이언트 입력 역할 객체 생성
			Receiver receiver = new Receiver(clientSocket);
			
			// 스레드로 생성
			Thread th1 = new Thread(sender);
			Thread th2 = new Thread(receiver);
			
			th1.start();
			th2.start();
			// 스레드가 시작되면서 입력, 출력이 동시에
			// 무한히 수행되는 서버 완성

			// join() : 해당 스레드 종료 시까지 현재 스레드를 대기
			th1.join();
			th2.join();
			// ------------------------------------------------		
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(serverSocket != null) serverSocket.close();
				if(clientSocket != null) clientSocket.close();
				
			} catch (IOException e) {
				e.printStackTrace();
				
			}
			
		}
		
	}

}
