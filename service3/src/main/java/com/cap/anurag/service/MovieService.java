package com.cap.anurag.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.anurag.dao.SeatsDao;
import com.cap.anurag.entity.Seats;
import com.cap.anurag.exception.InvalidDetailsException;
@Service
@Transactional
public class MovieService implements MovieServiceInterface  {
	@Autowired
	private SeatsDao seats;

	//Fetching remaining seats info
		@Override
		public Seats seatDetails(String s_type) {
			return seats.seatDetails(s_type);
		}
		//Updating seats after refund
		@Override
		public String setSeats(Seats seat)  throws InvalidDetailsException{
			boolean bool = seats.existsById(seat.getSno());
			if(bool) 
			{
				seats.save(seat);
				return "seats updated successfully!!";
			}
			else {
				throw new InvalidDetailsException("Sorry!! particular seats does not exist");
				//return "Sorry!! particular seats does not exist";
			}
		}
		
	}