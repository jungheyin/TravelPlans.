package com.travelplans.itinerary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/itinerary")
public class ItineraryController {
	
		// TODO: 스케줄 부분
		// 1. schedule 부분 페이지 나누기: traffic, accommodation, reservation부분
		// 2. 공통: list를 만들어서 뿌려준다.
		// 3. model.addAttribute로 view 뿌려주기!!!
		
		
		
		
	
	// 스케줄:예약정보-교통수단
	// /itinerary/traffic_info_view
	@RequestMapping("/traffic_info_view")
	public String trafficInfoView(Model model) {
		
		// traffic select
		
		// model에 넣기

		model.addAttribute("itineraryViewName", "trafficInfo");

		return "itinerary/template/layout";
	}
	
	// 스케줄:예약정보-숙소
	// /itinerary/accommodation_info_view
	@RequestMapping("/accommodation_info_view")
	public String accommodationInfoView(Model model) {
		
		
		model.addAttribute("itineraryViewName", "accommodationInfo");
		
		return "itinerary/template/layout";
	}
	
	// 스케줄:예약정보-예약정보
	// /itinerary/reservaion_info_view
	@RequestMapping("/reservation_info_view")
	public String reservationInfoView(Model model) {
		
		
		model.addAttribute("itineraryViewName", "reservationInfo");
		
		return "itinerary/template/layout";
	}
	
	// 여행계획 만드는 페이지
	@RequestMapping("/itinerary_create_view")
	public String scheduleView(Model model) {
		
		// trip id를 가져온다.
		
		model.addAttribute("itineraryViewName", "itinerary");

		return "itinerary/template/layout";
	}
}
