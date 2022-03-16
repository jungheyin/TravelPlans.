package com.travelplans.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

	public boolean selectLoginId(String loginId);
	
	public int insertUser(
			@Param("loginId") String loginId, 
			@Param("password") String password, 
			@Param("nickname") String nickname, 
			@Param("email") String email);
}
