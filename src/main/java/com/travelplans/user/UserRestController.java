package com.travelplans.user;

import java.io.UnsupportedEncodingException;
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
	
	@RequestMapping("/user/is_find_id")
	public Map<String, Object> isFindId(
			@RequestParam("email") String email) throws UnsupportedEncodingException {
		
		
		Map<String, Object> result = new HashMap<>();
		boolean existId = userBO.existEmail(email);
		result.put("result", existId);
		
		return result;
	}
	
	@RequestMapping("/user/is_find_password")
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
		   logger.error("[signUp / user] signUp false ");
		   result.put("result", "error");
		   result.put("errorMassage", "회원가입 실패");
		   
	   }
	  
	  return result; 
	  }
	 
	  @RequestMapping("/user/sign_in")
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
			  logger.error("[sign_in / user] user null ");
			  result.put("result", "error");
			  result.put("errorMessage", "아이디 또는 비밀번호를 잘못 입력하셨습니다.");
		  }
		  
		  return result;
	  }
	  
	  @PutMapping("/user/password_update")
	  public Map<String, Object> passwordUpdate(
			  @RequestParam("userId") int userId,
			  @RequestParam("password") String password,
			  HttpServletRequest request) {
		
		  // map 결과
		  Map<String,Object> result = new HashMap<>();
		  result.put("result", "success");
		  
		  String encryptPassword = EncryptUtils.md5(password);
		  
		  // update BO
		  int updateCount = userBO.updateUser(userId, encryptPassword);
		  
		  if (updateCount < 0) {
			  logger.error("[password_update / user] password update false userId: " + userId);
			  result.put("result", "error");
			  result.put("errorMessage", "비밀번호 변경 실패");
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
				logger.error("[update_nickname / user] user null userId: " + userId);
				result.put("result", "error");
				result.put("errorMessage", "로그인 후 이용해 주세요.");
			}
			
			int upCount = userBO.updateNickNameByUserId(userId, nickname);
			
			if (upCount < 0 ) {
				logger.error("[update_nickname/ user] nickname update false userId: " + userId);
				result.put("result", "error");
				result.put("errorMessage", "닉네임 변경에 실패했습니다.");
			}
			
			return result;
			
		}
		
		
		@DeleteMapping("/delete") 
		public Map<String, Object> delete(
				@RequestParam("userId") int userId,
				HttpServletRequest request) {
			
			Map<String, Object> result = new HashMap<>();
			result.put("result", "success");
			
			HttpSession session = request.getSession();
			Integer loginUserId = (Integer)session.getAttribute("userId");
			
			if (loginUserId == null) {
				logger.error("[delete/ user] user null userId: " + loginUserId );
				result.put("result", "error");
				result.put("errorMessage", "로그인 후 이용해 주세요.");
			}
			
			int delCount = userBO.deleteUserByUserId(userId);
					
			if (delCount < 0) {
				logger.error("[delete/ user] delCount < 0 userId: " + loginUserId);
				result.put("result", "error");
				result.put("errorMessage", "회원탈퇴에 실패했습니다.");
			}
			
			return result;
			
		}
}
