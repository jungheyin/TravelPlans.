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
import com.travelplans.reservation.model.Traffic;

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
			logger.error("[reservation/add_traffic] 로그인 풀림");
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
			@RequestParam(value="locaion", required=false) String locaion,
			@RequestParam(value="price", required=false) Integer price,
			@RequestParam(value="memo", required=false) String memo,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (userId == null) {
			logger.error("[reservation/add_accommodation] 로그인 풀림");
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		
		reservationBO.addAccommodation(travelId, name, startDate, endDate, locaion, price, memo);
		
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
			@RequestParam(value="locaion", required=false) String locaion,
			@RequestParam(value="price", required=false) Integer price,
			@RequestParam(value="memo", required=false) String memo,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (userId == null) {
			logger.error("[/reservation/add_reservation] 로그인 풀림");
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		reservationBO.addReservation(travelId, title, booker, date, locaion, price, memo);
		
		return result;
	}
	
	/*
	 * {"travelId":travelId, "traffic":traffic, "trafficInfo":trafficInfo,
	 * "start":start, "startDate":startDate,"startTime":startTime, "arrive":arrive,
	 * "arriveDate":arriveDate, "arriveTime":arriveTime, "price":price, "memo":memo}
	 */
	// traffic 수정
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
			logger.error("[reservation/traffic_update] 로그인 풀림");
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		
		int upCount = reservationBO.updateTraffic(trafficId, travelId, traffic, trafficInfo, start, startDate, startTime, 
				arrive, arriveDate, arriveTime, price, memo);
		
		if (upCount < 0 ) {
			result.put("result", "error");
			result.put("errorMassage", "수정에 실패했습니다.");
		}
		
		return result;
		
		
	}
	
	// accommodation 수정
	
	// reservation 수정
	
	// traffic 삭제
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
			logger.error("[reservation/delete_traffic] 로그인 풀림");
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		Traffic traffic = reservationBO.getTrafficById(trafficId);
		trafficId = traffic.getId();
		
		// delete BO
		int delCount = reservationBO.deleteTraffic(trafficId, travelId);
		
		return result;
	}
	// accommodation 삭제
		
	// reservation 삭제
}
