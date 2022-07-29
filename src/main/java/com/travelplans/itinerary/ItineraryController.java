package com.travelplans.itinerary;

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
import com.travelplans.plan.bo.PlanBO;
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
	
	@Autowired
	private DateListBO dateListBO;
	
	@Autowired
	private PlanBO planBO;
	

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
		
		int tafficPrice = reservationBO.generateTrafficPrice(travelId);
		int accommodationPrice = reservationBO.generateAccommodationPrice(travelId);
		int reservationPrice = reservationBO.generateReservationPrice(travelId);
		int itineraryPrice = itineraryBO.generateItineraryPrice(travelId);
		
		model.addAttribute("itineraryPrice", itineraryPrice);
		model.addAttribute("tafficPrice", tafficPrice);
		model.addAttribute("accommodationPrice", accommodationPrice);
		model.addAttribute("reservationPrice", reservationPrice);
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
		int tafficPrice = reservationBO.generateTrafficPrice(travelId);
		int accommodationPrice = reservationBO.generateAccommodationPrice(travelId);
		int reservationPrice = reservationBO.generateReservationPrice(travelId);
		int itineraryPrice = itineraryBO.generateItineraryPrice(travelId);
		
		model.addAttribute("itineraryPrice", itineraryPrice);
		model.addAttribute("tafficPrice", tafficPrice);
		model.addAttribute("accommodationPrice", accommodationPrice);
		model.addAttribute("reservationPrice", reservationPrice);
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
		int tafficPrice = reservationBO.generateTrafficPrice(travelId);
		int accommodationPrice = reservationBO.generateAccommodationPrice(travelId);
		int reservationPrice = reservationBO.generateReservationPrice(travelId);
		int itineraryPrice = itineraryBO.generateItineraryPrice(travelId);
		
		model.addAttribute("itineraryPrice", itineraryPrice);
		model.addAttribute("tafficPrice", tafficPrice);
		model.addAttribute("accommodationPrice", accommodationPrice);
		model.addAttribute("reservationPrice", reservationPrice);
		model.addAttribute("travel", travel);
		model.addAttribute("reservation", reservation);
		model.addAttribute("reservationList", reservationList);
		model.addAttribute("itineraryViewName", "reservationInfo");
		
		return "itinerary/template/layout";
	}
	

	@RequestMapping("/date_list_view")
	public String createView(
			@RequestParam("travelId") int travelId,
			Model model) {
		
		Travel travel = reservationBO.getTravelById(travelId);
		List<DateListView> dateListView = dateListBO.generateDateListViewList(travelId);
		int tafficPrice = reservationBO.generateTrafficPrice(travelId);
		int accommodationPrice = reservationBO.generateAccommodationPrice(travelId);
		int reservationPrice = reservationBO.generateReservationPrice(travelId);
		int itineraryPrice = itineraryBO.generateItineraryPrice(travelId);
		
		model.addAttribute("itineraryPrice", itineraryPrice);
		model.addAttribute("tafficPrice", tafficPrice);
		model.addAttribute("accommodationPrice", accommodationPrice);
		model.addAttribute("reservationPrice", reservationPrice);
		model.addAttribute("dateListView", dateListView);
		model.addAttribute("travel", travel);
		model.addAttribute("itineraryViewName", "itinerary");

		return "itinerary/template/layout";
	}
	

}















