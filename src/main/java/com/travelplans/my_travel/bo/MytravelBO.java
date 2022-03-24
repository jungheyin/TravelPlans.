package com.travelplans.my_travel.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.my_travel.dao.MytravelDAO;
import com.travelplans.my_travel.model.Trip;

@Service
public class MytravelBO {

	@Autowired
	private MytravelDAO mytravelDAO;

	public void addTrip(int userId, String title, String color, String startDate, String endDate) {
		mytravelDAO.insertTrip(userId, title, color, startDate, endDate);
	}
	
	public void addTraffic(int tripId, String traffic, String trafficInfo, String start, String startDate, 
			String startTime, String arrive, String arriveDate, String arriveTime, Integer price,
			String memo) {
		
		mytravelDAO.insertTraffic(tripId, traffic, trafficInfo, start, startDate, startTime, arrive, arriveDate, arriveTime, price, memo);
	}
	
	public void addAccommodation(int tripId, String name, String date, String location, Integer price, String memo) {
		mytravelDAO.insertAccommodation(tripId, name, date, location, price, memo);
	}
	
	public void addReservation(int tripId, String title, String booker, String date, String location, Integer price, String memo) {
		mytravelDAO.insertReservation(tripId, title, booker, date, location, price, memo);
	}
	public Trip getLastTrip() {
		return mytravelDAO.selectLastTrip();
	}
	

}
