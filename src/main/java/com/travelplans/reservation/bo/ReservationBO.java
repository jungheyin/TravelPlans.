package com.travelplans.reservation.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.new_travel.model.Travel;
import com.travelplans.reservation.dao.ReservationDAO;

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
	

	
}
