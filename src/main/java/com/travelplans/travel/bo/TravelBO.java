package com.travelplans.travel.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.itinerary.bo.ItineraryBO;
import com.travelplans.itinerary.model.Itinerary;
import com.travelplans.plan.bo.PlanBO;
import com.travelplans.reservation.bo.ReservationBO;
import com.travelplans.travel.dao.TravelDAO;
import com.travelplans.travel.model.Travel;

@Service
public class TravelBO {
	
	// logger가져오기
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TravelDAO travelDAO;
	
	@Autowired
	private ReservationBO reservationBO;
	
	@Autowired
	private ItineraryBO itineraryBO;
	
	@Autowired
	private PlanBO planBO;	
	
	// 저장
	public void addTravel(int userId, String title, String startDate, String endDate) {
		travelDAO.insertTravel(userId, title, startDate, endDate);
	}
	
	public Travel getTravelByTravelId(int travelId) {
		return travelDAO.selectTravelByTravelId(travelId);
	}
	
	public Travel getTravelByUserIdDescLimit1(int userId) {
		return travelDAO.selectTravelByUserIdDescLimit1(userId);
	}
	
	public Travel getTravelByTravelIdUserId(int travelId, int userId) {
		return travelDAO.selectTravelByTravelIdUserId(travelId, userId);
	}
	
	public List<Travel> getTravelListByUserIdDesc(int userId) {
		return travelDAO.selectTravelListByUserIdDesc(userId);
	}
	
	public List<Travel> getTravelListByTravelId(int travelId) {
		return travelDAO.selectTravelListByTravelId(travelId);
	}
	
	// 수정
	public int updateTravel(int travelId, int userId, String title, String startDate, String endDate) {
		
		// travelId에 해당 여행이 있는지 db에서 가져온다.
		Travel travel = getTravelByTravelId(travelId);
		// 여행이 없는경우 logger로 남기기
		if (travel == null) {
			logger.error("[update / travel] travelBO travel null travelId: " + travelId + "userId: " + userId);
			return 0;
		} else {
			// 여행정보가 있을경우 수정하고, 없을경우 업데이트 안하기
			return travelDAO.updateTravelByIdUserId(travelId, userId, title, startDate, endDate);
		}
		
	}
	
	// 삭제
	public int deleteTravelByTravelIdUserId(int travelId, int userId) {
		
		// travel을 가져오기
		Travel travel = getTravelByTravelIdUserId(travelId, userId);
		
		if (travel == null) {
			logger.error("[delete / travel] travelBO travel null travelId: " + travelId + "userId: " + userId);
			return 0;
		}
		
		// traffic 정보 삭제
		reservationBO.deleteTrafficByTravelId(travelId);
		// accommodation 정보 삭제
		reservationBO.deleteAccommodationByTravelId(travelId);
		// reservation 정보 삭제
		reservationBO.deleteReservationByTravelId(travelId);
		// itinerary 정보 삭제
		itineraryBO.deleteItineraryByTravelId(travelId);
		// plan 정보 삭제
		planBO.deletePlanByTravelId(travelId);
		
		return travelDAO.deleteTravelByTravelIdUserId(travelId, userId);
	}
	
	
	public int deleteTravelByUserId(int userId) {
		
		List<Travel> travelList = getTravelListByUserIdDesc(userId);
		
		if (travelList.size() == 0) {
			return 0;
		}
		
		for (Travel travel : travelList) {
			
			int travelId = travel.getId();
			
			// traffic 정보 삭제
			reservationBO.deleteTrafficByTravelId(travelId);
			// accommodation 정보 삭제
			reservationBO.deleteAccommodationByTravelId(travelId);
			// reservation 정보 삭제
			reservationBO.deleteReservationByTravelId(travelId);
			// itinerary 정보 삭제
			itineraryBO.deleteItineraryByTravelId(travelId);
			// plan 정보 삭제
			planBO.deletePlanByTravelId(travelId);
		}
		
		return travelDAO.deleteTravelByUserId(userId);
		
	}
	
	
	
}
