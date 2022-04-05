package com.travelplans.mypage.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.mypage.dao.MypageDAO;
import com.travelplans.mypage.model.Travel;

@Service
public class MypageBO {
	
	@Autowired
	private MypageDAO mypageDAO;

	public List<Travel> getTravelList(int userId) {
		return mypageDAO.selsectTravelList(userId);
	}
	
	public Travel getTravel(int userId) {
		return mypageDAO.selectTravelById(userId);
	}
	
	public int updateNicknameById(int userId, String nickname) {
		return mypageDAO.updateNicknameById(userId, nickname);
	}
	
	public int deleteTravelByIdUserId(int travelId, int userId) {
		return mypageDAO.deleteTravelByIdUserId(travelId, userId);
	}
}
