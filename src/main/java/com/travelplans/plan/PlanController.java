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
import com.travelplans.new_travel.model.Travel;
import com.travelplans.reservation.bo.ReservationBO;

@Controller
@RequestMapping("/plan")
public class PlanController {
	
	@Autowired
	private ItineraryBO itineraryBO;
	
	@Autowired
	private ReservationBO reservationBO;
	
	@Autowired
	private DateListBO dateListBO;
	
	@RequestMapping("/create_view")
	public String createView(
			@RequestParam("travelId") int travelId,
			@RequestParam("itineraryId") int itineraryId,
			@RequestParam("date") String date,
			Model model) {
		
		Travel travel = reservationBO.getTravelById(travelId);
		List<DateListView> dateListView = dateListBO.generateDateListViewList(travelId);
		
		
		model.addAttribute("itineraryId", itineraryId);
		model.addAttribute("date", date);
		model.addAttribute("travel", travel);
		model.addAttribute("dateListView", dateListView);
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
		
		Travel travel = reservationBO.getTravelById(travelId);
		List<DateListView> dateListView = dateListBO.generateDateListViewList(travelId);
		
		
		model.addAttribute("itineraryId", itineraryId);
		model.addAttribute("date", date);
		model.addAttribute("travel", travel);
		model.addAttribute("dateListView", dateListView);
		model.addAttribute("planViewName", "update");
				
		
		return "plan/template/layout";
	}

}
