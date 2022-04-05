package com.travelplans.itinerary;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelplans.itinerary.bo.ItineraryBO;
import com.travelplans.itinerary.model.Itinerary;
import com.travelplans.new_travel.model.Travel;
import com.travelplans.reservation.bo.ReservationBO;
import com.travelplans.reservation.model.Accommodation;
import com.travelplans.reservation.model.Reservation;
import com.travelplans.reservation.model.Traffic;

@Controller
@RequestMapping("/itinerary")
public class ItineraryController {
	
		
	@Autowired
	private ReservationBO reservationBO;
	
	@Autowired
	private ItineraryBO itineraryBO;
	
	/**
	 * 교통수단 정보 화면
	 * @param travelId
	 * @param model
	 * @return
	 */
	@RequestMapping("/traffic_info_view")
	public String trafficInfoView(
			@RequestParam("travelId") int travelId,
			Model model) {
		
		Travel travel = reservationBO.getTravelById(travelId);
		List<Traffic> trafficList = reservationBO.getTrafficList(travelId);
		
		Traffic traffic = reservationBO.getTrafficById(travelId);
		
		model.addAttribute("traffic", traffic);
		model.addAttribute("travel", travel);
		model.addAttribute("trafficList", trafficList);
		model.addAttribute("itineraryViewName", "trafficInfo");

		return "itinerary/template/layout";
	}
	
	/**
	 * 숙소 정보 화면
	 * @param travelId
	 * @param model
	 * @return
	 */
	@RequestMapping("/accommodation_info_view")
	public String accommodationInfoView(
			@RequestParam("travelId") int travelId,
			Model model) {
		
		Travel travel = reservationBO.getTravelById(travelId);
		List<Accommodation> accommodationList = reservationBO.getAccommodationList(travelId);
		
		Accommodation accommodation = reservationBO.getAccommodationById(travelId);
		
		model.addAttribute("travel", travel);
		model.addAttribute("accommodation", accommodation);
		model.addAttribute("accommodationList", accommodationList);
		model.addAttribute("itineraryViewName", "accommodationInfo");
		
		return "itinerary/template/layout";
	}
	
	/**
	 * 예약정보 화면
	 * @param travelId
	 * @param model
	 * @return
	 */
	@RequestMapping("/reservation_info_view")
	public String reservationInfoView(
			@RequestParam("travelId") int travelId,
			Model model) {
		
		Travel travel = reservationBO.getTravelById(travelId);
		List<Reservation> reservationList = reservationBO.getReservationList(travelId);
		
		Reservation reservation = reservationBO.getReservationById(travelId);
		
		model.addAttribute("travel", travel);
		model.addAttribute("reservation", reservation);
		model.addAttribute("reservationList", reservationList);
		model.addAttribute("itineraryViewName", "reservationInfo");
		
		return "itinerary/template/layout";
	}
	
	/**
	 * 여행일정 화면
	 * @param travelId
	 * @param model
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/create_view")
	public String createView(
			@RequestParam("travelId") int travelId,
			Model model) throws ParseException {
		
		Travel travel = reservationBO.getTravelById(travelId);
		List<String> travelDateList = itineraryBO.generateTravelDateListById(travelId);
		
		model.addAttribute("travelDateList", travelDateList);
		model.addAttribute("travel", travel);
		model.addAttribute("itineraryViewName", "itinerary");

		return "itinerary/template/layout";
	}
	
}
