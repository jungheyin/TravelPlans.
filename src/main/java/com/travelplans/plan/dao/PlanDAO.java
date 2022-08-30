package com.travelplans.plan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.travelplans.plan.model.Plan;

@Repository
public interface PlanDAO {
	
	public void insertPlan(
			@Param("travelId") int travelId, 
			@Param("itineraryId") int itineraryId, 
			@Param("date") String date, 
			@Param("planName") String planName, 
			@Param("time") String time,
			@Param("location") String location, 
			@Param("memo") String memo, 
			@Param("price") int price);
	
	public List<Plan> selectPlanListByItineraryId (int itineraryId);
	
	public List<Plan> selectPlanListByTravelId (int travelId);
	
	public List<Plan> selectPlanListByTravelIdItineraryId(
			@Param("travelId") int travelId, 
			@Param("itineraryId") int itineraryId);
	
	public Plan selectPlanByPlanId (int planId);
	
	public int updatePlan(
			@Param("planId") int planId, 
			@Param("travelId") int travelId,
			@Param("itineraryId") int itineraryId, 
			@Param("date") String date, 
			@Param("planName") String planName, 
			@Param("time") String time,
			@Param("location") String location, 
			@Param("memo") String memo, 
			@Param("price") int price);
	
	public int deletePlan(int planId);
	
	public int deletePlanByItineraryId(int itineraryId);
	
	public void deletePlanByTravelId(int travelId);
}
