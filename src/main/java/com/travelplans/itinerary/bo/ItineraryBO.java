package com.travelplans.itinerary.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.itinerary.dao.ItineraryDAO;
import com.travelplans.itinerary.model.Itinerary;
import com.travelplans.new_travel.bo.NewTravelBO;

@Service
public class ItineraryBO {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private ItineraryDAO itineraryDAO;
	
	public int addItinerary(int travelId, String date, String title) {
		return itineraryDAO.insertItinerary(travelId, date, title);
	}
	
	public Itinerary getItineraryByTravelIdDate(int travelId, String date) {
		return itineraryDAO.selectItineraryByTravelIdDate(travelId, date);
	}
	
	public Itinerary getItineraryById(int itineraryId) {
		return itineraryDAO.selectItineraryById(itineraryId);
	}
	
	
	public int updateItinerary(int itineraryId, int travelId, String date, String title, String color) {
		
		// itineraryId 가져오기
		Itinerary itineraryById = getItineraryById(itineraryId);
		
		if (itineraryById == null) {
			logger.error("[update Itinerary] null itineraryId " + itineraryId);
			return 0;
		}
		
		return itineraryDAO.updateItinerary(itineraryId, travelId, date, title, color);
	}
}
