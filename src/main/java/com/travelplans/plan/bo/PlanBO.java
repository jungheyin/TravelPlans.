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
		
		Plan plan = getPlanByPlanId(planId);
		
		if (plan == null) {
			logger.error("[update Plan] null planId" + planId);
			return 0;
		}
		return planDAO.updatePlan(planId, itineraryId, date, planName, time, location, memo, price);
	}
	
	public int deletePlan(int planId, int itineraryId) {
		
		Plan plan = getPlanByPlanId(planId);
		
		if (plan == null) {
			logger.error("[delete plan] 삭제할 일정이 없습니다." + planId);
			return 0;
		}
		
		return planDAO.deletePlan(planId, itineraryId);
	}
	
	// planPrice
	public int generatePlanPrice(int itineraryId) {
		
		List<Plan> planList = getPlanListByItineraryId(itineraryId);
		
		int planPrice = 0;
		for (int i = 0; i < planList.size(); i++) {
			
			planPrice = planPrice + planList.get(i).getPrice();
		}
		
		return planPrice;
	}
	
}
