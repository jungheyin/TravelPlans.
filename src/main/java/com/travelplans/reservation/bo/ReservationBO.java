package com.travelplans.reservation.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.reservation.dao.ReservationDAO;
import com.travelplans.reservation.model.Accommodation;
import com.travelplans.reservation.model.Reservation;
import com.travelplans.reservation.model.Traffic;
import com.travelplans.travel.model.Travel;

@Service
public class ReservationBO {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ReservationDAO reservationDAO;
	
	public void addTraffic(int travelId, String traffic, String trafficInfo, String start, String startDate, 
			String startTime, String arrive, String arriveDate, String arriveTime, Integer price,
			String memo) {
		
		memo = memo.replace("\n", "<br>");
		
		reservationDAO.insertTraffic(travelId, traffic, trafficInfo, start, startDate, startTime, arrive, arriveDate, arriveTime, price, memo);
	}
	
	public void addAccommodation(int travelId, String name, String startDate, String endDate, String location, Integer price, String memo) {
		
		memo = memo.replace("\n", "<br>");
		
		reservationDAO.insertAccommodation(travelId, name, startDate, endDate, location, price, memo);
	}
	
	public void addReservation(int travelId, String title, String booker, String date, String location, Integer price, String memo) {
		
		memo = memo.replace("\n", "<br>");
		
		reservationDAO.insertReservation(travelId, title, booker, date, location, price, memo);
	}
	
	public Traffic getTrafficById(int trafficId) {
		return reservationDAO.selectTrafficById(trafficId);
	}
	
	public Accommodation getAccommodationById(int accommodationId) {
		return reservationDAO.selectAccommodationById(accommodationId);
	}
	
	public Reservation getReservationById(int reservationId) {
		return reservationDAO.selectReservationById(reservationId);
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
			logger.error("[update_traffic / reservation] reservationBO trafficById null trafficId: " + trafficId + "travelId: " +  travelId );
			return 0;
		}
		
		return reservationDAO.updateTrafficByIdTravelId(trafficId, travelId, traffic, trafficInfo, 
				start, startDate, startTime, arrive, arriveDate, arriveTime, price, memo);
		
	}
	
	public int updateAccommodation(int accommodationId, int travelId, String name, String startDate, String endDate, String location, Integer price, String memo) {
		
		Accommodation accommodationById = getAccommodationById(accommodationId);
		
		if (accommodationById == null) {
			logger.error("[update_accommodation / reservation] reservationBO accommodationById null accommodationId: " + accommodationId + "travelId: " +  travelId);
			return 0;
		}
		
		return reservationDAO.updateAccommodation(accommodationId, travelId, name, startDate, endDate, location, price, memo);
	}
	
	public int updateReservation(int reservationId,int travelId, String title, String booker, String date, String location, Integer price, String memo) {
		
		Reservation reservationById = getReservationById(reservationId);
		
		if (reservationById == null) {
			logger.error("[update_reservation / reservation] reservationBO reservationById null reservationId: " + reservationId + "travelId: " +  travelId);
			return 0;
		}
		
		return reservationDAO.updateReservation(reservationId, travelId, title, booker, date, location, price, memo);
	}
	
	
	public int deleteTrafficByTrafficIdTravelId(int trafficId, int travelId) {

		Traffic trafficById = getTrafficById(trafficId);
		
		if (trafficById == null) {
			logger.error("[delete_traffic / reservation] reservationBO trafficById null trafficId: " + trafficById.getId() + "travelId: " + trafficById.getTravelId());
			return 0;
		}
		
		return reservationDAO.deleteTrafficByTrafficIdTravelId(trafficId, travelId);
	}
	
	public void deleteTrafficByTravelId(int travelId) {
		
		List<Traffic> trafficList = getTrafficList(travelId);
		
		if (trafficList.size() < 0) {
			logger.error("[delete_traffic / reservation] reservationBO trafficList.size() < 0 travelId: " + travelId);
		}
		
		reservationDAO.deleteTrafficByTravelId(travelId);
	}
	
	public int deleteAccommodationByAccommodationIdTravelId(int accommodationId, int travelId) {
		
		Accommodation accommodationById = getAccommodationById(accommodationId);
		
		if (accommodationById == null) {
			logger.error("[delete_accommodation / reservation] reservationBO accommodationById null accommodationId: " + accommodationId + "travelId: " + travelId);
			return 0;
		}
		
		return reservationDAO.deleteAccommodationByAccommodationIdTravelId(accommodationId, travelId);
	}
	
	public void deleteAccommodationByTravelId(int travelId) {
		
		List<Accommodation> accommodationList = getAccommodationList(travelId);
		
		if (accommodationList.size() < 0) {
			logger.error("[delete/accommodation / reservation] reservationBO accommodationList.size() < 0 travelId: " + travelId);
			
		}
		
		reservationDAO.deleteAccommodationByTravelId(travelId);
	}
	
	public int deleteReservationByReservationIdTravelId(int reservationId, int travelId) {
		
		Reservation reservationById = getReservationById(reservationId);
		
		if (reservationById == null) {
			logger.error("[delete_reservation / reservation] reservationBO reservationById null reservationId: " + reservationId + "travelId: " + travelId);
			return 0;
		}
		
		return reservationDAO.deleteReservationByReservationIdTravelId(reservationId, travelId);
	}
	
	public void deleteReservationByTravelId(int travelId) {
		
		List<Reservation> reservationList = getReservationList(travelId);
		
		if (reservationList.size() < 0) {
			logger.error("[delete/reservation] reservationBO reservationList.size() < 0 travelId: " + travelId);
			
		}
		
		reservationDAO.deleteReservationByTravelId(travelId);
	}
	public Map<String, String> generateTrafficSelectMap() {
		
		Map<String, String> traffcSelectMap = new HashMap<>();
		
		traffcSelectMap.put("airplans", "비행기");
		traffcSelectMap.put("train", "기차");
		traffcSelectMap.put("expressBus", "고속버스");
		traffcSelectMap.put("direct", "직접입력");
		
		return traffcSelectMap;
	}
	
	// traffic 총 경비
	public int generateTrafficPrice(int travelId) {
				
		List<Traffic> trafficList = getTrafficList(travelId);
				
		int trafficPrice = 0;	
		for (int i = 0; i < trafficList.size(); i++) {
					
			trafficPrice = trafficPrice + trafficList.get(i).getPrice();
				
		}
				
		return trafficPrice;
				
	}
		
	// accommodation 총 경비
	public int generateAccommodationPrice(int travelId) {
				
		List<Accommodation> accommodationList = getAccommodationList(travelId);
				
		int accommodationPrice = 0;
		for (int i = 0; i < accommodationList.size(); i++) {
					
			accommodationPrice = accommodationPrice + accommodationList.get(i).getPrice();
					
		}
				
		return accommodationPrice;
	}
			
	// reservation 총 비용
	public int generateReservationPrice(int travelId) {
			
		List<Reservation> reservationList = getReservationList(travelId);
			
		int reservationPrice = 0;
		for (int i = 0; i < reservationList.size(); i++) {
					
			reservationPrice = reservationPrice + reservationList.get(i).getPrice();
				
		}
				
		return reservationPrice;
	}
	
	
	
	
}
