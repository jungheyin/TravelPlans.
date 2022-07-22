package com.travelplans.itinerary.model;

import java.util.List;
import java.util.Map;

import com.travelplans.new_travel.model.Travel;

public class DateListView {
	
	private Travel travel; // 여행 정보
	private String date;//날짜
	private Itinerary itinerary; // 여행일정 부분
	// 일정(plan)가져오기
	
	public Travel getTravel() {
		return travel;
	}
	public void setTravel(Travel travel) {
		this.travel = travel;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Itinerary getItinerary() {
		return itinerary;
	}
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	
}
