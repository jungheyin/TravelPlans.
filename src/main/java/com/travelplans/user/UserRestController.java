package com.travelplans.user;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelplans.common.EncryptUtils;
import com.travelplans.user.bo.UserBO;
import com.travelplans.user.model.User;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserBO userBO;
	/**
	 * 회원가입 - 중복확인
	 * @param loginId
	 * @return
	 */
	@RequestMapping("/is_duplicated_id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId) {
		
		Map<String, Object> result = new HashMap<>();
		boolean existLoginId = userBO.existLoginId(loginId);
		result.put("result", existLoginId);
		
		
		return result;
	}
	
	@RequestMapping("is_find_id")
	public Map<String, Object> isFindId(
			@RequestParam("email") String email) throws UnsupportedEncodingException {
		
		
		Map<String, Object> result = new HashMap<>();
		boolean existId = userBO.existEmail(email);
		result.put("result", existId);
		
		return result;
	}
	
	@RequestMapping("is_find_password")
	public Map<String, Object> isFindPassword(
			@RequestParam("loginId") String loginId,
			@RequestParam("email") String email) {
		
		Map<String, Object> result = new HashMap<>();
		boolean existPassword = userBO.existLoginIdEmail(loginId, email);
		result.put("result", existPassword);
		
		return result; 
	}
	/**
	 * 회원가입 - ajax호출
	 * @param loginId
	 * @param password
	 * @param nickname
	 * @param email
	 * @return
	 */
	  @RequestMapping("/sign_up") 
	  public Map<String, Object> signUp(
			  @RequestParam("loginId") String loginId , 
			  @RequestParam("password") String password , 
			  @RequestParam("nickname") String nickname , 
			  @RequestParam("email") String email) {
	  
	  String encryptPassword = EncryptUtils.md5(password);
	  
	  int row = userBO.addUser(loginId, encryptPassword, nickname, email);
	  

	   Map<String, Object> result = new HashMap<>(); 
	   result.put("result","success");
	   
	   if (row < 0) {
		   logger.error("[signUp false] 회원가입 실패.");
		   result.put("result", "error");
		   result.put("errorMassage", "회원가입 실패");
		   
	   }
	  
	  return result; 
	  }
	 
	  @RequestMapping("/sign_in")
	  public Map<String, Object> signIn(
			  @RequestParam("loginId") String loginId,
			  @RequestParam("password") String password,
			  HttpServletRequest request) {
		  
		 String encryptPassword = EncryptUtils.md5(password);
		 
		 User user = userBO.getUserByLoginIdPassword(loginId, encryptPassword);

		 Map<String, Object> result = new HashMap<>();
		  result.put("result", "success");
		  
		  if (user != null) { // 로그인 성공
			  HttpSession session = request.getSession();
			  session.setAttribute("userId", user.getId());
			  session.setAttribute("userLoginId", user.getLoginId());
			  session.setAttribute("userNickname", user.getNickname());
		  }	else {
			  logger.error("[login false] 로그인 실패. 사용자 없음");
			  result.put("result", "error");
			  result.put("errorMessage", "아이디 또는 비밀번호를 잘못 입력하셨습니다.");
		  }
		  
		  return result;
	  }
	  
	  @PutMapping("/password_update")
	  public Map<String, Object> passwordUpdate(
			  @RequestParam("userId") int userId,
			  @RequestParam("password") String password,
			  HttpServletRequest request) {
		
		  // map 결과
		  Map<String,Object> result = new HashMap<>();
		  result.put("result", "success");
		  
		  // update BO
		  int updateCount = userBO.updateUser(userId, password);
		  
		  if (updateCount < 0) {
			  logger.error("[password/update] not update" + userId);
			  result.put("result", "error");
			  result.put("errorMessage", "비밀번호 변경 실패");
		  }
		  
		  return result;
		  
	  }
}
