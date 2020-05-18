package com.cap.anurag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.anurag.entity.Refund;

import com.cap.anurag.service.MovieServiceInterface;

@RestController
@CrossOrigin("http://localhost:4200")
public class MovieController {
		
	@Autowired
	private MovieServiceInterface movieservice;

	//refund details
	@PostMapping("/refund_details")
	public String refundDetails(@RequestBody Refund refund) {
		String string = movieservice.refundDetails(refund);
		return string;
	}
	//list refund details
		@GetMapping("/listrefund")
		public	List<Refund> getRefundList(){
		List<Refund> list= movieservice.getRefundList();
		return list;
		}
		
	}