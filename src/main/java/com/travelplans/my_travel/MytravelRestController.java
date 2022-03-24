package com.travelplans.my_travel;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelplans.my_travel.bo.MytravelBO;
import com.travelplans.my_travel.model.Trip;

@RestController
@RequestMapping("/my_travel")
public class MytravelRestController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MytravelBO mytravelBO;
	
	
	/**
	 *  새로운 travel 추가
	 * @param title
	 * @param color
	 * @param startDate
	 * @param endDate
	 * @param request
	 * @param model
	 * @return
	 */
	@PostMapping("/new_travel_add")
	public Map<String, Object> addNewTravel(
			@RequestParam("title") String title,
			@RequestParam("color") String color,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			HttpServletRequest request
			) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (userId == null) {
			logger.error("[my_travel/new_travel_add] 로그인 풀림");
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
			return result;
		}
		
		mytravelBO.addTrip(userId, title, color, startDate, endDate);
		
		
		return result;
		
	}

	
	@PostMapping("/reservation_traffic_add")
	public Map<String, Object> addTraffic(
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
			logger.error("[my_travel/reservation_traffic_add] 로그인 풀림");
			result.put("result","error");
			result.put("errorMessage", "로그인 후 이용해 주세에ㅛ.");
		}
		
		Trip trip = mytravelBO.getLastTrip();
		int tripId = trip.getId();
		
		mytravelBO.addTraffic(tripId, traffic, trafficInfo, start, startDate, startTime, arrive, arriveDate, arriveTime, price, memo);
		
		return result;
	}
	
	@PostMapping("/reservation_accommodation_add")
	public Map<String, Object> addAccommodation(
			@RequestParam("name") String name,
			@RequestParam("date") String date,
			@RequestParam(value="locaion", required=false) String locaion,
			@RequestParam(value="price", required=false) Integer price,
			@RequestParam(value="memo", required=false) String memo,
			HttpServletRequest request) {
		
		// map 결과 넣기
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		// session 가져오기
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// 로그아웃시 error메시지
		if (userId == null) {
			logger.error("[my_travel/reservation_accommodation_add 로그인 풀림");
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		// tripId가져오기
		Trip trip = mytravelBO.getLastTrip();
		int tripId = trip.getId();
		
		// insertBo만들기
		mytravelBO.addAccommodation(tripId, name, date, locaion, price, memo);
		
		return result;
	}
	
	@PostMapping("/reservation_reservation_add") 
	public Map<String, Object> addReservation(
			@RequestParam("title") String title,
			@RequestParam("booker") String booker,
			@RequestParam("date") String date,
			@RequestParam(value="locaion", required=false) String locaion,
			@RequestParam(value="price", required=false) Integer price,
			@RequestParam(value="memo", required=false) String memo,
			HttpServletRequest request) {
		
		// map 결과 만들기
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		// session 가져오기
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// 로그아웃시 error메세지
		if (userId == null) {
			logger.error("[/my_travel/reservation_reservation_add] 로그인 풀림");
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		// tripId 가져오기
		Trip trip = mytravelBO.getLastTrip();
		int tripId = trip.getId();
		
		// insertBO 
		mytravelBO.addReservation(tripId, title, booker, date, locaion, price, memo);
		
		return result;
		
		
	}
}








