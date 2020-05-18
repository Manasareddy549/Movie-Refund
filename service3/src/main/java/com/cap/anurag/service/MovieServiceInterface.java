package com.cap.anurag.service;

import com.cap.anurag.entity.Seats;
import com.cap.anurag.exception.InvalidDetailsException;
public interface MovieServiceInterface {

	Seats seatDetails(String s_type);
	String setSeats(Seats seat) throws InvalidDetailsException;
	
}
