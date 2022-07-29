package com.travelplans.new_travel;


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
import com.travelplans.new_travel.bo.NewTravelBO;

@RestController
@RequestMapping("/new_travel")
public class NewTravelRestController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private NewTravelBO newTravelBO;
	
	
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
	@PostMapping("/create")
	public Map<String, Object> addTravel(
			@RequestParam("title") String title,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			HttpServletRequest request
			) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (userId == null) {
			logger.error("[new_travel/create] 로그인 풀림");
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
			return result;
		}
		
		newTravelBO.addTravel(userId, title, startDate, endDate);
		
		return result;
		
	}

	
	
	
	// new_travel/update
	@RequestMapping("/update")
	public Map<String, Object> updateTravel(
			@RequestParam("travelId") int travelId,
			@RequestParam("title") String title,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			HttpServletRequest request
			) {
		
		// 결과 map 넣어준다.
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		 // session의 정보 가져온다.
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// 로그아웃시 에러처리
		if (userId == null) {
			logger.error("[new_travel/update] 로그인 풀림");
			result.put("return", "error");
			result.put("errorMessage", "로그인 후 이용 가능합니다.");
		}
		
		// update bo 가져온다.
		int count = newTravelBO.updateTravel(travelId, userId, title, startDate, endDate);
		
		if (count < 0) {
			logger.error("[new_travel/update] travel 정보 없음" + travelId);
			result.put("return", "error");
			result.put("errorMessage", "travel정보가 없읍니다. 다시 이용해주세요.");
		}
		
		return result;
	}

}








