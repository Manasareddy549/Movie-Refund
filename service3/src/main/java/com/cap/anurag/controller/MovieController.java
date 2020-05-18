package com.cap.anurag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.anurag.entity.Seats;
import com.cap.anurag.exception.InvalidDetailsException;
import com.cap.anurag.service.MovieServiceInterface;

@RestController
@CrossOrigin("http://localhost:4200")
public class MovieController {
	@Autowired
	private MovieServiceInterface movieservice;

	// seats information
	@GetMapping("/seat_details/{seat_type}")
	public Seats seatDetails(@PathVariable("seat_type") String seattype) {
		return movieservice.seatDetails(seattype);
	}

	// updating seats
	@PutMapping("/set_seats")
	public String setSeats(@RequestBody Seats seat) throws InvalidDetailsException {
		String string = movieservice.setSeats(seat);
		if (string != null) {
			return "updated successfully!";
		} else {

			return "seats not updated";
		}
	}

}