package com.travelplans.my_travel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my_travel")
public class MytravelController {
	
	/**
	 * 교통수단 화면
	 * @param model
	 * @return
	 */
	@RequestMapping("/reservation_traffic_view")
	public String trafficView(Model model) {
		
		model.addAttribute("reservationViewname", "traffic");
		return "my_travel_reservation/template/layout";
		
	}
	
	/**
	 * 숙소 화면
	 * @param model
	 * @return
	 */
	@RequestMapping("/reservation_accommodation_view") 
	public String accommodationView(Model model) {
		
		model.addAttribute("reservationViewname", "accommodation");
		
		return "my_travel_reservation/template/layout";
	}
	
	/**
	 * 에약정보 화면
	 * @param model
	 * @return
	 */
		@RequestMapping("/reservation_reservation_view") 
		public String reservationView(Model model) {
			
			model.addAttribute("reservationViewname", "reservation");
			
			return "my_travel_reservation/template/layout";
		}
		
		
		/**
		 * 스케줄-예약정보 화면
		 * @param model
		 * @return
		 */
		@RequestMapping("/schedule_reservationInfo_view")
		public String scheduleReservationInfoView(Model model) {
			
			model.addAttribute("scheduleViewName", "reservationInfo");
			
			return "my_travel_schedule/template/layout";
		}
		
		@RequestMapping("/schedule_view")
		public String scheduleView(Model model) {
			
			model.addAttribute("scheduleViewName", "schedule");
			
			return "my_travel_schedule/template/layout";
		}
		
		
}
