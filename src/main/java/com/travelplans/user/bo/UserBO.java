package com.travelplans.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.user.dao.UserDAO;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;

	public boolean existLoginId(String loginId) {
		
		return userDAO.selectLoginId(loginId);
	}
	
	public int addUser(String loginId, String password, String nickname, String email) {
		
		return userDAO.insertUser(loginId, password, nickname, email) ;
	}
}
