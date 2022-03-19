package com.travelplans.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/travelplans")
public class UserController {
	/**
	 * travel plans 화면
	 * @return
	 */
	@RequestMapping("/travelplans_view")
	public String travelplansView() {

		return "user/travelplans";
	}
	
	/**
	 * 로그인 화면
	 * @return
	 */
	@RequestMapping("/sign_in_view")
	public String signInView() {
		
		return "user/sign_in";
	}
	
	/**
	 * 회원가입 화면
	 * @return
	 */
	@RequestMapping("/sign_up_view")
	public String signUpView() {
		
		return "user/sign_up";
	}
	
	/**
	 * 아이디/비밀번호 화면
	 * @return
	 */
	@RequestMapping("/find_user_view")
	public String findUserView() {
		
		return "user/find_user";
	}
	
	@RequestMapping("/sign_out")
	public String signOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userNickname");
		
		return "redirect:/travelplans/travelplans_view";
	}
}
