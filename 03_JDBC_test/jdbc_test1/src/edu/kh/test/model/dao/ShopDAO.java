package edu.kh.test.model.dao;

import static edu.kh.test.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.kh.test.model.dto.ShopMember;

public class ShopDAO {

   private PreparedStatement pstmt = null;
   private ResultSet rs = null;
   
   public ShopMember selectMember(Connection conn, String memberId) {
      
      ShopMember sm = null;

      try {
    	 // sql에 ?가 있으면 PreparedStatement 사용
         String sql = "SELECT * FROM SHOP_MEMBER WHERE MEMBER_ID = ?";
         
         // PreparedStatement 생성
         pstmt = conn.prepareStatement(sql);
         
         // ?에 알맞은 값 대입  (누락)
         pstmt.setString(1, memberId);
         
         // sql(SELECT) 수행 후 결과(ResultSet) 반환 (누락)
         rs= pstmt.executeQuery();
         	// DML인 경우 : executeUpdate() -> int 반환
         
         
         if(rs.next()) { // 1행 조회 시 if문 사용이 효율이 좋음
        	
            String id = rs.getString("MEMBER_ID");
            String pw = rs.getString("MEMBER_PW");
            String phone = rs.getString("PHONE");
            
            // 조회된 컬럼명과 얻어오려는 컬럼명이 다름(성별 -> GENDER)
            String gender = rs.getString("GENDER");
            
            sm = new ShopMember(id, pw, phone, gender);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
    	  // 마지막에 JDBC 객체 자원을 무조건 반환하는 구문 누락
    	  close(rs);
    	  close(pstmt);
      }
      
      return sm;
   }
   

}
