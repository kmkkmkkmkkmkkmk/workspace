package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample1 {
	
 public static void main(String[] args) {
	 
	 // JDBC : Java에서 DB에 접근할 수 있게 해주는 
	 // 	   Java 제공 코드(Interface,class)
	 // 		-> java.sql 패키지에 존재
	 
	 
	 // EMPLOYEE 테이블에서
	 // 사번, 이름, 부서코드, 직급코드, 급여, 입사일 조회해서
	 // 자바 프로그램 얻어와 콘솔에 출력
	 
	 
	 
	 // 1. JDBC 객체 참조 변수 선언
	 Connection conn = null;
	 
	 Statement stmt = null;
	 
	 ResultSet rs = null;
	 
	 
	 try {
		 // 2. DriverManager를 이용해 Connection 객체 생성
		 
		 // 2-1) Oracle JDBC Driver 객체를 메모리에 로드(적재) 하기
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 
		 // 2-2) DB 연결 정보를 이용해서 Connection 객체 생성
		 String type = "jdbc:oracle:thin:@"; 
		 String host = "115.90.212.20";
		 String port = ":10000";
		 String dbName = ":ORCL";
		 String userName = "a230724_kmk";
		 String pw = "971103";
		 
		 conn = DriverManager.getConnection( type + host + port + dbName, userName , pw );
		 
		 // Connection 객체 생성 확인(오류 안나면 오타 없이 작성한 것!)
		 System.out.println(conn);
		 
		 
		 
		 
		 
		 
		 
	} catch (SQLException e) {
		 // SQLException : JDBC 관련 예외의 최상위 부모
		
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		
		
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 }
}
