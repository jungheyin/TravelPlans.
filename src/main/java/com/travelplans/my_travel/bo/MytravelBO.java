package com.travelplans.my_travel.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplans.my_travel.dao.MytravelDAO;

@Service
public class MytravelBO {
	
	@Autowired
	private MytravelDAO mytravelDAO;

	public int addTraffic(String traffic, String trafficInfo, String start, String startDate, String startTime,
			String arrive, String arriveDate, String arriveTime, String price, String memo) {
		
		
		return mytravelDAO.insertTraffic(traffic, trafficInfo, start, startDate, startTime,
					arrive, arriveDate, arriveTime, price, memo);
		
	};
}
