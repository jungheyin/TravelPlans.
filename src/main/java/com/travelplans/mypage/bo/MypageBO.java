package com.travelplans.mypage.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.mypage.dao.MypageDAO;
import com.travelplans.mypage.model.Travel;

@Service
public class MypageBO {
	
	@Autowired
	private MypageDAO mypageDAO;

	public List<Travel> getTravelList() {
		return mypageDAO.selsectTravelList();
	}
}
