package com.travelplans.my_travel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.travelplans.my_travel.model.Trip;

@Repository
public interface MytravelDAO {
	
	public void insertTrip(
			@Param("userId") int userId, 
			@Param("title") String title, 
			@Param("color") String color, 
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate);
	
	public void insertTraffic(
			@Param("tripId") int tripId,
			@Param("traffic") String traffic,
			@Param("trafficInfo") String trafficInfo,
			@Param("start") String start,
			@Param("startDate") String startDate, 
			@Param("startTime") String startTime,
			@Param("arrive") String arrive,
			@Param("arriveDate") String arriveDate,
			@Param("arriveTime") String arriveTime,
			@Param("price") Integer price,
			@Param("memo") String memo);
	
	public void insertAccommodation(
			@Param("tripId") int tripId, 
			@Param("name") String name, 
			@Param("date") String date, 
			@Param("location") String location, 
			@Param("price") Integer price, 
			@Param("memo") String memo);
	
	public void insertReservation(
			@Param("tripId") int tripId,
			@Param("title") String title, 
			@Param("booker") String booker, 
			@Param("date") String date, 
			@Param("location") String location, 
			@Param("price") Integer price, 
			@Param("memo") String memo);
	
	public Trip selectLastTrip();
	
	
	
}

