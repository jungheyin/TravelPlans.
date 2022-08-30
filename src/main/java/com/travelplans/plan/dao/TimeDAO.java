package com.travelplans.plan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.travelplans.plan.model.Time;

@Repository
public interface TimeDAO {

	public int selectTimeCountByTravelIdItineraryIdPlanId(
			@Param("travelId") int travelId,
			@Param("itineraryId") int itineraryId,
			@Param("planId") int planId);
	
	public List<Time> selectTimeByTravelIdItineraryId(
			@Param("travelId") int travelId,
			@Param("itineraryId") int itineraryId);
	
	public Time selectTimeByTravelIdItineraryIdPlanId(
			@Param("travelId") int travelId,
			@Param("itineraryId") int itineraryId,
			@Param("planId") int planId);
	
	public void insertTime(
			@Param("travelId") int travelId,
			@Param("itineraryId") int itineraryId,
			@Param("planId") int planId);
	
	public void deleteTimeByTravelIdItineraryIdPlanId(
			@Param("travelId") int travelId,
			@Param("itineraryId") int itineraryId,
			@Param("planId") int planId);
}
