package com.travelplans.itinerary.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.itinerary.model.DateListView;
import com.travelplans.itinerary.model.Itinerary;
import com.travelplans.new_travel.bo.NewTravelBO;
import com.travelplans.new_travel.model.Travel;
import com.travelplans.plan.bo.PlanBO;
import com.travelplans.plan.model.Plan;

@Service
public class DateListBO {

	@Autowired
	private NewTravelBO newTravelBO;
	
	@Autowired
	private ItineraryBO itineraryBO;
	
	@Autowired
	private PlanBO planBO;
	
	// dateList 만들기
	public List<String> generateDateListByTravelId(int travelId) {
		
		List<String> dateList = new ArrayList<>();
		
		Travel travel = newTravelBO.getTravelById(travelId);
		
		String startDate = travel.getStartDate();
		String endDate = travel.getEndDate();
		
		// String -> LocalDate
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startLocal = LocalDate.parse(startDate, formatter);
		LocalDate endLocal = LocalDate.parse(endDate, formatter);
				
		int i = 0;
		while (true) {
			//  날짜 더하기
			LocalDate plusDay = startLocal.plusDays(i);
			// LacalDate -> String
			String plusDayStr = plusDay.format(formatter);
			dateList.add(plusDayStr);
					
			if (endLocal.isEqual(plusDay)) {
				break;
			}
					
			i++;
		}
				
		return dateList;
				
	}
	
	
	// view용 DateListView List
	public List<DateListView> generateDateListViewList(int travelId) {
		
		List<DateListView> dateListView = new ArrayList<>();
		
		List<String> dateList = generateDateListByTravelId(travelId);
		for (String date : dateList) {
			DateListView content = new DateListView();
			// 날짜
			content.setDate(date);
			// 제목
			 Itinerary itinerary = itineraryBO.getItineraryByTravelIdDate(travelId, date);
			content.setItinerary(itinerary);
			int itineraryId = 0;
			
			if (itinerary != null) {
				itineraryId = itinerary.getId();
			}
			
			// plan정보 가져오기
			List<Plan> planList = planBO.getPlanListByItineraryId(itineraryId);
			content.setPlan(planList);
			
			// 날짜의 하루동안의 총 비용
			  int pricePlan = planBO.generatePlanPrice(itineraryId);
			  content.setPlanPrice(pricePlan);
			
			dateListView.add(content);
		}
		
			
		return dateListView;
	}
	

}
