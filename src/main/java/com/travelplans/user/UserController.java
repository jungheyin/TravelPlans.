package com.travelplans.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/travelplans")
public class UserController {

	@RequestMapping("travelplans_view")
	public String travelplans() {
		
		return "user/travelplans";
	}
	
}
