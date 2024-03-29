package com.travelplans.plan.bo;

import java.util.Collections;
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
	
	public void addPlan(int travelId, int itineraryId, String date, String planName, String time,
			String location, String memo, int price) {
		
		memo = memo.replace("\n", "<br>");
		
		planDAO.insertPlan(travelId, itineraryId, date, planName, time, location, memo, price);
	}
	
	public List<Plan> getPlanListByItineraryId (int itineraryId) {
		
		return planDAO.selectPlanListByItineraryId(itineraryId);
	}
	
	public List<Plan> getPlanListByTravelId (int travelId) {
		
		return planDAO.selectPlanListByTravelId(travelId);
	}
	
	public List<Plan> getPlanListByTravelIdItineraryId(int travelId, int itineraryId) {
		
		return planDAO.selectPlanListByTravelIdItineraryId(travelId, itineraryId);
	}
	
	public Plan getPlanByPlanId (int planId) {
		
		return planDAO.selectPlanByPlanId(planId);
	}	
	
	public int updatePlan(int planId, int travelId, int itineraryId, String date, String planName, String time,
			String location, String memo, int price) {
		
		memo = memo.replace("\n", "<br>");
		
		Plan plan = getPlanByPlanId(planId);
		
		if (plan == null) {
			logger.error("[update / Plan] planBO plan null planId: " + planId);
			return 0;
		}
		return planDAO.updatePlan(planId, travelId, itineraryId, date, planName, time, location, memo, price);
	}
	
	public int deletePlan(int planId) {
		
		Plan plan = getPlanByPlanId(planId);
		
		if (plan == null) {
			logger.error("[delete / plan] planBO plan null planId: " + planId);
			return 0;
		}
		
		return planDAO.deletePlan(planId);
	}
	
	public int deletePlanByItineraryId (int itineraryId) {
		
		List<Plan> planList = getPlanListByItineraryId(itineraryId);
		
		if (planList.size() < 0) {
			logger.error("[delete_plan_itineraryid / plan ] planBO planList.size() < 0 itineraryId " + itineraryId);
			return 0;
		}
		
		return planDAO.deletePlanByItineraryId(itineraryId);
	}
	
	public void deletePlanByTravelId (int travelId) {
		
		List<Plan> planList = getPlanListByTravelId(travelId);
		
		if (planList.size() < 0 ) {
			logger.error("[delete_plan_itineraryid / plan ] planBO planList.size() < 0 travelId " + travelId);

		}
		
		planDAO.deletePlanByTravelId(travelId);
		
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
