package com.capgemini;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.cap.anurag.entity.Seats;
import com.cap.anurag.exception.InvalidDetailsException;
import com.cap.anurag.service.MovieServiceInterface;

public class ListOfSeats {

	@Autowired
	private MovieServiceInterface movieservice;
	@Test
	void setSeats() throws InvalidDetailsException{
		Seats seats=new Seats();
		seats.setAvailable_seats(90);
		seats.setPrice(50);
		seats.setSno(3);
		seats.setSeat_type("LOWER");
		String s1=movieservice.setSeats(seats);
		String s="updated successfully!";
		Assertions.assertEquals(s, s1);
		
	}
	
}
