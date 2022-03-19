package com.travelplans.my_travel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my_travel")
public class mytravelController {
	
	// 교통수단
	@RequestMapping("/reservation_traffic_view")
	public String trafficView(Model model) {
		
		model.addAttribute("reservationViewname", "traffic");
		return "my_travel/template/layout";
		
	}
	
	// 숙소
	@RequestMapping("/reservation_accommodation_view") 
	public String accommodationView(Model model) {
		
		model.addAttribute("reservationViewname", "accommodation");
		
		return "my_travel/template/layout";
	}
	
	// 예약정보
		@RequestMapping("/reservation_reservation_view") 
		public String reservationView(Model model) {
			
			model.addAttribute("reservationViewname", "reservation");
			
			return "my_travel/template/layout";
		}
}
