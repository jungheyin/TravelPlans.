package com.travelplans.user.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.travel.bo.TravelBO;
import com.travelplans.user.dao.UserDAO;
import com.travelplans.user.model.User;

@Service
public class UserBO {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private TravelBO travelBO;
	
	public boolean existLoginId(String loginId) {
		
		return userDAO.selectLoginId(loginId);
	}
	
	public boolean existEmail (String email) {
		return userDAO.selectEmail(email);
	}
	
	public boolean existLoginIdEmail(String loginId, String email) {
		return userDAO.selectLoginIdEmail(loginId, email);
	}
	
	public int addUser(String loginId, String password, String nickname, String email) {
		
		return userDAO.insertUser(loginId, password, nickname, email) ;
	}
	
	public User getUserByLoginIdPassword(String loginId, String password) {
		
		return userDAO.selectUserByLoginIdPassword(loginId, password);
	}
	
	public User getUserById(int userId) {
		return userDAO.selectUserById(userId);
	}
	
	public User getUserByLoginIdEmail(String loginId, String email) {
		return userDAO.selectUserByLoginIdEmail(loginId, email);
	}
	
	public List<User> getUserByEmail(String email) {
		return userDAO.selectUserByEmail(email) ;
	}
	
	public int updateUser (int userId, String password) {
		
		// user 가져오기
		User user = getUserById(userId);
		
		if (user == null) {
			logger.error("[update / user] userBO user null userId: " + userId);
			return 0;
		}
		
		return userDAO.updateUser(userId, password);
	}
	
	public int updateNickNameByUserId(int userId, String nickname) {
		
		User user = getUserById(userId);
		
		if (user == null) {
			logger.error("[update / user] userBO user null userId: " + userId);
			return 0;
		}
		
		return userDAO.updateNickNameByUserId(userId, nickname);
	}
	
	public int deleteUserByUserId(int userId) {
		
		User user = getUserById(userId);
		
		if (user == null) {
			logger.error("[delete/ user] userBO user null userId: " + userId);
			return 0;
		}
		
		travelBO.deleteTravelByUserId(userId);
		
		return userDAO.deleteByUserId(userId);
	}
}
