package com.travelplans.my_travel;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelplans.my_travel.bo.MytravelBO;

@RestController
@RequestMapping("/my_travel")
public class MytravelRestController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MytravelBO mytravelBO;
	// /my_travel/reservation_traffic_add
	@PostMapping("/reservation_traffic_add")
	public Map<String, Object> addTraffic(
			@RequestParam("traffic") String traffic,
			@RequestParam("trafficInfo") String trafficInfo,
			@RequestParam("start") String start,
			@RequestParam(value="startDate", required=false) String startDate,
			@RequestParam(value="startTime", required=false) String startTime,
			@RequestParam(value="arrive", required=false) String arrive,
			@RequestParam(value="arriveDate", required=false) String arriveDate,
			@RequestParam(value="arriveTime", required=false) String arriveTime,
			@RequestParam(value="price", required=false) String price,
			@RequestParam(value="memo", required=false) String memo,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		// 권한검사
		// 1. user의 정보가져오기
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		String userNickname = (String)session.getAttribute("userNickname");
		
		// 2. 로그인안되어 있을때 에러 처리
		if (userId == null) { // 로그인이 안된경우
			logger.error("[my_travel] 예약등록시 로우아웃");
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 가능합니다.");
			return result;
		}
		
		// insert BO
		
		
		// map 결과
		
		return result;
	}

}
