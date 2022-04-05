package com.travelplans.mypage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelplans.mypage.bo.MypageBO;

@RestController
@RequestMapping("/mypage")
public class MypageRestController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MypageBO mypageBO;

	@DeleteMapping("/delete")
	public Map<String, Object> delete(
			@RequestParam("travelId") int travelId,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		
		if (userId == null) {
			logger.error("[mypage/delete] 로그인 풀림" +  userId);
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		int delCount = mypageBO.deleteTravelByIdUserId(travelId, userId);
		
		if (delCount < 0) {
			logger.error("[mypage/delete] MY PLANS 삭제 안됨" + userId);
			result.put("result", "error");
			result.put("errorMessage", "MY PLANS 삭제가 실패 했습니다.");
		}
		
		return result;
	}
	
	@PutMapping("/update_nickname")
	public  Map<String, Object> updateNickname(
			@RequestParam("nickname") String nickname,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (userId == null) {
			logger.error("[mypage/update_nickname] 로그인 풀림" + userId);
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 이용해 주세요.");
		}
		
		int upCount = mypageBO.updateNicknameById(userId, nickname) ;
		
		if (upCount < 0 ) {
			logger.error("[mypage/update_nickname] 닉네임변경 실패" + userId);
			result.put("result", "error");
			result.put("errorMessage", "닉네임 변경에 실패했습니다.");
		}
		
		return result;
		
		
	}
	
}
