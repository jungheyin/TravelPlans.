package com.travelplans.travel;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelplans.travel.bo.TravelBO;

@RestController
@RequestMapping("/travel")
public class TravelRestController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TravelBO travelBO;
	
	
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
			logger.error("[create/travel] userId null userId: " + userId );
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
			return result;
		}
		
		travelBO.addTravel(userId, title, startDate, endDate);
		
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
			logger.error("[update/travel] userId null userId:" + userId);
			result.put("return", "error");
			result.put("errorMessage", "로그인 후 이용 가능합니다.");
		}
		
		// update bo 가져온다.
		int count = travelBO.updateTravel(travelId, userId, title, startDate, endDate);
		
		if (count < 0) {
			logger.error("[travel/update] travel null travelId" + travelId);
			result.put("return", "error");
			result.put("errorMessage", "travel정보가 없읍니다. 다시 이용해주세요.");
		}
		
		return result;
	}
	
	@DeleteMapping("/delete")
	public Map<String, Object> delete(
			@RequestParam("travelId") int travelId,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		
		if (userId == null) {
			logger.error("[delete/travel] user null userId: " +  userId);
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		int delCount = travelBO.deleteTravelByTravelIdUserId(travelId, userId);
		
		if (delCount < 0) {
			logger.error("[delete/travel] MY PLANS delete false userId: " + userId + "travelId: " + travelId);
			result.put("result", "error");
			result.put("errorMessage", "MY PLANS 삭제가 실패 했습니다.");
		}
		
		return result;
	}

}








