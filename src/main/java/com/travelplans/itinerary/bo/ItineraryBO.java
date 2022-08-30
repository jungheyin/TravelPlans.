package com.travelplans.itinerary.bo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.itinerary.dao.ItineraryDAO;
import com.travelplans.itinerary.model.Itinerary;
import com.travelplans.plan.bo.PlanBO;

@Service
public class ItineraryBO {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private ItineraryDAO itineraryDAO;
	
	@Autowired
	private PlanBO planBO;
	
	
	public int addItinerary(int travelId, String date, String title) {
		return itineraryDAO.insertItinerary(travelId, date, title);
	}
	
	public Itinerary getItineraryByTravelIdDate(int travelId, String date) {
		return itineraryDAO.selectItineraryByTravelIdDate(travelId, date);
	}
	
	public List<Itinerary> getItineraryByTravelId (int travelId) {
		
		return itineraryDAO.selectItineraryByTravelId(travelId);
		
	}
	public Itinerary getItineraryById(int itineraryId) {
		return itineraryDAO.selectItineraryById(itineraryId);
	}
	
	public int updateItinerary(int itineraryId, int travelId, String date, String title) {
		
		// itinerary 가져오기
		Itinerary itineraryById = getItineraryById(itineraryId);
		
		if (itineraryById == null) {
			logger.error("[update / Itinerary] itineraryBO null itineraryId: " + itineraryId);
			return 0;
		}
		
		return itineraryDAO.updateItinerary(itineraryId, travelId, date, title);
	}
	
	public void deleteItineraryByTravelId(int travelId) {
		
		List<Itinerary> itineraryList = getItineraryByTravelId(travelId);
		
		if (itineraryList.size() < 0 ) {
			logger.error("[delete / itinerary] itineraryBO itineraryList.size() < 0 travelId : " + travelId);
			
		}
		
		itineraryDAO.deleteItineraryByTravelId(travelId);
	}
	
	// itineraryPrice 
	public int generateItineraryPrice(int travelId) {
		
		List<Itinerary> itineraryList = getItineraryByTravelId(travelId);
		
		// 결과 List
		List<Integer> itineraryPriceList = new ArrayList<>();
		int itineraryPrice = 0;
		
		for (int i = 0; i < itineraryList.size(); i++) {
			
			int planPrice = planBO.generatePlanPrice(itineraryList.get(i).getId());
			
			itineraryPrice = itineraryPrice + planPrice;
							
		}
		
		return itineraryPrice;
		
	}
	
}
