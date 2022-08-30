package com.travelplans.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.travelplans.user.model.User;

@Repository
public interface UserDAO {

	public boolean selectLoginId(String loginId);
	
	public boolean selectEmail (String email);
	
	public boolean selectLoginIdEmail(
			@Param("loginId") String loginId, 
			@Param("email") String email);
	
	public int insertUser(
			@Param("loginId") String loginId, 
			@Param("password") String password, 
			@Param("nickname") String nickname, 
			@Param("email") String email);
	
	public User selectUserByLoginIdPassword(
			@Param("loginId") String loginId, 
			@Param("password") String password);
	
	public User selectUserById(int id);
	
	public User selectUserByLoginIdEmail(
			@Param("loginId") String loginId,
			@Param("email") String email);
	
	public List<User> selectUserByEmail(String email);
	
	public int updateUser (
			@Param("userId") int userId, 
			@Param("password") String password);
	
	public int updateNickNameByUserId(
			@Param("userId") int userId, 
			@Param("nickname") String nickname);
	
	public int deleteByUserId(int userId);
}
