package com.travelplans.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/travelplans")
public class UserController {

	@RequestMapping("/travelplans_view")
	public String travelplansView() {

		return "user/travelplans";
	}
	
	@RequestMapping("/sign_in_view")
	public String signInView() {
		
		return "user/sign_in";
	}
	
	@RequestMapping("/sign_up_view")
	public String signUpView() {
		
		return "user/sign_up";
	}
}
