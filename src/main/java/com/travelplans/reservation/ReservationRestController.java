package com.travelplans.reservation;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelplans.reservation.bo.ReservationBO;

@RestController
@RequestMapping("/reservation")
public class ReservationRestController {
	
	private static final Map<String, Object> HttpSession = null;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ReservationBO reservationBO;
	
	/**
	 * 교통수단 저장
	 * @param traffic
	 * @param trafficInfo
	 * @param start
	 * @param startDate
	 * @param startTime
	 * @param arrive
	 * @param arriveDate
	 * @param arriveTime
	 * @param price
	 * @param memo
	 * @param request
	 * @return
	 */
	@PostMapping("/traffic_add")
	public Map<String, Object> addTraffic(
			@RequestParam("travelId") int travelId,
			@RequestParam("traffic") String traffic,
			@RequestParam("trafficInfo") String trafficInfo, 
			@RequestParam("start") String start, 
			@RequestParam("startDate") String startDate, 
			@RequestParam(value="startTime", required=false) String startTime, 
			@RequestParam(value="arrive", required=false) String arrive, 
			@RequestParam(value="arriveDate", required=false) String arriveDate,
			@RequestParam(value="arriveTime", required=false) String arriveTime,
			@RequestParam(value="price", required=false) Integer price, 
			@RequestParam(value="memo", required=false) String memo,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (userId == null) {
			logger.error("[add_traffic / reservation] traffic userId == null userId: " + userId + "travelId: " + travelId);
			result.put("result","error");
			result.put("errorMessage", "로그인 후 이용해 주세에요.");
		}
		
		reservationBO.addTraffic(travelId, traffic, trafficInfo, start, startDate, startTime, arrive, arriveDate, arriveTime, price, memo);
		
		return result;
	}
	
	/**
	 *  숙소 저장
	 * @param name
	 * @param date
	 * @param locaion
	 * @param price
	 * @param memo
	 * @param request
	 * @return
	 */
	@PostMapping("/accommodation_add")
	public Map<String, Object> addAccommodation(
			@RequestParam("travelId") int travelId,
			@RequestParam("name") String name,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam(value="location", required=false) String location,
			@RequestParam(value="price", required=false) Integer price,
			@RequestParam(value="memo", required=false) String memo,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (userId == null) {
			logger.error("[reservation/add_accommodation] accommodation userId null userId: " + userId + "travelId: " + travelId);
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		
		reservationBO.addAccommodation(travelId, name, startDate, endDate, location, price, memo);
		
		return result;
	}
	
	
	/**
	 *  예약정보 저장
	 * @param title
	 * @param booker
	 * @param date
	 * @param locaion
	 * @param price
	 * @param memo
	 * @param request
	 * @return
	 */
	@PostMapping("/reservation_add") 
	public Map<String, Object> addReservation(
			@RequestParam("travelId") int travelId,
			@RequestParam("title") String title,
			@RequestParam("booker") String booker,
			@RequestParam("date") String date,
			@RequestParam(value="location", required=false) String location,
			@RequestParam(value="price", required=false) Integer price,
			@RequestParam(value="memo", required=false) String memo,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (userId == null) {
			logger.error("[add_reservation / reservation] reservation userId null userId: " + userId + "travelId: " + travelId);
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		reservationBO.addReservation(travelId, title, booker, date, location, price, memo);
		
		return result;
	}
	
	/**
	 * 교통수단 수정하기
	 * @param trafficId
	 * @param travelId
	 * @param traffic
	 * @param trafficInfo
	 * @param start
	 * @param startDate
	 * @param startTime
	 * @param arrive
	 * @param arriveDate
	 * @param arriveTime
	 * @param price
	 * @param memo
	 * @param request
	 * @return
	 */
	@PutMapping("/traffic_update")
	public Map<String, Object> updateTraffic(
			@RequestParam("trafficId") int trafficId,
			@RequestParam("travelId") int travelId,
			@RequestParam("traffic") String traffic,
			@RequestParam("trafficInfo") String trafficInfo, 
			@RequestParam("start") String start, 
			@RequestParam("startDate") String startDate, 
			@RequestParam(value="startTime", required=false) String startTime, 
			@RequestParam(value="arrive", required=false) String arrive, 
			@RequestParam(value="arriveDate", required=false) String arriveDate,
			@RequestParam(value="arriveTime", required=false) String arriveTime,
			@RequestParam(value="price", required=false) Integer price, 
			@RequestParam(value="memo", required=false) String memo,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (userId == null) {
			logger.error("traffic_update / reservation] traffic userId == null userId: " + userId + "travelId: " + travelId + "trafficId: " + trafficId);
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		
		int upCount = reservationBO.updateTraffic(trafficId, travelId, traffic, trafficInfo, start, startDate, startTime, 
				arrive, arriveDate, arriveTime, price, memo);
		
		if (upCount < 0 ) {
			logger.error("[traffic_update / reservation] traffic upCount < 0 travelId: " + travelId + "trafficId: " + trafficId);
			result.put("result", "error");
			result.put("errorMassage", "수정에 실패했습니다.");
		}
		
		return result;
		
	}
	
	/**
	 * 숙소 수정하기
	 * @param accommodationId
	 * @param travelId
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @param location
	 * @param price
	 * @param memo
	 * @param request
	 * @return
	 */
	@PutMapping("/accommodation_update")
	public Map<String, Object> updateAccommodation(
			@RequestParam("accommodationId") int accommodationId,
			@RequestParam("travelId") int travelId,
			@RequestParam("name") String name,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam(value="location", required=false) String location,
			@RequestParam(value="price", required=false) Integer price,
			@RequestParam(value="memo", required=false) String memo,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (userId == null) {
			logger.error("[update_accommodation / reservation] accommodation userId null userId: " + userId + "travelId: " + travelId + "accommodationId:" + accommodationId);			
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		int upCount = reservationBO.updateAccommodation(accommodationId, travelId, name, startDate, endDate, location, price, memo);
		
		if (upCount < 0 ) {
			logger.error("[accommodation_update / reservation] accommodation upCount < 0 travelId" + travelId + "accommodationId: " + accommodationId );
			result.put("result", "error");
			result.put("errorMessage", "수정에 실패 했습니다.");
		}
		return result;
	}
	
	/**
	 * 예약정보 수정하기
	 * @param reservationId
	 * @param travelId
	 * @param title
	 * @param booker
	 * @param date
	 * @param location
	 * @param price
	 * @param memo
	 * @param request 
	 * @return
	 */
	@PutMapping("/reservation_update")
	public Map<String, Object> updateReservation(
			@RequestParam("reservationId") int reservationId,
			@RequestParam("travelId") int travelId,
			@RequestParam("title") String title,
			@RequestParam("booker") String booker,
			@RequestParam("date") String date,
			@RequestParam(value="location", required=false) String location,
			@RequestParam(value="price", required=false) Integer price,
			@RequestParam(value="memo", required=false) String memo,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (userId == null) {
			logger.error("[update_reservation / reservation] reservation userId null userId: " + userId + "travelId: " + travelId + "resrvationId" + reservationId);			
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		int upCount = reservationBO.updateReservation(reservationId, travelId, title, booker, date, location, price, memo);
		
		if (upCount < 0 ) {
			logger.error("[reservation_update / reservation] reservation upCount < 0 travelId" + travelId + "reservationId: " + reservationId);
			result.put("result", "error");
			result.put("errorMessage", "수정에 실패 했습니다.");
		}
		return result;
	}
	
	
	/**
	 *  교통수단 삭제하기
	 * @param trafficId	
	 * @param travelId
	 * @param request
	 * @return
	 */
	@DeleteMapping("/delete_traffic")
	public Map<String, Object> deleteTraffic(
			@RequestParam("trafficId") int trafficId,
			@RequestParam("travelId") int travelId,
			HttpServletRequest request
			) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if(userId == null) {
			logger.error("[delete_traffic / reservation] traffic userId null userId: " + userId + "travelId: " + travelId + "trafficId: " + trafficId);
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		
		int delCount = reservationBO.deleteTrafficByTrafficIdTravelId(trafficId, travelId);
		
		if (delCount < 0) {
			logger.error("[delete_traffic / reservation] traffic delCount < 0 travalId: " + "trafficId: " + trafficId );
			result.put("result", "error");
			result.put("errorMessage", "교통수단 정보 삭제 실패했습니다.");
		}
		
		return result;
	}
	
	/**
	 * 숙소 삭제하기
	 * @param accommodationId
	 * @param travelId
	 * @param request
	 * @return
	 */
	@DeleteMapping("/delete_accommodation")
	public Map<String, Object> deleteAccommodaion(
			@RequestParam("accommodationId") int accommodationId,
			@RequestParam("travelId") int travelId,
			HttpServletRequest request) {
			
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
			
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
			
		if(userId == null) {
			logger.error("[delete_accommodation / reservation]accommodation userId null userId: " + userId + "travelId: " + travelId + "accommodation: " + accommodationId);
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
			
			
		int delCount = reservationBO.deleteAccommodationByAccommodationIdTravelId(accommodationId, travelId);
					
		if (delCount < 0) {
			logger.error("[delete_accommodation / reservation] accommodation delCount < 0 travelId: " + travelId + "accommodationId: " + accommodationId);
			result.put("result", "error");
			result.put("errorMessage", "숙소 예약 정보 삭제 실패했습니다.");
		}
			
		return result;
			
	}
	
	
	// reservation 삭제
	@DeleteMapping("/delete_reservation")
	public Map<String, Object> deleteReservation(
			@RequestParam("reservationId") int reservationId,
			@RequestParam("travelId") int travelId,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
			
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
			
		if(userId == null) {
			logger.error("[delete_reservation / reservation] reservation userId null userId: " + userId + "travelId: " + travelId + "reservationId" + reservationId );
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
			
			
		int delCount = reservationBO.deleteReservationByReservationIdTravelId(reservationId, travelId);
					
		if (delCount < 0) {
			logger.error("[delete_reservation / reservation] resrvation delCount < 0 travelId: " + travelId + "reservationId: " + reservationId);
			result.put("result", "error");
			result.put("errorMessage", "예약 정보 삭제 실패했습니다.");
		}
			
		return result;
	}
	
	
}
