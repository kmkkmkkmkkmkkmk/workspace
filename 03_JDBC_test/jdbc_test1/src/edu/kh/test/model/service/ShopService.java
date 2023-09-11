package edu.kh.test.model.service;

import static edu.kh.test.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.test.model.dao.ShopDAO;
import edu.kh.test.model.dto.ShopMember;

public class ShopService {

	private ShopDAO dao = new ShopDAO();

	public ShopMember selectMember(String memberId) {
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 호출 후 결과 반환
		ShopMember sm = dao.selectMember(conn, memberId);
		
		// 3. DML(INSERT, UPDATE, DELETE)인 경우 트랜잭션 처리
		// -> SELECT는 안해도된다! (PASS)
		
		// 4. 커넥션 반환
		close(conn);
		
		// 5. 결과 반환
		return sm;
	}
	
	
	
}
