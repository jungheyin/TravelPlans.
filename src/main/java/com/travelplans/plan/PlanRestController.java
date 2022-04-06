package com.travelplans.plan;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plan")
public class PlanRestController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/create")
	public Map<String, Object> create(
			@RequestParam("travelId") int travelId,
			@RequestParam("date") String date,
			@RequestParam("placeName") String placeName,
			@RequestParam(value="time", required=false) String time,
			@RequestParam(value="location", required=false) String location,
			@RequestParam(value="memo", required=false) String memo,
			@RequestParam(value="price", required=false) Integer price,
			@RequestParam(value="testTime", required=false) Integer testTime,
			@RequestParam(value="traffic", required=false) String traffic,
			@RequestParam(value="file", required=false) String file,
			HttpServletRequest request) {
		
		
		// Map 결과
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		// session
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// user null
		if(userId == null ) {
			logger.error("[plan/create] 로그인 풀림" + userId);
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		// insertBO
		
		return result;
	}
}
