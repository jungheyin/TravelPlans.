package com.travelplans.my_travel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelplans.my_travel.bo.MytravelBO;
import com.travelplans.my_travel.model.Trip;

@Controller
@RequestMapping("/my_travel")
public class MytravelController {
	
	@Autowired
	public MytravelBO mytravelBO;
	
	/**
	 * 새로운 여행계획 이름 짓기 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/new_travel_view")
	public String newPlanView(Model model) {

		model.addAttribute("travelNameViewName", "travelName");
		return "my_travel/template/layout";
	}

	/**
	 * 교통수단 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/reservation_traffic_view")
	public String trafficView(Model model) {
		
		// getLastTrip
		Trip trip = mytravelBO.getLastTrip();
		
		model.addAttribute("trip", trip);
		model.addAttribute("reservationViewname", "traffic");
		
		return "my_travel_reservation/template/layout";

	}

	/**
	 * 숙소 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/reservation_accommodation_view")
	public String accommodationView(Model model) {
		
		Trip trip = mytravelBO.getLastTrip();
		
		model.addAttribute("trip", trip);
		model.addAttribute("reservationViewname", "accommodation");

		return "my_travel_reservation/template/layout";
	}

	/**
	 * 에약정보 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/reservation_reservation_view")
	public String reservationView(Model model) {
		
		Trip trip = mytravelBO.getLastTrip();
		
		model.addAttribute("trip", trip);
		model.addAttribute("reservationViewname", "reservation");

		return "my_travel_reservation/template/layout";
	}

	/**
	 * 스케줄-예약정보 화면
	 * 
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