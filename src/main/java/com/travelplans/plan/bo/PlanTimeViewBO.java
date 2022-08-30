package com.travelplans.plan.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.plan.model.Plan;
import com.travelplans.plan.model.PlanTimeView;
import com.travelplans.plan.model.Time;

@Service
public class PlanTimeViewBO {
	
	@Autowired
	private PlanBO planBO;
	
	@Autowired
	private TimeBO timeBO;
	
	public List<PlanTimeView> generatePlanTimeView(int travelId , int itineraryId) {
		
		List<PlanTimeView> planTimeView = new ArrayList<>();
		
		List<Plan> planList = planBO.getPlanListByTravelIdItineraryId(travelId, itineraryId);
		
		for (Plan plan : planList) {
			PlanTimeView content = new PlanTimeView();
			
			// plan
			content.setPlan(plan);
			
			// time
			int planId = plan.getId();
			Time time = timeBO.getTimeByTravelIdItineraryIdPlanId(travelId, itineraryId, planId);
			content.setTime(time);
			
			planTimeView.add(content);
			
		}
		
		return planTimeView;
	}

}
