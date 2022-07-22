package com.travelplans.itinerary;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelplans.itinerary.bo.ItineraryBO;

@RestController
@RequestMapping("/itinerary")
public class ItineraryRestController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ItineraryBO itineraryBO;
	
	
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam("travelId") int travelId,
			@RequestParam("date") String date,
			@RequestParam("title") String title,
			HttpServletRequest request) {
		
		// map 결과
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		// session
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// null
		if (userId == null) {
			logger.error("[itinerary/create] user null" + userId);
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		// insertBO
		int row = itineraryBO.addItinerary(travelId, date, title);
		
		if (row < 1) {
			logger.error("[itinerary/create] itinerary row < 1" + travelId);
			result.put("result", "error");
			result.put("errorMessage", "제목을 저장할 수 없습니다.");
		}
		
		if (row > 1) {
			logger.error("[itinerary/create] itinerary row > 1" + travelId);
			result.put("result", "error");
			result.put("errorMessage", "제목을 저장할 수 없습니다.");
		}
		return result;
	}
	
	@PutMapping("/update") 
	public Map<String, Object> update(
			@RequestParam("itineraryId") int itineraryId,
			@RequestParam("travelId") int travelId,
			@RequestParam("date") String date,
			@RequestParam("title") String title,
			@RequestParam(value="color", required=false) String color,
			HttpServletRequest request) {
		
		// map 결과
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		// session
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// session null
		if (userId == null) {
			logger.error("[itinerary/update] user not null" + userId);
			result.put("return", "error");
			result.put("errorMessage", "로그인 후 이용 가능합니다");
		}
		
		// update BO
		int upCount = itineraryBO.updateItinerary(itineraryId, travelId, date, title, color);
		
		if (upCount < 0) {
			logger.error("[itinerary/update] not update" + userId + travelId + date);
			result.put("result", "error");
			result.put("errorMessage", "수정에 실패했습니다.");
		}
		
		
		return result;
	}
	
}
