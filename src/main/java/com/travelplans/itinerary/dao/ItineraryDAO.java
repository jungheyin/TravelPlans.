	package com.travelplans.itinerary.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.travelplans.itinerary.model.Itinerary;

@Repository
public interface ItineraryDAO {
	

	public int insertItinerary(
			@Param("travelId") int travelId, 
			@Param("date") String date, 
			@Param("title") String title);
	
	public Itinerary selectItineraryByTravelIdDate(
			@Param("travelId") int travelId, 
			@Param("date") String date);
	
	public List<Itinerary> selectItineraryByTravelId (int travelId);
	
	public Itinerary selectItineraryById(int itineraryId);
	
	public int updateItinerary(
			@Param("itineraryId") int itineraryId, 
			@Param("travelId") int travelId, 
			@Param("date") String date, 
			@Param("title") String title);
	
}
