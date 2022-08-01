package com.travelplans.user;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelplans.user.bo.UserBO;
import com.travelplans.user.model.User;

@Controller
@RequestMapping("/travelplans")
public class UserController {
	
	@Autowired
	private UserBO userBO;
	
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
	public String findUserView(
			HttpServletRequest request,
			Model model) {
		
		
		
		model.addAttribute("findUserView", "find_user");
		
		return "user_find/template/layout";
	}
	
	@RequestMapping("/find_id_view")
	public String findIdView(
			@RequestParam("email") String email,
			HttpServletRequest request,
			Model model) throws UnsupportedEncodingException {
	
		email = URLDecoder.decode(new String(Base64.getDecoder().decode(email), "utf-8"), "utf-8");
		 
		List<User> userList = userBO.getUserByEmail(email);
		
		model.addAttribute("userList", userList);
		model.addAttribute("findUserView", "find_id");		
		
		return "user_find/template/layout";
	}
	
	@RequestMapping("/find_password_view")
	public String findPasswordView(
			@RequestParam("loginId") String loginId,
			@RequestParam("email") String email,
			HttpServletRequest request,
			Model model) throws UnsupportedEncodingException {
	
		loginId = URLDecoder.decode(new String(Base64.getDecoder().decode(loginId), "utf-8"), "utf-8");
		email = URLDecoder.decode(new String(Base64.getDecoder().decode(email), "utf-8"), "utf-8");
		
		User user = userBO.getUserByLoginIdEmail(loginId, email);
		
		model.addAttribute("user", user);
		model.addAttribute("findUserView", "find_password");
		
		return "user_find/template/layout";
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
