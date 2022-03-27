package com.travelplans.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.travelplans.mypage.bo.MypageBO;
import com.travelplans.mypage.model.Travel;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MypageBO mypageBO;
	
	@RequestMapping("/mypage_view")
	public String mypageView(
			// 보여질 파라미터 가져오기
			HttpServletRequest request,
			Model model
			) {
		
		// 글쓴이 정보 가져오기
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		String userNickname = (String)session.getAttribute("userNickname");
		
		// list 글쓰기 목록 가져오기
		// db에서 가져오기
		List<Travel> travelList = mypageBO.getTravelList();
		model.addAttribute("travelList",travelList);
		
		return "mypage/mypage";
	}
	
	@RequestMapping("/setting_view")
	public String settingView() {
		
		return "mypage/setting";
	}
}
