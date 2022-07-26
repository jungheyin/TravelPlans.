package com.travelplans.plan.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.plan.dao.PlanDAO;
import com.travelplans.plan.model.Plan;

@Service
public class PlanBO {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PlanDAO planDAO;
	
	public void addPlan (int itineraryId, String date, String planName, String time,
			String location, String memo, int price) {
		
		planDAO.insertPlan(itineraryId, date, planName, time, location, memo, price);
	}
	
	public List<Plan> getPlanListByItineraryId (int itineraryId) {
		
		return planDAO.selectPlanListByItineraryId(itineraryId);
	}
	
	
	public Plan getPlanByPlanId (int planId) {
		
		return planDAO.selectPlanByPlanId(planId);
	}	
	
	public int updatePlan(int planId, int itineraryId, String date, String planName, String time,
			String location, String memo, int price) {
		
		Plan planById = getPlanByPlanId(planId);
		
		if (planById == null) {
			logger.error("[update Plan] null planId" + planId);
			return 0;
		}
		return planDAO.updatePlan(planId, itineraryId, date, planName, time, location, memo, price);
	}
	
}
