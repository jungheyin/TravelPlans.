package com.travelplans.my_travel.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MytravelDAO {
	
	public int insertTraffic(
			@Param("traffic") String traffic, 
			@Param("trafficInfo") String trafficInfo, 
			@Param("start") String start, 
			@Param("startDate") String startDate, 
			@Param("startTime") String startTime,
			@Param("arrive") String arrive, 
			@Param("arriveDate") String arriveDate, 
			@Param("arriveTime") String arriveTime, 
			@Param("price") String price, 
			@Param("memo") String memo);

}
