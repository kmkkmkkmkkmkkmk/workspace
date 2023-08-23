package edu.kh.network.server;

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

public class Server {

	public void start() {
		
		int port = 8500;
		
		// 서버 -> 참조변수 6개 준비
		
		// 서버가 클라이언트를 기다리는 소켓
		ServerSocket serverSocket = null;
		
		// 클라이언트와 연결된 소켓
		Socket clientSocket = null;
		
		// 데이터 송수신용 스트림
		InputStream is = null;
		OutputStream os = null;
		
		// 스트림 성능 개선
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			// 클라이언트 연결을 port에서 기다리는 소켓
			serverSocket = new ServerSocket(port);
			
			System.out.println("[Server]");
			System.out.println("클라이언트의 접속을 기다리는 중입니다."); 
			
			// 클라이언트 연결 시 접속 허용
			// + 연결된 소켓 생성
			clientSocket = serverSocket.accept();
			
			System.out.println("[클라이언트 접속 성공]");
			
			is = clientSocket.getInputStream();
			os = clientSocket.getOutputStream();
			
			br = new BufferedReader( new InputStreamReader(is) );
			pw = new PrintWriter(os);
			
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			
			String message = sdf.format(now) + " [접속 성공]";
			pw.println(message);
			pw.flush(); // 밀어내기!!!!
			
			String clientMessage = br.readLine();
			System.out.println(clientMessage);
			
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			
			// 메모리 누수 관리
			try {
				if(br != null) br.close();
				if(pw != null) pw.close();
				if(clientSocket != null) clientSocket.close(); 
				if(serverSocket != null) serverSocket.close();
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}
}
