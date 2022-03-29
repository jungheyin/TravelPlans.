package com.travelplans.itinerary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelplans.reservation.bo.ReservationBO;
import com.travelplans.reservation.model.Accommodation;
import com.travelplans.reservation.model.Reservation;
import com.travelplans.reservation.model.Traffic;

@Controller
@RequestMapping("/itinerary")
public class ItineraryController {
	
		// TODO: 스케줄 부분
		// 2. 공통: list를 만들어서 뿌려준다.
		// 3. model.addAttribute로 view 뿌려주기!!!
		
		
	@Autowired
	private ReservationBO reservationBO;
	
	// 스케줄:예약정보-교통수단
	// /itinerary/traffic_info_view
	@RequestMapping("/traffic_info_view")
	public String trafficInfoView(
			@RequestParam("travelId") int travelId,
			Model model) {
		
		List<Traffic> trafficList = reservationBO.getTrafficList(travelId);
		
		model.addAttribute("trafficList", trafficList);
		model.addAttribute("itineraryViewName", "trafficInfo");

		return "itinerary/template/layout";
	}
	
	// 스케줄:예약정보-숙소
	// /itinerary/accommodation_info_view
	@RequestMapping("/accommodation_info_view")
	public String accommodationInfoView(
			@RequestParam("travelId") int travelId,
			Model model) {
		
		List<Accommodation> accommodationList = reservationBO.getAccommodationList(travelId);
		
		model.addAttribute("accommodationList", accommodationList);
		model.addAttribute("itineraryViewName", "accommodationInfo");
		
		return "itinerary/template/layout";
	}
	
	// 스케줄:예약정보-예약정보
	// /itinerary/reservaion_info_view
	@RequestMapping("/reservation_info_view")
	public String reservationInfoView(
			@RequestParam("travelId") int travelId,
			Model model) {
		
		List<Reservation> reservationList = reservationBO.getReservationList(travelId);
		
		model.addAttribute("reservationList", reservationList);
		model.addAttribute("itineraryViewName", "reservationInfo");
		
		return "itinerary/template/layout";
	}
	
	// 여행계획 만드는 페이지
	@RequestMapping("/create_view")
	public String itinerary(
			@RequestParam("travelId") int travelId,
			Model model) {
		
		
		model.addAttribute("itineraryViewName", "itinerary");

		return "itinerary/template/layout";
	}
}
