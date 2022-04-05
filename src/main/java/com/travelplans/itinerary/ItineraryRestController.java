package com.travelplans.itinerary;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping("/create")
	public Map<String, Object> create(
			@RequestParam("travelId") int travelId,
			@RequestParam(value="color", required=false) String color,
			@RequestParam("title") String title,
			HttpServletRequest request) {
		
		// map 결과
		Map<String, Object> result = new HashMap<>();
		result.put("result","success");
		
		// session
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// null
		if (userId == null) {
			logger.error("[itinerary/create] user not null " + userId);
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		// insertBO
		itineraryBO.addItinerary(travelId, color, title);
		
		
		return result;
	}

}
