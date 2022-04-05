package com.travelplans.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.user.dao.UserDAO;
import com.travelplans.user.model.User;

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
	
	public User getUserByLoginIdPassword(String loginId, String password) {
		
		return userDAO.selectUserByLoginIdPassword(loginId, password);
	}
	
	public User getUserById(int id) {
		return userDAO.selectUserById(id);
	}
}
