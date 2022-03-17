package com.travelplans.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class mypageController {
	
	@RequestMapping("/mypage_view")
	public String mypageView() {
		
		return "mypage/mypage";
	}
	
	@RequestMapping("/setting_view")
	public String settingView() {
		
		return "mypage/setting";
	}
}
