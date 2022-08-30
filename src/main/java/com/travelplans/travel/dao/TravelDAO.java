package com.travelplans.travel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.travelplans.travel.model.Travel;

@Repository
public interface TravelDAO {
	
	public void insertTravel(
			@Param("userId") int userId, 
			@Param("title") String title, 
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate);
	
	public Travel selectTravelByTravelId(int travelId);
	
	public Travel selectTravelByUserIdDescLimit1(int userId);
	
	public Travel selectTravelByTravelIdUserId(
			@Param("travelId") int travelId, 
			@Param("userId") int userId);
	
	public List<Travel> selectTravelListByUserIdDesc(int userId);
	
	public List<Travel> selectTravelListByTravelId(int travelId);
	
	public int updateTravelByIdUserId(
			@Param("travelId") int travelId, 
			@Param("userId") int userId, 
			@Param("title") String title, 
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate);
	
	public int deleteTravelByTravelIdUserId(
			@Param("travelId") int travelId, 
			@Param("userId") int userId);
	
	public int deleteTravelByUserId(int userId);
}

