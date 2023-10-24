package com.kh.test.user.model.service;

import com.kh.test.user.model.dto.User;

public interface UserService {

	/** 아이디로 조회
	 * @param userId
	 * @return
	 */
	User userSearch(String userId);

}
