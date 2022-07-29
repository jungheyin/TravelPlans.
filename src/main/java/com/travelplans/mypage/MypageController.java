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
import org.springframework.web.bind.annotation.RequestParam;

import com.travelplans.mypage.bo.MypageBO;
import com.travelplans.mypage.model.Travel;
import com.travelplans.reservation.bo.ReservationBO;
import com.travelplans.reservation.model.Accommodation;
import com.travelplans.reservation.model.Reservation;
import com.travelplans.reservation.model.Traffic;
import com.travelplans.user.bo.UserBO;
import com.travelplans.user.model.User;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private MypageBO mypageBO;
	
	@Autowired
	private ReservationBO reservationBO;
	
	@RequestMapping("/mypage_view")
	public String mypageView(
			HttpServletRequest request,
			Model model
			) {
		
		// 글쓴이 정보 가져오기
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		String userNickname = (String)session.getAttribute("userNickname");
		
		// list 글쓰기 목록 가져오기
		// db에서 가져오기

		List<Travel> travelList = mypageBO.getTravelList(userId);
		User user = userBO.getUserById(userId);
		
		
		model.addAttribute("user", user);
		model.addAttribute("travelList", travelList);
		model.addAttribute("mypageViewName", "mypage");
		
		return "mypage/template/layout";
	}
	
	@RequestMapping("/setting_view")
	public String settingView(
			HttpServletRequest request,
			Model model) {
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		String userNickname = (String)session.getAttribute("userNicknaem");
		
		List<Travel> travelList = mypageBO.getTravelList(userId);
		User user = userBO.getUserById(userId);
		
		model.addAttribute("user", user);
		model.addAttribute("travelList", travelList);
		model.addAttribute("mypageViewName", "setting");
		return "mypage/template/layout";
	}
	
	@RequestMapping("/detail_view") 
	public String detailView(
			@RequestParam("travelId") int travelId,
			Model model) {
		
		Travel travel = mypageBO.getTravelById(travelId);
		
		List<Traffic> trafficList = reservationBO.getTrafficList(travelId);
		List<Accommodation> accommodationList = reservationBO.getAccommodationList(travelId);
		List<Reservation> reservationList = reservationBO.getReservationList(travelId);
		
		
		model.addAttribute("travel", travel);
		model.addAttribute("trafficList", trafficList);
		model.addAttribute("accommodationList", accommodationList);
		model.addAttribute("reservationList", reservationList);
		model.addAttribute("mypageViewName", "detail");
		return "mypage/template/layout";
	}
}
