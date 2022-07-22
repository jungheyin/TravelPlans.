package com.travelplans.plan;

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

import com.travelplans.plan.bo.PlanBO;

@RestController
@RequestMapping("/plan")
public class PlanRestController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PlanBO planBO;	
	
	@RequestMapping("/create")
	public Map<String, Object> create(
			@RequestParam("itineraryId") int itineraryId,
			@RequestParam("date") String date,
			@RequestParam("planName") String planName,
			@RequestParam("time") String time,
			@RequestParam("location") String location,
			@RequestParam("memo") String memo,
			@RequestParam("price") int price,
			HttpServletRequest request) {
		
		// map 결과
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		// session
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// userId ull 확인
		if (userId == null) {
			logger.error("[plan/create] user null" + userId);
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		// insert BO
		planBO.addPlan(itineraryId, date, planName, time, location, memo, price);
		
		return result;
	}

}
