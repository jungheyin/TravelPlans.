package com.travelplans.reservation.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.new_travel.model.Travel;
import com.travelplans.reservation.dao.ReservationDAO;
import com.travelplans.reservation.model.Accommodation;
import com.travelplans.reservation.model.Reservation;
import com.travelplans.reservation.model.Traffic;

@Service
public class ReservationBO {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
	
	public Travel getTravelById(int id) {
		return reservationDAO.selectTravelById(id);
	}
	
	public Traffic getTrafficById(int trafficId) {
		return reservationDAO.selectTrafficById(trafficId);
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
	
	public int updateTraffic(int trafficId, int travelId, String traffic, String trafficInfo, 
			String start, String startDate, String startTime, String arrive, String arriveDate, String arriveTime, 
			Integer price, String memo) {
		
		Traffic trafficById = getTrafficById(trafficId);
		
		if (trafficById == null) {
			logger.error("[update traffic] 수정할 교통수단 정보가 없습니다. {},{}" + trafficById.getId(), trafficById.getTravelId() );
			return 0;
		}
		
		return reservationDAO.updateTrafficByIdTravelId(trafficId, travelId, traffic, trafficInfo, 
				start, startDate, startTime, arrive, arriveDate, arriveTime, price, memo);
		
	}
	
	// update- accommodation
	
	// update- reservation
	
	// delete - traffic
	public int deleteTraffic (int trafficid, int travelId) {

		// 1. traffic을 가져온다. travelId로
		Traffic traffic = getTrafficById(trafficid);
		// 있는지 확인한다.
		if (traffic == null) {
			logger.error("[delete traffic] 삭제할 교통수단 정보가 없습니다. {},{}" + traffic.getId(), traffic.getTravelId());
			return 0;
		}
		// 삭제 후 return 해준다.
		
		return reservationDAO.deleteTrafficByIdTravelId(trafficid, travelId);
	}
	
	
	// delete - accommodation
	
	// delete - reservation
	
}
