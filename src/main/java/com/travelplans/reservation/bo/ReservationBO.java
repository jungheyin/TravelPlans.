package com.travelplans.reservation.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.new_travel.model.Travel;
import com.travelplans.reservation.dao.ReservationDAO;
import com.travelplans.reservation.model.Accommodation;
import com.travelplans.reservation.model.Reservation;
import com.travelplans.reservation.model.Traffic;

@Service
public class ReservationBO {

	@Autowired
	private ReservationDAO reservationDAO;
	
	public void addTraffic(int travelId, String traffic, String trafficInfo, String start, String startDate, 
			String startTime, String arrive, String arriveDate, String arriveTime, Integer price,
			String memo) {
		
		reservationDAO.insertTraffic(travelId, traffic, trafficInfo, start, startDate, startTime, arrive, arriveDate, arriveTime, price, memo);
	}
	
	public void addAccommodation(int travelId, String name, String startDate, String endDate, String location, Integer price, String memo) {
		reservationDAO.insertAccommodation(travelId, name, startDate, endDate, location, price, memo);
	}
	
	public void addReservation(int travelId, String title, String booker, String date, String location, Integer price, String memo) {
		reservationDAO.insertReservation(travelId, title, booker, date, location, price, memo);
	}
	
	public Travel getLastTravel() {
		return reservationDAO.selectLastTravel();
	}

	public List<Traffic> getTrafficList(int travelId) {
	  
		List<Traffic> trafficList = reservationDAO.selectTrafficList(travelId);
		
	  return trafficList; 
	}
	 
	public List<Accommodation> getAccommodationList(int travelId) {
		
		List<Accommodation> accommodationList = reservationDAO.selectAccommodationList(travelId);
		
		return accommodationList; 
	}
	
	public List<Reservation> getReservationList(int travelId) {
		
		List<Reservation> reservationList = reservationDAO.selectReservationList(travelId);
		
		return reservationList;
	}
}
