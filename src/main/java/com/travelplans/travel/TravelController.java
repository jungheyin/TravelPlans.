package com.travelplans.travel;

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

import com.travelplans.reservation.bo.ReservationBO;
import com.travelplans.reservation.model.Accommodation;
import com.travelplans.reservation.model.Reservation;
import com.travelplans.reservation.model.Traffic;
import com.travelplans.travel.bo.TravelBO;
import com.travelplans.travel.model.Travel;
import com.travelplans.user.bo.UserBO;
import com.travelplans.user.model.User;

@Controller
@RequestMapping("/travel")
public class TravelController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TravelBO travelBO;
	
	@Autowired
	private UserBO userBO;
	
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
		
		List<Travel> travelList = travelBO.getTravelListByUserIdDesc(userId);
		User user = userBO.getUserById(userId);
		
		
		model.addAttribute("user", user);
		model.addAttribute("travelList", travelList);
		model.addAttribute("mypageViewName", "mypage");
		
		return "mypage/template/layout";
	}
	
	@RequestMapping("/mypage_setting_view")
	public String settingView(
			HttpServletRequest request,
			Model model) {
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		List<Travel> travelList = travelBO.getTravelListByUserIdDesc(userId);
		User user = userBO.getUserById(userId);
		
		model.addAttribute("user", user);
		model.addAttribute("travelList", travelList);
		model.addAttribute("mypageViewName", "setting");
		return "mypage/template/layout";
	}
	
	@RequestMapping("/mypage_detail_view") 
	public String detailView(
			@RequestParam("travelId") int travelId,
			Model model) {
		
		Travel travel = travelBO.getTravelByTravelId(travelId);
		
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
	/**
	 * 새로운 여행계획 저장 화면
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/create_view")
	public String createTravel(Model model) {
		
		model.addAttribute("travelViewName", "create");
		
		return "travel/template/layout";
	}

	/**
	 * 새로운 여행계획 수정 화면
	 * @param travelId
	 * @param model
	 * @return
	 */
	@RequestMapping("/update_view")
	public String updateTravel(
			@RequestParam("travelId") int travelId,
			Model model) {
		
		Travel travel = travelBO.getTravelByTravelId(travelId);
		
		if (travel == null) {
			logger.error("[tarvel/update_view] travel null" + travel.getId());
		}
		
		model.addAttribute("travel", travel);
		model.addAttribute("travelViewName", "update");
		
		return "travel/template/layout";
	}
	

	
}
