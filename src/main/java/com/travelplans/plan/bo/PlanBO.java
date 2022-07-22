package com.travelplans.plan.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.plan.dao.PlanDAO;

@Service
public class PlanBO {
	
	@Autowired
	private PlanDAO planDAO;
	
	public void addPlan (int itineraryId, String date, String planName, String time,
			String location, String memo, int price) {
		
		planDAO.insertPlan(itineraryId, date, planName, time, location, memo, price);
	}
}
