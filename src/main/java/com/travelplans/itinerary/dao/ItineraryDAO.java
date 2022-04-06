package com.travelplans.itinerary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.travelplans.itinerary.model.Itinerary;

@Repository
public interface ItineraryDAO {
	
	public void insertItinerary(
			@Param("travelId") int travelId, 
			@Param("color") String color, 
			@Param("title") String title);
	
	
	public Itinerary selectItineraryById(int Itinerary);
	
	public List<Itinerary> selectItineraryListById(
			@Param("id") int id,
			@Param("travelId") int travelId);
}
