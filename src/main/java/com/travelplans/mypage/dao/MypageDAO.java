package com.travelplans.mypage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.travelplans.mypage.model.Travel;

@Repository
public interface MypageDAO {

	public List<Travel> selsectTravelList(int userId);
	
	public Travel selectTravelById (int travelId);
	
	public int updateNicknameById(
			@Param("userId") int userId, 
			@Param("nickname") String nickname);
	
	public int deleteTravelByIdUserId(
			@Param("travelId") int travelId, 
			@Param("userId") int userId);
	
}
