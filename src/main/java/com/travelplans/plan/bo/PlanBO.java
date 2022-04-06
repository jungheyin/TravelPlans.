package com.travelplans.plan.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.plan.dao.PlanDAO;

@Service
public class PlanBO {
	
	@Autowired
	private PlanDAO planDAO;
	
	/*
	public void addPlan(int travelId, String date, String placeName, String time,
			String location, String memo, Integer price, Integer testTime, String traffic,
			String file) {
		
		planDAO
	}
	*/
}
