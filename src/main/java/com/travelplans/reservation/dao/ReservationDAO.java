package com.travelplans.reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.travelplans.reservation.model.Accommodation;
import com.travelplans.reservation.model.Reservation;
import com.travelplans.reservation.model.Traffic;
import com.travelplans.travel.model.Travel;

@Repository
public interface ReservationDAO {

	public void insertTraffic(
			@Param("travelId") int tripId,
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
			@Param("travelId") int tripId, 
			@Param("name") String name, 
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate, 
			@Param("location") String location, 
			@Param("price") Integer price, 
			@Param("memo") String memo);
	
	public void insertReservation(
			@Param("travelId") int tripId,
			@Param("title") String title, 
			@Param("booker") String booker, 
			@Param("date") String date, 
			@Param("location") String location, 
			@Param("price") Integer price, 
			@Param("memo") String memo);
	
	public Traffic selectTrafficById(int trafficId);
	
	public Accommodation selectAccommodationById (int accommodationId);
	
	public List<Traffic> selectTrafficList(int travelId);
	
	public List<Accommodation> selectAccommodationList(int travelId);
	
	public List<Reservation> selectReservationList(int travelId);
	
	public Reservation selectReservationById(int reservationId);
	
	public int updateTrafficByIdTravelId(
			@Param("trafficId") int trafficId,
			@Param("travelId") int travelId,
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
	
	public int updateAccommodation(
			@Param("accommodationId") int accommodationId, 
			@Param("travelId") int travelId, 
			@Param("name") String name, 
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate, 
			@Param("location") String location, 
			@Param("price") Integer price, 
			@Param("memo") String memo);
	
	public int updateReservation(
			@Param("reservationId") int reservationId,
			@Param("travelId") int tripId,
			@Param("title") String title, 
			@Param("booker") String booker, 
			@Param("date") String date, 
			@Param("location") String location, 
			@Param("price") Integer price, 
			@Param("memo") String memo);
	
	
	public int deleteTrafficByTrafficIdTravelId(
			@Param("trafficId") int trafficId, 
			@Param("travelId") int travelId);
	
	public void deleteTrafficByTravelId(int travelId);
	
	public int deleteAccommodationByAccommodationIdTravelId(
			@Param("accommodationId") int accommodationId, 
			@Param("travelId") int travelId);
	
	public void deleteAccommodationByTravelId(int travelId);
	
	public int deleteReservationByReservationIdTravelId(
			@Param("reservationId") int reservationId, 
			@Param("travelId") int travelId);
	
	public void deleteReservationByTravelId(int travelId);
}


