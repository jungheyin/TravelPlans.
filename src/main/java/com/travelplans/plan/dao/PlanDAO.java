package com.travelplans.plan.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanDAO {

	public void insertPlan(
			@Param("itineraryId") int itineraryId, 
			@Param("date") String date, 
			@Param("planName") String planName, 
			@Param("time") String time,
			@Param("location") String location, 
			@Param("memo") String memo, 
			@Param("price") int price);
	
	
	
	
	
	
}
