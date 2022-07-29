package com.travelplans.new_travel.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.new_travel.dao.NewTravelDAO;
import com.travelplans.new_travel.model.Travel;

@Service
public class NewTravelBO {
	
	// logger가져오기
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private NewTravelDAO newTravelDAO;

	// 저장
	public void addTravel(int userId, String title, String startDate, String endDate) {
		newTravelDAO.insertTravel(userId, title, startDate, endDate);
	}
	
	public Travel getTravelById(int id) {
		return newTravelDAO.selectTravelById(id);
	}
	
	public List<Travel> getTravelListById(int id) {
		return newTravelDAO.selectTravelListById(id);
	}
	
	// 수정
	public int updateTravel(int travelId, int userId, String title, String startDate, String endDate) {
		
		// travelId에 해당 여행이 있는지 db에서 가져온다.
		Travel travel = getTravelById(travelId);
		// 여행이 없는경우 logger로 남기기
		if (travel == null) {
			logger.error("[update_travel] 여행정보 없음!!!" + travelId);
			return 0;
		} else {
			// 여행정보가 있을경우 수정하고, 없을경우 업데이트 안하기
			return newTravelDAO.updateTravelByIdUserId(travelId, userId, title, startDate, endDate);
		}
		
	}
	
}
