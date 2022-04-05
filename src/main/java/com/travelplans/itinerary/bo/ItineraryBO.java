package com.travelplans.itinerary.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.itinerary.dao.ItineraryDAO;
import com.travelplans.itinerary.model.Itinerary;
import com.travelplans.new_travel.bo.NewTravelBO;
import com.travelplans.new_travel.model.Travel;

@Service
public class ItineraryBO {
	
	@Autowired
	private NewTravelBO newTravelBO;
	
	@Autowired
	private ItineraryDAO itineraryDAO;
	
	public List<String> generateTravelDateListById(int travelId) {
		
		Travel travel = newTravelBO.getTravelById(travelId);
		
		String startDate = travel.getStartDate();
		String endDate = travel.getEndDate();
		
		List<String> travelDateList = new ArrayList<>();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startLocal = LocalDate.parse(startDate, formatter);
		LocalDate endLocal = LocalDate.parse(endDate, formatter);
		
		int i = 0;
		while (true) {
			
			LocalDate plusDay = startLocal.plusDays(i);
			String plusDayStr = plusDay.format(formatter);
			travelDateList.add(plusDayStr);
			
			if (endLocal.isEqual(plusDay)) {
				break;
			}
			
			i++;
		}
		
		return travelDateList;
	}
	
	
	public void addItinerary(int travelId, String color, String title) {
		itineraryDAO.insertItinerary(travelId, color, title);
	}
	
	public Itinerary getItineraryById(int Itinerary) {
		return itineraryDAO.selectItineraryById(Itinerary);
	}
	
	public List<Itinerary> getItineraryListById(int id, int travelId) {
		return itineraryDAO.selectItineraryListById(id, travelId);
	}
}
