package com.travelplans.plan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelplans.itinerary.bo.DateListBO;
import com.travelplans.itinerary.bo.ItineraryBO;
import com.travelplans.itinerary.model.DateListView;
import com.travelplans.plan.bo.PlanBO;
import com.travelplans.plan.model.Plan;
import com.travelplans.reservation.bo.ReservationBO;
import com.travelplans.travel.bo.TravelBO;
import com.travelplans.travel.model.Travel;

@Controller
@RequestMapping("/plan")
public class PlanController {
	
	@Autowired
	private TravelBO travelBO;
	
	@Autowired
	private ItineraryBO itineraryBO;
	
	@Autowired
	private ReservationBO reservationBO;
	
	@Autowired
	private DateListBO dateListBO;
	
	@Autowired
	private PlanBO planBO;
	
	@RequestMapping("/create_view")
	public String createView(
			@RequestParam("travelId") int travelId,
			@RequestParam("itineraryId") int itineraryId,
			@RequestParam("date") String date,
			Model model) {
		
		Travel travel = travelBO.getTravelByTravelId(travelId);
		List<DateListView> dateListView = dateListBO.generateDateListViewList(travelId);
		List<Plan> planList = planBO.getPlanListByItineraryId(itineraryId);
		
		model.addAttribute("dateListView", dateListView);
		model.addAttribute("planList", planList);
		model.addAttribute("itineraryId", itineraryId);
		model.addAttribute("date", date);
		model.addAttribute("travel", travel);
		model.addAttribute("planViewName", "create");
		
		return "plan/template/layout";
	}
	
	@RequestMapping("/update_view")
	public String updateView(
			@RequestParam("travelId") int travelId,
			@RequestParam("itineraryId") int itineraryId,
			@RequestParam("date") String date,
			@RequestParam("planId") int planId,
			Model model) {
		
		Travel travel = travelBO.getTravelByTravelId(travelId);
		List<DateListView> dateListView = dateListBO.generateDateListViewList(travelId);
		List<Plan> planList = planBO.getPlanListByItineraryId(itineraryId);
		Plan plan = planBO.getPlanByPlanId(planId);
		
		model.addAttribute("dateListView", dateListView);
		model.addAttribute("plan", plan);
		model.addAttribute("planList", planList);
		model.addAttribute("itineraryId", itineraryId);
		model.addAttribute("date", date);
		model.addAttribute("travel", travel);
		model.addAttribute("planViewName", "update");
				
		
		return "plan/template/layout";
	}

}
