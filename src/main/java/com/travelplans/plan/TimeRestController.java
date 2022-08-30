package com.travelplans.plan;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelplans.plan.bo.TimeBO;

@RestController
public class TimeRestController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TimeBO timeBO;
	
	@RequestMapping("/time/{planId}")
	public Map<String, Object> time(
			@RequestParam("travelId") int travelId,
			@RequestParam("itineraryId") int itineraryId,
			@PathVariable int planId,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (userId == null) {
			logger.error("[time / time] time userId null userId: " + userId);
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 다시 이용해주세요.");
			return result;
		}
		
		timeBO.time(travelId, itineraryId, planId);
		result.put("result", "success");
		
		return result;
	}
	
}
