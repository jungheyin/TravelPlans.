package com.travelplans.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelplans.new_travel.model.Travel;
import com.travelplans.reservation.bo.ReservationBO;
import com.travelplans.reservation.model.Accommodation;
import com.travelplans.reservation.model.Reservation;
import com.travelplans.reservation.model.Traffic;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	private ReservationBO reservationBO;

	/**
	 * 교통수단 저장 화면
	 * @param model
	 * @return
	 */
	@RequestMapping("/traffic_create_view")
	public String trafficView(Model model) {
		
		Travel travel = reservationBO.getLastTravel();
		
		model.addAttribute("travel", travel);
		model.addAttribute("reservationSubject", "traffic");
		model.addAttribute("reservationViewName", "traffic");
		
		return "reservation/template/layout";

	}
	/**
	 * 숙소 저장 화면
	 * @param model
	 * @return
	 */
	@RequestMapping("/accommodation_create_view")
	public String accommodationView(Model model) {
		
		Travel travel = reservationBO.getLastTravel();
		
		model.addAttribute("travel", travel);
		model.addAttribute("reservationSubject", "accommodation");
		model.addAttribute("reservationViewName", "accommodation");

		return "reservation/template/layout";
	}
	/**
	 * 예약정보 화면
	 * @param model
	 * @return
	 */
	@RequestMapping("/reservation_create_view")
	public String reservationView(Model model) {
		
		Travel travel = reservationBO.getLastTravel();
		
		model.addAttribute("travel", travel);
		model.addAttribute("reservationSubject", "reservation");
		model.addAttribute("reservationViewName", "reservation");

		return "reservation/template/layout";
	}
	
	/**
	 * 교통수단 수정 화면
	 * @param travelId
	 * @param trafficId
	 * @param model
	 * @return
	 */
	@RequestMapping("/traffic_update_view")
	public String trafficUpdateView(
			@RequestParam("travelId") int travelId,
			@RequestParam("trafficId") int trafficId,
			Model model) {
		
		
		Travel travel = reservationBO.getTravelById(travelId);
		Traffic traffic = reservationBO.getTrafficById(trafficId);
		
		model.addAttribute("traffic", traffic);
		model.addAttribute("travel", travel);
		model.addAttribute("reservationSubject", "traffic");
		model.addAttribute("reservationUpdateViewName", "traffic_update");
		return "reservation/template/layout_update";
	}
	/**
	 * 숙소 수정 화면
	 * @param travelId
	 * @param accommodationId
	 * @param model
	 * @return
	 */
	@RequestMapping("/accommodation_update_view")
	public String accommodationUpdateView(
			@RequestParam("travelId") int travelId,
			@RequestParam("accommodationId") int accommodationId,
		Model model) {
		
		Travel travel = reservationBO.getTravelById(travelId);
		Accommodation accommodation = reservationBO.getAccommodationById(accommodationId);
		
		model.addAttribute("accommodation", accommodation);
		model.addAttribute("travel", travel);
		model.addAttribute("reservationSubject", "accommodation");
		model.addAttribute("reservationUpdateViewName", "accommodation_update");
		return "reservation/template/layout_update";
	}
	
	
	// 예약정보 수정
	
	@RequestMapping("/reservation_update_view")
	public String reservationUpdateView(
			@RequestParam("travelId") int travelId,
			@RequestParam("reservationId") int reservationId,
		Model model) {
		
		Travel travel = reservationBO.getTravelById(travelId);
		Reservation reservation = reservationBO.getReservationById(reservationId);
		
		model.addAttribute("reservation", reservation);
		model.addAttribute("travel", travel);
		model.addAttribute("reservationSubject", "reservation");
		model.addAttribute("reservationUpdateViewName", "reservation_update");
		return "reservation/template/layout_update";
	}
	
}
