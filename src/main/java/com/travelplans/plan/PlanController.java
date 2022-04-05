package com.travelplans.plan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelplans.itinerary.bo.ItineraryBO;
import com.travelplans.new_travel.bo.NewTravelBO;
import com.travelplans.new_travel.model.Travel;

@Controller
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	private ItineraryBO itineraryBO;
	
	@Autowired
	private NewTravelBO newTravelBO;
	
	@RequestMapping("/create_view")
	public String create(
			@RequestParam("travelId") int travelId,
			@RequestParam("date") String date,
			Model model) {
		
		List<String> travelDateList = itineraryBO.generateTravelDateListById(travelId);
		Travel travel = newTravelBO.getTravelById(travelId);
		
		model.addAttribute("travel", travel);
		model.addAttribute("travelDateList", travelDateList);
		model.addAttribute("date", date);
		model.addAttribute("planViewName", "create");
		return "plan/template/layout";
	}
	
	@RequestMapping("/update_view")
	public String update(
			@RequestParam("travelId") int travelId,
			@RequestParam("date") String date,
			Model model) {
		
		model.addAttribute("planViewName", "update");
		return "plan/template/layout";
	}
}
