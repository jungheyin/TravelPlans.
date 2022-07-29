package com.travelplans.reservation.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Travel getLastTravel() {
		return reservationDAO.selectLastTravel();
	}
	
	public Travel getTravelById(int id) {
		return reservationDAO.selectTravelById(id);
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
			logger.error("[update traffic] 수정 할 교통수단 정보가 없습니다. {},{}" + trafficId, travelId );
			return 0;
		}
		
		return reservationDAO.updateTrafficByIdTravelId(trafficId, travelId, traffic, trafficInfo, 
				start, startDate, startTime, arrive, arriveDate, arriveTime, price, memo);
		
	}
	
	public int updateAccommodation(int accommodationId, int travelId, String name, String startDate, String endDate, String location, Integer price, String memo) {
		
		Accommodation accommodation = getAccommodationById(accommodationId);
		
		if (accommodation == null) {
			logger.error("[update accommodation] 수정 할 숙소 정보가 없습니다. {},{}" + accommodationId, travelId);
			return 0;
		}
		
		return reservationDAO.updateAccommodation(accommodationId, travelId, name, startDate, endDate, location, price, memo);
	}
	
	public int updateReservation(int reservationId,int travelId, String title, String booker, String date, String location, Integer price, String memo) {
		
		Reservation reservation = getReservationById(reservationId);
		
		if (reservation == null) {
			logger.error("[update reservation] 수정 할 예약 정보가 없습니다. {},{}" + reservationId, travelId);
			return 0;
		}
		
		return reservationDAO.updateReservation(reservationId, travelId, title, booker, date, location, price, memo);
	}
	
	
	public int deleteTraffic (int trafficId, int travelId) {

		Traffic traffic = getTrafficById(trafficId);
		
		if (traffic == null) {
			logger.error("[delete traffic] 삭제할 교통수단 정보가 없습니다. {},{}" + traffic.getId(), traffic.getTravelId());
			return 0;
		}
		
		return reservationDAO.deleteTrafficByIdTravelId(trafficId, travelId);
	}
	
	public int deleteAccommodation(int accommodationId, int travelId) {
		
		Accommodation accommodation = getAccommodationById(accommodationId);
		
		if (accommodation == null) {
			logger.error("[delete accommodation] 삭제할 숙소 정보가 없습니다. {},{}" + accommodationId, travelId);
			return 0;
		}
		
		return reservationDAO.deleteAccommodationByIdTravelId(accommodationId, travelId);
	}
	
	public int deleteReservation(int reservationId, int travelId) {
		
		Reservation reservation = getReservationById(reservationId);
		
		if (reservation == null) {
			logger.error("[delete reservation] 삭제할 예약 정보가 없습니다. {}, {}" + reservationId, travelId);
			return 0;
		}
		
		return reservationDAO.deleteReservationByIdTravelId(reservationId, travelId);
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
