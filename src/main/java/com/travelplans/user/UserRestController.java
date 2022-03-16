package com.travelplans.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelplans.common.EncryptUtils;
import com.travelplans.user.bo.UserBO;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
	@RequestMapping("/is_duplicated_id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId) {
		
		Map<String, Object> result = new HashMap<>();
		boolean existLoginId = userBO.existLoginId(loginId);
		result.put("result", existLoginId);
		
		
		return result;
	}

	
	  @RequestMapping("/sign_up") 
	  public Map<String, Object> signUp(
			  @RequestParam("loginId") String loginId , 
			  @RequestParam("password") String password , 
			  @RequestParam("nickname") String nickname , 
			  @RequestParam("email") String email) {
	  
	  String encryptPassword = EncryptUtils.md5(password);
	  
	  int row = userBO.addUser(loginId, encryptPassword, nickname, email);
	  
	  // 결과
	   Map<String, Object> result = new HashMap<>(); 
	   result.put("result","success");
	   
	   if (row > 0) {
		   result.put("result", "error");
		   result.put("errorMassage", "이미 가입된 여행자입니다.");
	   }
	  
	  return result; 
	  }
	 
}
