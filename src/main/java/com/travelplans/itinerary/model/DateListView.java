package com.travelplans.itinerary.model;

import java.util.List;

import com.travelplans.new_travel.model.Travel;
import com.travelplans.plan.model.Plan;

public class DateListView {
	
	private Travel travel; // 여행 정보
	private String date;//날짜
	private Itinerary itinerary; // 여행일정 부분
	private List<Plan> plan; // 일정(plan)가져오기
	private int planPrice;
	
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
	public List<Plan> getPlan() {
		return plan;
	}
	public void setPlan(List<Plan> plan) {
		this.plan = plan;
	}
	public int getPlanPrice() {
		return planPrice;
	}
	public void setPlanPrice(int planPrice) {
		this.planPrice = planPrice;
	}
	
	
}
