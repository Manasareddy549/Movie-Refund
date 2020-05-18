package com.cap.anurag.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.anurag.entity.Payments;
import com.cap.anurag.exception.InvalidDetailsException;
import com.cap.anurag.service.MovieServiceInterface;

@RestController
@CrossOrigin("http://localhost:4200")
public class MovieController {
	
	@Autowired
	private MovieServiceInterface movieservice;
	//refund details
	@GetMapping("/refund/{acc_no}/{book_id}")
	public Payments refund(@PathVariable("acc_no") int accno, @PathVariable("book_id") int bookingid)
	{
		return movieservice.refund(accno, bookingid);
	}
	//updating payment
			@PutMapping("/update_payment")
			public String updatePayment(@RequestBody Payments payment)throws InvalidDetailsException {
				String string = movieservice.updatePayment(payment);
				return string;
			}
}