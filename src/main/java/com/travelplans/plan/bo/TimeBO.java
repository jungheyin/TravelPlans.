package com.travelplans.plan.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.plan.dao.TimeDAO;
import com.travelplans.plan.model.Time;

@Service
public class TimeBO {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TimeDAO timeDAO;
	
	public void time(int travelId, int itineraryId, int planId) {
		
		boolean existTime = existList(travelId, itineraryId, planId);
		
		if(existTime) {
			// 삭제
			timeDAO.deleteTimeByTravelIdItineraryIdPlanId(travelId, itineraryId, planId);
		} else {
			// insert
			timeDAO.insertTime(travelId, itineraryId, planId);
			
		}
	}
	
	public boolean existList(int travelId, int itineraryId, int planId) {
		
		int count = timeDAO.selectTimeCountByTravelIdItineraryIdPlanId(travelId, itineraryId, planId);
		
		
		return count > 0 ? true : false;
		
	}
	
	public Time getTimeByTravelIdItineraryIdPlanId(int travelId, int itineraryId, int planId) {
		
		return timeDAO.selectTimeByTravelIdItineraryIdPlanId(travelId, itineraryId, planId);
		
	}
	
	
}
