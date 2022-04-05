package com.travelplans.new_travel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.travelplans.new_travel.model.Travel;

@Repository
public interface NewTravelDAO {
	
	public void insertTravel(
			@Param("userId") int userId, 
			@Param("title") String title, 
			@Param("color") String color, 
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate);
	
	public Travel selectTravelById(int id);
	
	public List<Travel> selectTravelListById(int id);
	
	public int updateTravelByIdUserId(
			@Param("travelId") int travelId, 
			@Param("userId") int userId, 
			@Param("title") String title, 
			@Param("color") String color, 
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate);
	
	
}

