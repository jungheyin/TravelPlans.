package com.travelplans.new_travel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelplans.new_travel.bo.NewTravelBO;
import com.travelplans.new_travel.model.Travel;

@Controller
@RequestMapping("/new_travel")
public class NewTravelController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private NewTravelBO newTravelBO;
	
	/**
	 * 새로운 여행계획 저장 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/create_view")
	public String createTravel(Model model) {
		
		model.addAttribute("newTravelViewName", "create");
		
		return "new_travel/template/layout";
	}

	/**
	 * 새로운 여행계획 수정 화면
	 * @param travelId
	 * @param model
	 * @return
	 */
	@RequestMapping("/update_view")
	public String updateTravel(
			@RequestParam("travelId") int travelId,
			Model model) {
		
		Travel travel = newTravelBO.getTravelById(travelId);
		if (travel == null) {
			logger.error("[new_tarvel/update_view] travel 정보없음" + travel.getId());
		}
		
		model.addAttribute("travel", travel);
		model.addAttribute("newTravelViewName", "update");
		
		return "new_travel/template/layout";
	}
	

	
}
